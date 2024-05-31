package pm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.EmpVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name="homework", value="/homework")
public class homework extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //요청하기

        // MyBatis 설정 파일 가져오기
        Reader reader = Resources.getResourceAsReader("config/config.xml");
        SqlSessionFactory ss = new SqlSessionFactoryBuilder().build(reader);
        reader.close();

        String selection = req.getParameter("selection");
        String text = req.getParameter("text");

        //위 두개의 파라미터를 mapper의 emp.search를 호출하기 위해
        //emp.search에 지정된 파라미터타입=map인 map구조를 만들자

        Map<String, String> map = new HashMap<>();
        map.put(selection, text);

        /*List<EmpVO> list = ss.openSession().selectList("emp.searchByMultipleFields", map);*/

        List<EmpVO> list;

       switch (selection) {
            case "empno":
                list = ss.openSession().selectList("emp.searchByEmpno", text);
                break;
            case "ename":
                list = ss.openSession().selectList("emp.searchByEname", text);
                break;
            default:
                list = ss.openSession().selectList("emp.searchByJob", text);
                break;
        }

        StringBuffer sb = new StringBuffer();
        if(list.size()>0){
            sb.append("<ol>");
            // 리스트를 순회하며 아이템 추가
            for (EmpVO emp : list) {
                sb.append("<li>");
                sb.append(emp.getEname());
                sb.append(", ");
                sb.append(emp.getJob());
                sb.append(", ");
                sb.append(emp.getHiredate());
                sb.append(", ");
                sb.append(emp.getSal());
                sb.append(", ");
                sb.append(emp.getComm());
                sb.append("</li>");
            }

            sb.append("</ol>");
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.println(sb.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}