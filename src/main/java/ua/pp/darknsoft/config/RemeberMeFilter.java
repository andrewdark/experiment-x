package ua.pp.darknsoft.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemeberMeFilter extends RememberMeAuthenticationFilter {

    public RemeberMeFilter(AuthenticationManager authenticationManager, RememberMeServices rememberMeServices) {
        super(authenticationManager, rememberMeServices);
    }

    protected  void   onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication auth) {
        super.onSuccessfulAuthentication(request, response, auth);
        if (auth != null) {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

}