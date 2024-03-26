package com.example.demo.servlet;


import com.example.demo.model.Student;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/studentServlet")
public class studentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student("PH18921", "Nguyễn Phương Nam");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(new Student("PH18922", "Trần Văn Kiên"));
        request.setAttribute("students", studentList);
        request.getRequestDispatcher("/view/student.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
