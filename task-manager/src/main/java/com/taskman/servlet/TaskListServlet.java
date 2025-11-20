package com.taskman.servlet;

import com.taskman.dao.TaskDAO;
import com.taskman.dao.TaskDAOImpl;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/tasks")
public class TaskListServlet extends HttpServlet {

    private TaskDAO taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("tasks", taskDAO.getAll());
        req.getRequestDispatcher("/WEB-INF/views/tasks/list.jsp").forward(req, resp);
    }
}
