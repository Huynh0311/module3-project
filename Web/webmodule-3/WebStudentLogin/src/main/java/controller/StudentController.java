package controller;

import filter.SessionUser;
import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", value = "/students")
public class StudentController extends HttpServlet {
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean check = SessionUser.checkUser(request);
        if (check) {
            String action = request.getParameter("action");
            switch (action) {
                case "findAll":
                    showAll(request, response);
                    break;
                case "add":
                    showAddForm(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "edit":
                    edit(request, response);
                    break;
                case "searchStudent":
                    searchStudent(request, response);
                    break;
                case "detail":
                    showFormDetail(request, response);
                    break;
                default:
                    showError(request, response);
            }
        } else {
            response.sendRedirect("/user?action=login");
        }

    }

    private void showFormDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findStudentById(id);

        request.setAttribute("student", student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("students/detail.jsp");
        requestDispatcher.forward(request, response);
    }

    private void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/searchStudent" +
                ".jsp");
        String namesearch = request.getParameter("name");
        List<Student> students = studentService.findStudentByName(namesearch);
        request.setAttribute("students", students);
        dispatcher.forward(request, response);
    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/home.jsp");
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        dispatcher.forward(request, response);
    }

    public void showError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("error/NotFound.jsp");
        dispatcher.forward(request, response);
    }

    public void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/addStudent.jsp");
        dispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.studentService.delete(id);
        response.sendRedirect("/students?action=findAll");
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findStudentById(id);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("students/editStudent.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "add":
                addStudent(request, response);
                break;
            case "edit":
                editStudent(request, response);
                break;
        }
    }

    public void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String image = request.getParameter("image");
        Student student = new Student(name, age, image);
        studentService.add(student);
        response.sendRedirect("/students?action=findAll");
    }

    public void editStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getValue(request);
        studentService.edit(id, student);
        response.sendRedirect("/students?action=findAll");
    }

    public Student getValue(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String image = request.getParameter("image");
        Student student = new Student(id, name, age, image);
        return student;
    }
}