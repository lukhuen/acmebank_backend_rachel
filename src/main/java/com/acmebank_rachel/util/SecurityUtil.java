package com.acmebank_rachel.util;

import com.acmebank_rachel.domain.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.security.Principal;

public class SecurityUtil {
    public static User getUser(Principal principal){
        if (principal instanceof PreAuthenticatedAuthenticationToken) {
            PreAuthenticatedAuthenticationToken preAuthenticated
                    = (PreAuthenticatedAuthenticationToken) principal;
            if (preAuthenticated.getPrincipal() instanceof User) {
                //as firebaseToken has been put into the principal box in preAuthenticated box
                return (User) preAuthenticated.getPrincipal();
            }
        }
        return null;
    }
}
