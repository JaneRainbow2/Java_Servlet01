package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-task")
public class UpdateTaskServlet extends HttpServlet {
    private TaskDao taskDao;
    private Task task;

    @Override
    public void init() throws ServletException {
        taskDao = TaskDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        task = taskDao.read(taskId);
        if (task == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println(" <html>\n" +
                                         "<body>\n" +
                                         "<a href=\"/home\">Home</a> |\n" +
                                         "<a href=\"/create-task\">Add new Task</a> |\n" +
                                         "<a href=\"/tasks-list\">Show all Tasks</a>\n" +
                                         "<br>\n" +
                                         "<h2>Task with ID '"+ taskId + "' not found in To-Do List!</h2>\n" +
                                         "<h3>url: /edit-task</h3>\n" +
                                         "</body>\n" +
                                         "</html>");
            return;
        }
        request.setAttribute("task", task);
        request.getRequestDispatcher("/WEB-INF/update-task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        task.setTaskName(request.getParameter("taskname"));
        task.setPriority(request.getParameter("priority"));
        taskDao.update(task.getId(), task);
        response.sendRedirect("/tasks-list");
    }
}
