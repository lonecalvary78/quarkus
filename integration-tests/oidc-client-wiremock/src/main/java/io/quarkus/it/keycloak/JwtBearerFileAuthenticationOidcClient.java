package io.quarkus.it.keycloak;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.client.filter.OidcClientFilter;

@RegisterRestClient
@OidcClientFilter("jwtbearer-file")
@Path("/")
public interface JwtBearerFileAuthenticationOidcClient {

    @GET
    String echoToken();
}
