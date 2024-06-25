package org.vedu.managerhubfinance.controller.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;
import jakarta.security.enterprise.identitystore.IdentityStoreHandler;

//@ApplicationScoped
public class IdentityStoredApp {

//    @Inject
//    private IdentityStoreHandler identityStoreHandler;
//
//    public CredentialValidationResult validate(UsernamePasswordCredential credential) {
//        String username = credential.getCaller();
//        String password = credential.getPasswordAsString();
//
//        
//        
//        CredentialValidationResult result = identityStoreHandler.validate(credential);
//
//        return result;
//    }
}
