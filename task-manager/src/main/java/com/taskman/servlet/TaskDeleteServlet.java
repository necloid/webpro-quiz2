package com.taskman.servlet;

import com.taskman.dao.TaskDAO;
import com.taskman.dao.TaskDAOImpl;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/tasks/delete")
public class TaskDeleteServlet extends HttpServlet {

    private TaskDAO taskDAO = new TaskDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        taskDAO.delete(id);

        resp.sendRedirect(req.getContextPath() + "/tasks");
    }
}
