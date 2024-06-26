package io.quarkus.hibernate.orm.panache.deployment.test.multiple_pu;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hamcrest.Matchers;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import io.quarkus.hibernate.orm.panache.deployment.test.multiple_pu.first.FirstEntity;
import io.quarkus.hibernate.orm.panache.deployment.test.multiple_pu.second.SecondEntity;
import io.quarkus.test.QuarkusUnitTest;
import io.restassured.RestAssured;

public class DefaultPersistenceUnitFileTest {

    @RegisterExtension
    static QuarkusUnitTest runner = new QuarkusUnitTest()
            .withApplicationRoot((jar) -> jar
                    .addClasses(FirstEntity.class, SecondEntity.class, PanacheTestResource.class)
                    .addAsManifestResource("META-INF/some-persistence.xml", "persistence.xml")
                    .addAsResource(new StringAsset(
                            "quarkus.datasource.db-kind=h2\n" +
                                    "quarkus.datasource.jdbc.url=jdbc:h2:mem:default;DB_CLOSE_DELAY=-1"),
                            "application.properties"));

    @Test
    public void panacheOperations() {
        /**
         * First entity operations
         */
        RestAssured.when().get("/persistence-unit/first/name-1").then().body(Matchers.is("1"));
        RestAssured.when().get("/persistence-unit/first/name-2").then().body(Matchers.is("2"));

        /**
         * second entity operations
         */
        RestAssured.when().get("/persistence-unit/second/name-1").then().body(Matchers.is("1"));
        RestAssured.when().get("/persistence-unit/second/name-2").then().body(Matchers.is("2"));
    }

    @Test
    void entityManagerShouldExist() {
        assertNotNull(FirstEntity.getEntityManager());

        assertNotNull(SecondEntity.getEntityManager());
    }

    @Test
    void sessionShouldExist() {
        assertNotNull(FirstEntity.getSession());

        assertNotNull(SecondEntity.getSession());
    }
}
