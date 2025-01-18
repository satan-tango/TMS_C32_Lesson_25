package com.varkovich.lesson_25.servlet;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (session.getAttribute("role") != null) {
            writer.println("<h3>The person has been identified</h3>");
            writer.println("<p>User name : " + session.getAttribute("login") + "</p>");
            writer.println("<p>Role : " + session.getAttribute("role") + "</p>");
        } else {
            response.sendError(401);
            writer.println("<h3>The person has not been identified</h3>");
        }
    }
}
