package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-task")
public class CreateTaskServlet extends HttpServlet {

    private TaskDao taskDao;

    @Override
    public void init() throws ServletException {
        taskDao = taskDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/create-task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String taskname = request.getParameter("taskname");
        String priority = request.getParameter("priority");

        Task existingTask = taskDao.getTaskByTaskname(taskname);
        if (existingTask != null) {
            response.setStatus(HttpServletResponse.SC_CONFLICT); // Код ошибки 409
            response.getWriter().println("<html>\n" +
                                         "<head>\n" +
                                         "    <title>Create new Task</title>\n" +
                                         "</head>\n" +
                                         "<body>\n" +
                                         "<a href=\"/home\">Home</a> |\n" +
                                         "<a href=\"/create-task\">Add new Task</a> |\n" +
                                         "<a href=\"/tasks/list\">Show all Tasks</a>\n" +
                                         "<br>\n" +
                                         "<h2>Create new Task</h2>\n" +
                                         "<p>Task with a given name already exists!</p>\n" +
                                         "<form action=\"/tasks/create\" method=\"post\">\n" +
                                         "    <table>\n" +
                                         "        <tr>\n" +
                                         "            <td>\n" +
                                         "                <label for=\"taskname\">Name: </label>\n" +
                                         "            </td>\n" +
                                         "            <td>\n" +
                                         "                <input type=\"text\" id="+taskname+" value="+taskname+">\n" +
                                         "            </td>\n" +
                                         "        </tr>\n" +
                                         "        <tr>\n" +
                                         "            <td>\n" +
                                         "                <label for=\"priority\">Priority: </label>\n" +
                                         "            </td>\n" +
                                         "            <td>\n" +
                                         "                <select id=\"priority\"  name=\"priority\">\n" +
                                         "                    <option value=\"LOW\">Low</option>\n" +
                                         "                    <option value=\"MEDIUM\">Medium</option>\n" +
                                         "                    <option value=\"HIGH\">High</option>\n" +
                                         "                </select>\n" +
                                         "            </td>\n" +
                                         "        </tr>\n" +
                                         "        <tr>\n" +
                                         "            <td>\n" +
                                         "                <input type=\"submit\" value=\"Create\">\n" +
                                         "            </td>\n" +
                                         "            <td>\n" +
                                         "                <input type=\"submit\" value=\"Clear\">\n" +
                                         "            </td>\n" +
                                         "        </tr>\n" +
                                         "    </table>\n" +
                                         "</form>\n" +
                                         "</body>\n" +
                                         "</html>\n");
            return;
        }
        Task task = new Task(taskname, priority);
        taskDao.create(task);
        response.sendRedirect("/tasks-list");
    }
}
