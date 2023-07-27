package jame9.Translate9;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "Translate9", value = "/Translate9")
public class Translate9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");

        writer.println("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<style type=\"text/css\">\n" +
                "    .login {\n" +
                "        height:165px; width:260px;\n" +
                "        margin:0;\n" +
                "        padding:10px;\n" +
                "        border:1px #CCC solid;\n" +
                "    }\n" +
                "    .login input {\n" +
                "        padding:5px; margin:5px\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "<form action=\"http://localhost:8080/Translate9\" method=\"post\">\n" +
                "    <div class=\"login\">\n" +
                "        <h2>Vietnamese Dictionary</h2>\n" +
                "        <input type=\"text\" name=\"txtSearch\" size=\"30\" placeholder=\"Enter your word\" />\n" +
                "        <input type=\"submit\" id = \"submit\" value = \"Search\"/>\n" +
                "    </div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("hello","Xin chào");
        dictionary.put("computer","Máy tính");
        dictionary.put("blue","Màu xanh lục");
        dictionary.put("green","Màu xanh lá");
        dictionary.put("red","Màu đỏ");
        dictionary.put("yellow","Màu vàng");

        String txtSearch = request.getParameter("txtSearch");
        String result = dictionary.get(txtSearch);
        writer.println("<html>");
        if (result != null){
            writer.println("Word: " + txtSearch);
            writer.println("Result: " + result);
        }else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }
}