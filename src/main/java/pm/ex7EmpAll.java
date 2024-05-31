package pm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.EmpVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

@WebServlet(name = "ex7", value = "/ex7")
public class ex7EmpAll extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 마이바티스를 활용하기 위해
            // mybatis-3.x.x.x.jar과 mysql-connecter파일들을
            // webapp/web-inf/

            Reader reader = Resources.getResourceAsReader("config/config.xml");

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
            SqlSession ss = factory.openSession();

            List<EmpVO> list = ss.selectList("emp.all");

        StringBuffer sb = new StringBuffer();
        sb.append("<ol>");
        for (EmpVO empVO : list) {
            sb.append("<li>");
            sb.append(empVO.getEname());
            sb.append(", ");
            sb.append(empVO.getJob());
            sb.append(", ");
            sb.append(empVO.getHiredate());
            sb.append(", ");
            sb.append(empVO.getSal());
            sb.append(", ");
            sb.append(empVO.getComm());
            sb.append("</li>");
        }
        sb.append("</ol>");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(sb.toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
