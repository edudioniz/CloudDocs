/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudsign.servlets;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxSessionStore;
import com.dropbox.core.DbxStandardSessionStore;
import com.dropbox.core.DbxWebAuth;
import com.google.api.client.googleapis.auth.oauth2.GoogleBrowserClientRequestUrl;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eduardo
 */

@WebServlet(urlPatterns = {"/oauth"})
public class InitAuthServlet extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
         // Select a spot in the session for DbxWebAuth to store the CSRF token.
        /*HttpSession session = req.getSession(true);
        String sessionKey = "dropbox-auth-csrf-token";
        DbxSessionStore csrfTokenStore = new DbxStandardSessionStore(session, sessionKey);

        // Build an auth request
        DbxWebAuth.Request authRequest = DbxWebAuth.newRequestBuilder()
            .withRedirectUri(redirectUri, csrfTokenStore)
            .build();

        // Start authorization.
        String authorizePageUrl = auth.authorize(authRequest);

        // Redirect the user to the Dropbox website so they can approve our application.
        // The Dropbox website will send them back to "http://my-server.com/dropbox-auth-finish"
        // when they're done.
        response.sendRedirect(authorizePageUrl);*/
        String url = new GoogleBrowserClientRequestUrl("247410889511-svsohn3f0vucpjvrueesdvv4v6srhjnh.apps.googleusercontent.com",
            "http://localhost:8080/callback", Arrays.asList(
            "https://www.googleapis.com/auth/userinfo.email",
            "https://www.googleapis.com/auth/userinfo.profile")).setState("/profile").build();
        resp.sendRedirect(url);
    }

        
}