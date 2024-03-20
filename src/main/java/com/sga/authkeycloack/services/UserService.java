package com.sga.authkeycloack.services;

import com.sga.authkeycloack.configs.KeycloackSecurity;
import com.sga.authkeycloack.domain.User;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.util.List;

@Service
public class UserService {

    @Value("${keycloak.admin.username}")
    private String adminUsername;

    @Value("${keycloak.admin.password}")
    private String adminPassword;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.admin.token.url}")
    private String adminTokenUrl;

    @Value("${keycloak.user.create.url}")
    private String userCreateUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private KeycloackSecurity keycloackSecurity;


    public List<?> listUsers(){
        Keycloak keycloak = keycloackSecurity.getKeycloak();
        List<UserRepresentation> users = keycloak.realm("sga").users().list();
        return users;
    }

//    public User createUser(User user){
//        Keycloak keycloack = keycloackSecurity.getKeycloak();
//        keycloack.realm("sga").users().create(MapUserRepresentationToUser.mapUserToUserRepresentation(user));
//        return user;
//    }

//    public Response registerUser(User request) {
//        Keycloak keycloack = keycloackSecurity.getKeycloak();
//        UserRepresentation user = new UserRepresentation();
//        user.setEmailVerified(true);
//        user.setEmail(request.getEmail());
//        user.setUsername("aaa");
//        user.setEnabled(true);
//        return keycloack.realm("sga").users().create(user);
//    }
//    public List<UserRepresentation> findByEmail(String email){
//        Keycloak keycloack = keycloackSecurity.getKeycloak();
//       return keycloack.realm("sga").users().searchByEmail(email, true);
//    }

    public void deleteUsers(String id){
        Keycloak keycloack = keycloackSecurity.getKeycloak();
        keycloack.realm("sga").users().delete(id);
    }
}
