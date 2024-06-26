package io.quarkus.spring.data.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.core.Link;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.spring.data.rest.paged.Record;
import io.quarkus.test.QuarkusUnitTest;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

class CrudAndPagedResourceTest {
    @RegisterExtension
    static final QuarkusUnitTest TEST = new QuarkusUnitTest()
            .withApplicationRoot((jar) -> jar
                    .addClasses(AbstractEntity.class, Record.class, CrudAndPagedRecordsRepository.class)
                    .addAsResource("application.properties")
                    .addAsResource("import.sql"));

    @Test
    void shouldGet() {
        given().accept("application/json")
                .when().get("/crud-and-paged-records/1")
                .then().statusCode(200)
                .and().body("id", is(equalTo(1)))
                .and().body("name", is(equalTo("first")));
    }

    @Test
    void shouldNotGetNonExistent() {
        given().accept("application/json")
                .when().get("/crud-and-paged-records/1000")
                .then().statusCode(404);
    }

    @Test
    void shouldGetHal() {
        given().accept("application/hal+json")
                .when().get("/crud-and-paged-records/1")
                .then().statusCode(200)
                .and().body("id", is(equalTo(1)))
                .and().body("name", is(equalTo("first")))
                .and().body("_links.add.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.list.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.self.href", endsWith("/crud-and-paged-records/1"))
                .and().body("_links.update.href", endsWith("/crud-and-paged-records/1"))
                .and().body("_links.remove.href", endsWith("/crud-and-paged-records/1"));
    }

    @Test
    void shouldNotGetNonExistentHal() {
        given().accept("application/hal+json")
                .when().get("/crud-and-paged-records/1000")
                .then().statusCode(404);
    }

    @Test
    void shouldList() {
        Response response = given().accept("application/json")
                .when().get("/crud-and-paged-records")
                .thenReturn();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body().jsonPath().getList("id")).contains(1, 2);
        assertThat(response.body().jsonPath().getList("name")).contains("first", "second");

