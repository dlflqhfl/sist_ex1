package pm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ex6", value = "/ex6Servlet")
public class ex6Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String u_id = req.getParameter("u_id");
        String u_pw = req.getParameter("u_pw");
        String u_name = req.getParameter("u_name");
        String[] u_email = req.getParameterValues("u_email");
        String[] u_hobby = req.getParameterValues("m_hobby");

        PrintWriter out = resp.getWriter();

        //응답시작
        out.println("<h1>받은 값</h1>");
        out.println("<hr/>");
        out.println("<p>ID: " + u_id + "</p>");
        out.println("<p>Password: " + u_pw + "</p>");
        out.println("<p>Name: " + u_name + "</p>");
        out.println("<p>Email: " + u_email[0] + "@" + u_email [1] + "</p>");
        out.println("</p>");
        out.println("<p>Hobbies: ");
        if (u_hobby != null) {
            for (String hobby : u_hobby) {
                out.println(hobby + " ");
            }
        }
        out.println("</p>");
        out.close();
    }
}