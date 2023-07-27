package jame9.CurrencyConversion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CurrencyConversion", value = "/CurrencyConversion")
public class CurrencyConversion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        response.setContentType("text/html");

        writer.println("<!DOCTYPE HTML>\n" +
                "<html>\n" +
                "<style type=\"text/css\">\n" +
                "    .login {\n" +
                "        height:280px; width:260px;\n" +
                "        margin:0;\n" +
                "        padding:10px;\n" +
                "        border:1px #CCC solid;\n" +
                "    }\n" +
                "    .login input {\n" +
                "        padding:5px; margin:5px\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "<form action=\"http://localhost:8080/CurrencyConversion\" method=\"post\">\n" +
                "    <div class=\"login\">\n" +
                "        <h2>Chuyển đổi tiền tệ</h2>\n" +
                "        <p>Rate</p>" +
                "        <input type=\"text\" name=\"rate\" size=\"30\"  placeholder=\"Nhập giá trị chuyển đổi\" />\n" +
                "        <p>USD</p>" +
                "        <input type=\"text\" name=\"USD\" size=\"30\" placeholder=\"Nhập số tiền muốn chuyển\" />\n" +
                "        <input type=\"submit\" id = \"submit\" value = \"Converter\"/>\n" +
                "    </div>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Float rate = Float.parseFloat(request.getParameter("rate"));
        Float usd = Float.parseFloat(request.getParameter("USD"));
        Float vnd = rate * usd;

        writer.println("<h2>Rate: " + rate + "</h2>");
        writer.println("<h2>USD: " + usd + "</h2>");
        writer.println("<h2>VND: " + vnd + "</h2>");
    }
}