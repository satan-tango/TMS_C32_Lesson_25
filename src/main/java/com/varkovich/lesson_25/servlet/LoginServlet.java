package com.varkovich.lesson_25.servlet;


import com.varkovich.lesson_25.storage.MockStorage;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //localhost:8081/login?login=user&pass=user
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if (login != null && pass != null) {
            if (MockStorage.doesUserExist(pass, login)) {
                HttpSession session = request.getSession();
                if (session.getAttribute("login") != null) {
                    if (session.getAttribute("login").equals(login)) {
                        writer.println("<h2>You are already authenticated</h2>");
                    } else {
                        session.removeAttribute("login");
                        session.removeAttribute("role");
                        session.setAttribute("login", login);
                        session.setAttribute("role", MockStorage.getRole(login, pass));
                        writer.println("<h2>authentication was successful</h2>");
                    }
                } else {
                    session.setAttribute("login", login);
                    session.setAttribute("role", MockStorage.getRole(login, pass));
                    writer.println("<h2>authentication was successful</h2>");
                }
            } else {
                writer.println("<h2>Incorrect login or password</h2>");
            }
        } else {
            writer.println("<h2>Invalid input</h2>");
        }


    }
}
