package com.sga.authkeycloack.configs;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeycloackSecurity {

    Keycloak keycloak;

    @Value("${keycloak.admin.username}")
    private String adminUsername;

    @Value("${keycloak.url}")
    private String baseUrl;

    @Value("${keycloak.admin.password}")
    private String adminPassword;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.admin.clientId}")
    private String clientId;

    public Keycloak getKeycloak(){
        if(keycloak == null){
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(baseUrl).realm(realm)
                    .clientId(clientId).grantType("password")
                    .username(adminUsername).password(adminPassword)
                    .build();
        }

        return keycloak;
    }
}
