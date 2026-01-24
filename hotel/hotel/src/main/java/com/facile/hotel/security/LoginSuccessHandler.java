package com.facile.hotel.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        for (GrantedAuthority auth : authentication.getAuthorities()) {

            String role = auth.getAuthority();

            if (role.equals("ROLE_ADMIN")) {
                response.sendRedirect("/admin/dashboard");
                return;
            }

            if (role.equals("ROLE_LIMPIEZA")) {
                response.sendRedirect("/limpieza");
                return;
            }

            if (role.equals("ROLE_MANTENIMIENTO")) {
                response.sendRedirect("/mantenimiento");
                return;
            }

            if (role.equals("ROLE_USER")) {
                response.sendRedirect("/dashboard");
                return;
            }
        }

        response.sendRedirect("/login");
    }
}
