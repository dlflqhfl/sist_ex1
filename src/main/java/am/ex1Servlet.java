package am;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ex1Servlet", value = "/ex1Servlet")
public class ex1Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //응답시 한글처리
        resp.setContentType("text/html; charset=UTF-8");
        // 응답(response)을 하기 위해 스트림을 준비한다
        PrintWriter out = resp.getWriter();

        //응답시작
        out.println("<h1>My Servlet</h1>");
        out.println("<h2>서블릿 예제입니다. 와~ 서버프로그래밍</h2>");

        //스트림 닫기
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
    }
}
