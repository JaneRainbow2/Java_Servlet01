package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasks-delete")
public class DeleteTaskServlet extends HttpServlet{
    private TaskDao taskDao;

    @Override
    public void init() throws ServletException {
        taskDao = TaskDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        taskDao.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/tasks-list");
    }
}


