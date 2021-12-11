package com.example.finalexam323347;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class DisplayName extends HttpServlet {
    private String message;

    public void init() {
        message = "Add an entry";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<div><label for=\"cno\"><b>Customer Number:<b></label><br/>\n" +
                "        <input type=\"text\" id=\"cno\">\n" +
                "    </div>");
        out.println("<div><label for=\"cname\"><b>Customer Name:<b></label><br/>\n" +
                "        <input type=\"text\" id=\"cname\">\n" +
                "    </div>");
        out.println("<div><label for=\"cdep\"><b>Customer Deposit:<b></label><br/>\n" +
                "        <input type=\"text\" id=\"cdep\">\n" +
                "    </div>");
        out.println("<div><label for=\"nyears\"><b>Number of years:<b></label><br/>\n" +
                "        <input type=\"text\" id=\"nyears\">\n" +
                "    </div>");
        out.println("<div><label for=\"stype\"><b>Savings Type:<b></label><br/>\n" +
                "        <input type=\"text\" id=\"stype\">\n" +
                "    </div><br/><button>Submit</button>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}