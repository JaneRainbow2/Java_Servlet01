package com.softserve.itacademy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasks-list")
public class TaskListServlet extends HttpServlet{

    private TaskDao taskDao;

    @Override
    public void init() throws ServletException {
        taskDao=TaskDao.getInstance();
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/WEB-INF/task-list.jsp");
        request.setAttribute("tasks",taskDao.readAll());
        requestDispatcher.forward(request,response);
    }

}

