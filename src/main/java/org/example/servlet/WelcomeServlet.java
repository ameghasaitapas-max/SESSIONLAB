package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get the existing session
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("username") != null) {

            // Get username from session
            String username =
                    (String) session.getAttribute("username");

            out.println("<html>");
            out.println("<head><title>Welcome</title></head>");
            out.println("<body>");

            out.println("<h2>Welcome " + username + "</h2>");
            out.println("<p>You are successfully logged in.</p>");

            out.println("<br>");
            out.println("<a href='logout'>Logout</a>");

            out.println("</body>");
            out.println("</html>");

        } else {

            // If no session exists
            out.println("<html>");
            out.println("<body>");

            out.println("<h2>Please login first.</h2>");
            out.println("<a href='login.html'>Login</a>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}