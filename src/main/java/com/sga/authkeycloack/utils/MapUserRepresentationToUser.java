package com.sga.authkeycloack.utils;

import com.sga.authkeycloack.domain.User;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.ArrayList;
import java.util.List;

public class MapUserRepresentationToUser {
    public static User mapUserToUser(UserRepresentation userRepresentation){
        User user = new User();
        user.setUserName(userRepresentation.getUsername());
        user.setEmail(userRepresentation.getEmail());
        user.setFirstName(userRepresentation.getFirstName());
        user.setLastName(userRepresentation.getLastName());
        return user;
    }

    public static UserRepresentation mapUserToUserRepresentation(User user){
//        UserRepresentation userRep = new UserRepresentation();
//        userRep.setUsername(user.getUserName());
//        userRep.setEmail(user.getEmail());
//        userRep.setFirstName(user.getFirstName());
//        userRep.setLastName(user.getLastName());
//        userRep.setEnabled(true);
//        userRep.setEmailVerified(true);
//
//        List<CredentialRepresentation> credentials = new ArrayList<>();
//
//        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
//
//        credentialRepresentation.setTemporary(false);
//        credentialRepresentation.setValue(user.getPassword());
//        credentials.add(credentialRepresentation);
//
//        userRep.setCredentials(credentials);
//        return userRep;

        UserRepresentation userRep = new UserRepresentation();
        userRep.setUsername("john_doe");
        userRep.setEmail("john.doe@example.com");
        userRep.setFirstName("John");
        userRep.setLastName("Doe");
        userRep.setEnabled(true);
        userRep.setEmailVerified(true);

        List<String> rolesRealm = new ArrayList<>();
        rolesRealm.add("default-roles-sga");
        rolesRealm.add("uma_authorization");
        rolesRealm.add("offline_access");
        userRep.setRealmRoles(rolesRealm);

        List<CredentialRepresentation> credentials = new ArrayList<>();
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setTemporary(false);
        credentialRepresentation.setValue("password123");
        credentials.add(credentialRepresentation);
        userRep.setCredentials(credentials);

        return userRep;
    }


}
