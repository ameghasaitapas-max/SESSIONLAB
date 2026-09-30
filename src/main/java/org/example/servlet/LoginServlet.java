package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("1234")) {

            // Create session
            HttpSession session = request.getSession();

            // Store username in session
            session.setAttribute("username", username);

            // Go to welcome page
            response.sendRedirect("welcome");

        } else {

            response.setContentType("text/html");

            response.getWriter().println("<h2>Invalid Username or Password</h2>");
            response.getWriter().println("<a href='login.html'>Try Again</a>");
        }
    }
}