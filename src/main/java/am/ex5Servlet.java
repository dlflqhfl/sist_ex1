package am;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ex5", value = "/ex5")
public class ex5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //응답시 한글처리
        resp.setContentType("text/html; charset=UTF-8");
        //요청시 한글처리
        req.setCharacterEncoding("UTF-8");


        String[] name = req.getParameterValues("f_name");

        PrintWriter out = resp.getWriter();


        for(int i = 0; i < name.length; i++){
            if(name[i].trim().length() > 0){
                out.println("<h2>친구" + (i+1) + ": " + name[i] + "</h2>");
            // 이 곳에서 취미 값을 처리합니다. 예를 들어, 화면에 출력하거나 데이터베이스에 저장할 수 있습니다.
            }
        }
    }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
        }
}
