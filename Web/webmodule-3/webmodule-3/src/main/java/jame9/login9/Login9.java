package jame9.login9;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login9", value = "/Login9")
public class Login9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");

        writer.println("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<style type=\"text/css\">\n" +
                "    .login {\n" +
                "        height:180px; width:260px;\n" +
                "        margin:0;\n" +
                "        padding:10px;\n" +
                "        border:1px #CCC solid;\n" +
                "    }\n" +
                "    .login input {\n" +
                "        padding:5px; margin:5px\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "<form action=\"http://localhost:8080/Login9\" method=\"post\">\n" +
                "    <div class=\"login\">\n" +
                "        <h2>Login</h2>\n" +
                "        <input type=\"text\" name=\"username\" size=\"30\"  placeholder=\"username\" />\n" +
                "        <input type=\"password\" name=\"password\" size=\"30\" placeholder=\"password\" />\n" +
                "        <input type=\"submit\" value=\"Sign in\"/>\n" +
                "    </div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            writer.println("Welcome admin to website");
        }else {
            writer.println("Login Error");
        }
    }
}