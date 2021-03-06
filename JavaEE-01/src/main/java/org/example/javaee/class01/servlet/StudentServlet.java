package org.example.javaee.class01.servlet;
import org.example.javaee.class01.jdbc.StudentJdbc;
import org.example.javaee.class01.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Student> s =  StudentJdbc.selectAlls();
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=UTF-8");
            req.setAttribute("studentlist",s);
            req.getRequestDispatcher("student.jsp").forward(req,resp);
    }
}
