package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.Arrays;

@WebServlet(name = "ex4", value = "/ex4")
public class ex4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //응답시 한글처리
        resp.setContentType("text/html; charset=UTF-8");
        //요청시 한글처리
        req.setCharacterEncoding("UTF-8");

        //파라미터들 받기
        String name = req.getParameter("m_name");
        String[] hobbies = req.getParameterValues("m_hobby"); //배열로 받아옵니다.

        resp.getWriter().println("<h2>받은 이름:" + name + "<h2>");

        resp.getWriter().print("<h2>받은 취미: <h2>" );

        if(hobbies != null){
            for(String hobby : hobbies){
                resp.getWriter().print(hobby);
                // 이 곳에서 취미 값을 처리합니다. 예를 들어, 화면에 출력하거나 데이터베이스에 저장할 수 있습니다.
            }
        }
    }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
        }
}