        Map<String, String> expectedLinks = new HashMap<>(2);
        expectedLinks.put("first", "/crud-and-paged-records?page=0&size=20");
        expectedLinks.put("last", "/crud-and-paged-records?page=0&size=20");
        assertLinks(response.headers(), expectedLinks);
    }

    @Test
    void shouldListHal() {
        given().accept("application/hal+json")
                .when().get("/crud-and-paged-records")
                .then().statusCode(200).log().all()
                .and().body("_embedded.crud-and-paged-records.id", hasItems(1, 2))
                .and().body("_embedded.crud-and-paged-records.name", hasItems("first", "second"))
                .and()
                .body("_embedded.crud-and-paged-records._links.add.href",
                        hasItems(endsWith("/crud-and-paged-records"), endsWith("/crud-and-paged-records")))
                .and()
                .body("_embedded.crud-and-paged-records._links.list.href",
                        hasItems(endsWith("/crud-and-paged-records"), endsWith("/crud-and-paged-records")))
                .and()
                .body("_embedded.crud-and-paged-records._links.self.href",
                        hasItems(endsWith("/crud-and-paged-records/1"), endsWith("/crud-and-paged-records/2")))
                .and()
                .body("_embedded.crud-and-paged-records._links.update.href",
                        hasItems(endsWith("/crud-and-paged-records/1"), endsWith("/crud-and-paged-records/2")))
                .and()
                .body("_embedded.crud-and-paged-records._links.remove.href",
                        hasItems(endsWith("/crud-and-paged-records/1"), endsWith("/crud-and-paged-records/2")))
                .and().body("_links.add.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.list.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.first.href", endsWith("/crud-and-paged-records?page=0&size=20"))
                .and().body("_links.last.href", endsWith("/crud-and-paged-records?page=0&size=20"));
    }

    @Test
    void shouldListFirstPage() {
        Response initResponse = given().accept("application/json")
                .when().get("/crud-and-paged-records")
                .thenReturn();
        List<Integer> ids = initResponse.body().jsonPath().getList("id");
        List<String> names = initResponse.body().jsonPath().getList("name");
        int lastPage = ids.size() - 1;

        Response response = given().accept("application/json")
                .and().queryParam("page", 0)
                .and().queryParam("size", 1)
                .when().get("/crud-and-paged-records")
                .thenReturn();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body().jsonPath().getList("id")).containsOnly(ids.get(0));
        assertThat(response.body().jsonPath().getList("name")).containsOnly(names.get(0));

        Map<String, String> expectedLinks = new HashMap<>(3);
        expectedLinks.put("first", "/crud-and-paged-records?page=0&size=1");
        expectedLinks.put("last", "/crud-and-paged-records?page=" + lastPage + "&size=1");
        expectedLinks.put("next", "/crud-and-paged-records?page=1&size=1");
        assertLinks(response.headers(), expectedLinks);
    }

    @Test
    void shouldListFirstPageHal() {
        Response initResponse = given().accept("application/json")
                .when().get("/crud-and-paged-records")
                .thenReturn();
        List<Integer> ids = initResponse.body().jsonPath().getList("id");
        List<String> names = initResponse.body().jsonPath().getList("name");
        int lastPage = ids.size() - 1;

        given().accept("application/hal+json")
                .and().queryParam("page", 0)
                .and().queryParam("size", 1)
                .when().get("/crud-and-paged-records")
                .then().statusCode(200)
                .and().body("_embedded.crud-and-paged-records.id", contains(ids.get(0)))
                .and().body("_embedded.crud-and-paged-records.name", contains(names.get(0)))
                .and()
                .body("_embedded.crud-and-paged-records._links.add.href",
                        hasItems(endsWith("/crud-and-paged-records"), endsWith("/crud-and-paged-records")))
                .and()
                .body("_embedded.crud-and-paged-records._links.list.href",
                        hasItems(endsWith("/crud-and-paged-records"), endsWith("/crud-and-paged-records")))
                .and()
                .body("_embedded.crud-and-paged-records._links.self.href",
                        contains(endsWith("/crud-and-paged-records/" + ids.get(0))))
                .and()
                .body("_embedded.crud-and-paged-records._links.update.href",
                        contains(endsWith("/crud-and-paged-records/" + ids.get(0))))
                .and()
                .body("_embedded.crud-and-paged-records._links.remove.href",
                        contains(endsWith("/crud-and-paged-records/" + ids.get(0))))
                .and().body("_links.add.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.list.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.first.href", endsWith("/crud-and-paged-records?page=0&size=1"))
                .and().body("_links.last.href", endsWith("/crud-and-paged-records?page=" + lastPage + "&size=1"))
                .and().body("_links.next.href", endsWith("/crud-and-paged-records?page=1&size=1"));
    }

    @Test
    void shouldListLastPage() {
        Response initResponse = given().accept("application/json")
                .when().get("/crud-and-paged-records")
                .thenReturn();
        List<Integer> ids = initResponse.body().jsonPath().getList("id");
        List<String> names = initResponse.body().jsonPath().getList("name");
        int lastPage = ids.size() - 1;

        Response response = given().accept("application/json")
                .and().queryParam("page", lastPage)
                .and().queryParam("size", 1)
                .when().get("/crud-and-paged-records")
                .thenReturn();

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body().jsonPath().getList("id")).containsOnly(ids.get(lastPage));
        assertThat(response.body().jsonPath().getList("name")).containsOnly(names.get(lastPage));

        Map<String, String> expectedLinks = new HashMap<>(3);
        expectedLinks.put("first", "/crud-and-paged-records?page=0&size=1");
        expectedLinks.put("last", "/crud-and-paged-records?page=" + lastPage + "&size=1");
        expectedLinks.put("previous", "/crud-and-paged-records?page=" + (lastPage - 1) + "&size=1");
        assertLinks(response.headers(), expectedLinks);
    }

    @Test
    void shouldListLastPageHal() {
        Response initResponse = given().accept("application/json")
                .when().get("/crud-and-paged-records")
                .thenReturn();
        List<Integer> ids = initResponse.body().jsonPath().getList("id");
        List<String> names = initResponse.body().jsonPath().getList("name");
        int lastPage = ids.size() - 1;

        given().accept("application/hal+json")
                .and().queryParam("page", lastPage)
                .and().queryParam("size", 1)
                .when().get("/crud-and-paged-records")
                .then().statusCode(200)
                .and().body("_embedded.crud-and-paged-records.id", contains(ids.get(lastPage)))
                .and().body("_embedded.crud-and-paged-records.name", contains(names.get(lastPage)))
                .and()
                .body("_embedded.crud-and-paged-records._links.add.href",
                        hasItems(endsWith("/crud-and-paged-records"), endsWith("/crud-and-paged-records")))
                .and()
                .body("_embedded.crud-and-paged-records._links.list.href",
                        hasItems(endsWith("/crud-and-paged-records"), endsWith("/crud-and-paged-records")))
                .and()
                .body("_embedded.crud-and-paged-records._links.self.href",
                        contains(endsWith("/crud-and-paged-records/" + ids.get(lastPage))))
                .and()
                .body("_embedded.crud-and-paged-records._links.update.href",
                        contains(endsWith("/crud-and-paged-records/" + ids.get(lastPage))))
                .and()
                .body("_embedded.crud-and-paged-records._links.remove.href",
                        contains(endsWith("/crud-and-paged-records/" + ids.get(lastPage))))
                .and().body("_links.add.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.list.href", endsWith("/crud-and-paged-records"))
                .and().body("_links.first.href", endsWith("/crud-and-paged-records?page=0&size=1"))
                .and().body("_links.last.href", endsWith("/crud-and-paged-records?page=" + lastPage + "&size=1"))
                .and().body("_links.previous.href", endsWith("/crud-and-paged-records?page=" + (lastPage - 1) + "&size=1"));
    }

    @Test
    void shouldNotGetNonExistentPage() {
        given().accept("application/json")
                .and().queryParam("page", 100)
                .when().get("/crud-and-paged-records")
                .then().statusCode(200)
                .and().body("id", is(empty()));
    }

    @Test
    void shouldNotGetNegativePageOrSize() {
        given().accept("application/json")
                .and().queryParam("page", -1)
                .and().queryParam("size", -1)
                .when().get("/crud-and-paged-records")
                .then().statusCode(200)
                // Invalid page and size parameters are replaced with defaults
                .and().body("id", hasItems(1, 2));
    }

    @Test
    void shouldListAscending() {
        Response response = given().accept("application/json")
                .when().get("/crud-and-paged-records?sort=name,id")
                .thenReturn();

        List<String> actualNames = response.body().jsonPath().getList("name");
        List<String> expectedNames = new LinkedList<>(actualNames);
        expectedNames.sort(Comparator.naturalOrder());
        assertThat(actualNames).isEqualTo(expectedNames);
    }

    @Test
    void shouldListDescending() {
        Response response = given().accept("application/json")
                .when().get("/crud-and-paged-records?sort=-name,id")
                .thenReturn();

        List<String> actualNames = response.body().jsonPath().getList("name");
        List<String> expectedNames = new LinkedList<>(actualNames);
        expectedNames.sort(Comparator.reverseOrder());
        assertThat(actualNames).isEqualTo(expectedNames);
    }

    @Test
    void shouldCreate() {
        Response response = given().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\"name\": \"test-create\"}")
                .when().post("/crud-and-paged-records")
                .thenReturn();
        assertThat(response.statusCode()).isEqualTo(201);

        String location = response.header("Location");
        int id = Integer.parseInt(location.substring(response.header("Location").lastIndexOf("/") + 1));
        JsonPath body = response.body().jsonPath();
        assertThat(body.getInt("id")).isEqualTo(id);
        assertThat(body.getString("name")).isEqualTo("test-create");

        given().accept("application/json")
                .when().get(location)
                .then().statusCode(200)
                .and().body("id", is(equalTo(id)))
                .and().body("name", is(equalTo("test-create")));
    }

    @Test
    void shouldCreateHal() {
        Response response = given().accept("application/hal+json")
                .and().contentType("application/json")
                .and().body("{\"name\": \"test-create-hal\"}")
                .when().post("/crud-and-paged-records")
                .thenReturn();
        assertThat(response.statusCode()).isEqualTo(201);

        String location = response.header("Location");
        int id = Integer.parseInt(location.substring(response.header("Location").lastIndexOf("/") + 1));
        JsonPath body = response.body().jsonPath();
        assertThat(body.getInt("id")).isEqualTo(id);
        assertThat(body.getString("name")).isEqualTo("test-create-hal");
        assertThat(body.getString("_links.add.href")).endsWith("/crud-and-paged-records");
        assertThat(body.getString("_links.list.href")).endsWith("/crud-and-paged-records");
        assertThat(body.getString("_links.self.href")).endsWith("/crud-and-paged-records/" + id);
        assertThat(body.getString("_links.update.href")).endsWith("/crud-and-paged-records/" + id);
        assertThat(body.getString("_links.remove.href")).endsWith("/crud-and-paged-records/" + id);

        given().accept("application/json")
                .when().get(location)
                .then().statusCode(200)
                .and().body("id", is(equalTo(id)))
                .and().body("name", is(equalTo("test-create-hal")));
    }

    @Test
    void shouldCreateAndUpdate() {
        Response createResponse = given().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\"name\": \"test-update-create\"}")
                .when().post("/crud-and-paged-records/")
                .thenReturn();
        assertThat(createResponse.statusCode()).isEqualTo(201);

        String location = createResponse.header("Location");
        int id = Integer.parseInt(location.substring(createResponse.header("Location").lastIndexOf("/") + 1));
        JsonPath body = createResponse.body().jsonPath();
        assertThat(body.getInt("id")).isEqualTo(id);
        assertThat(body.getString("name")).isEqualTo("test-update-create");

        given().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\"id\": \"" + id + "\", \"name\": \"test-update\"}")
                .when().put(location)
                .then()
                .statusCode(204);
        given().accept("application/json")
                .when().get(location)
                .then().statusCode(200)
                .and().body("id", is(equalTo(id)))
                .and().body("name", is(equalTo("test-update")));
    }

    @Test
    void shouldCreateAndUpdateHal() {
        Response createResponse = given().accept("application/hal+json")
                .and().contentType("application/json")
                .and().body("{\"name\": \"test-update-create-hal\"}")
                .when().post("/crud-and-paged-records/")
                .thenReturn();
        assertThat(createResponse.statusCode()).isEqualTo(201);

        String location = createResponse.header("Location");
        int id = Integer.parseInt(location.substring(createResponse.header("Location").lastIndexOf("/") + 1));
        JsonPath body = createResponse.body().jsonPath();
        assertThat(body.getInt("id")).isEqualTo(id);
        assertThat(body.getString("name")).isEqualTo("test-update-create-hal");
        assertThat(body.getString("_links.add.href")).endsWith("/crud-and-paged-records");
        assertThat(body.getString("_links.list.href")).endsWith("/crud-and-paged-records");
        assertThat(body.getString("_links.self.href")).endsWith("/crud-and-paged-records/" + id);
        assertThat(body.getString("_links.update.href")).endsWith("/crud-and-paged-records/" + id);
        assertThat(body.getString("_links.remove.href")).endsWith("/crud-and-paged-records/" + id);

        given().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\"id\": \"" + id + "\", \"name\": \"test-update-hal\"}")
                .when().put(location)
                .then()
                .statusCode(204);
        given().accept("application/json")
                .when().get(location)
                .then().statusCode(200)
                .and().body("id", is(equalTo(id)))
                .and().body("name", is(equalTo("test-update-hal")));
    }

    @Test
    void shouldCreateAndDelete() {
        Response createResponse = given().accept("application/json")
                .and().contentType("application/json")
                .and().body("{\"name\": \"test-delete\"}")
                .when().post("/crud-and-paged-records")
                .thenReturn();
        assertThat(createResponse.statusCode()).isEqualTo(201);

        String location = createResponse.header("Location");
        when().delete(location)
                .then().statusCode(204);
        when().get(location)
                .then().statusCode(404);
    }

    @Test
    void shouldNotDeleteNonExistent() {
        when().delete("/crud-and-paged-records/1000")
                .then().statusCode(404);
    }

    private void assertLinks(Headers headers, Map<String, String> expectedLinks) {
        List<Link> links = new LinkedList<>();
        for (Header header : headers.getList("Link")) {
            links.add(Link.valueOf(header.getValue()));
        }
        assertThat(links).hasSize(expectedLinks.size());
        for (Map.Entry<String, String> expectedLink : expectedLinks.entrySet()) {
            assertThat(links).anySatisfy(link -> {
                assertThat(link.getUri().toString()).endsWith(expectedLink.getValue());
                assertThat(link.getRel()).isEqualTo(expectedLink.getKey());
            });
        }
    }
}
