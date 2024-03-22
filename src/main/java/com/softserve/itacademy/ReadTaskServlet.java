package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/read-task")
public class ReadTaskServlet extends HttpServlet {
    private TaskDao taskDao;

    @Override
    public void init() throws ServletException {
        taskDao = TaskDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        Task task = taskDao.read(taskId);
        if (task == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println(" <html>\n" +
                                         "<body>\n" +
                                         "<a href=\"/home\">Home</a> |\n" +
                                         "<a href=\"/create-task\">Add new Task</a> |\n" +
                                         "<a href=\"/tasks-list\">Show all Tasks</a>\n" +
                                         "<br>\n" +
                                         "<h2>Task with ID '" + taskId + "' not found in To-Do List!</h2>\n" +
                                         "<h3>url: /read-task</h3>\n" +
                                         "</body>\n" +
                                         "</html>");
            return;
        }
        request.setAttribute("task", task);
        request.getRequestDispatcher("/WEB-INF/read-task.jsp").forward(request, response);
    }
}


