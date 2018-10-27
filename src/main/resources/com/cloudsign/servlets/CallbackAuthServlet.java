/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudsign.servlets;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.sun.org.apache.xpath.internal.operations.Plus;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduardo
 */

@WebServlet(urlPatterns = {"/callback"})
public class CallbackAuthServlet extends HttpServlet {
    
    //http://localhost:8080/callback#state=/profile&
    //access_token=ya29.GlxDBm0WXc_ORcLpT2vZORneZkriYroRl7ssbGTCUrfPI-eqxgQIRtz9unFtsCdVmNP2HtZw0wELdpIfLtHcE9ejAhvDX0PIWKcEkd893AdUVMKoeZ5PPWXDoEvMZg&
    //token_type=Bearer&expires_in=3600&scope=email%20profile%20https://www.googleapis.com/auth/userinfo.profile%20https://www.googleapis.com/auth/userinfo.email
    
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    

    }
    
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            System.err.print(paramName);
            out.write(paramName);
            out.write("n");

            String[] paramValues = req.getParameterValues(paramName);
            for (int i = 0; i < paramValues.length; i++) {
                String paramValue = paramValues[i];
                out.write("t" + paramValue);
                out.write("n");
                System.err.print(paramValue);
            }
        }
        out.close();

    }

}