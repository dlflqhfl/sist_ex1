package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ex3", value = "/ex3")
public class ex3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //응답시 한글처리
        resp.setContentType("text/html; charset=UTF-8");
        //요청시 한글처리
        req.setCharacterEncoding("UTF-8");

        //파라미터들 받기
        String id= req.getParameter("m_id");
        String name= req.getParameter("m_name");
        String addr= req.getParameter("m_addr");

        resp.getWriter().println("<h2>받은 ID:" + id + "<h2>");
        resp.getWriter().println("<h2>받은 이름:" + name + "<h2>");
        resp.getWriter().println("<h2>받은 주소:" + addr + "<h2>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
