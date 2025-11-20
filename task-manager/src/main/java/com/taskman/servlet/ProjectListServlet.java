package com.taskman.servlet;

import com.taskman.dao.ProjectDAO;
import com.taskman.dao.ProjectDAOImpl;
import com.taskman.model.Project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/projects")
public class ProjectListServlet extends HttpServlet {

    private ProjectDAO projectDAO = new ProjectDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Project> projects = projectDAO.getAll();
        req.setAttribute("projects", projects);

        req.getRequestDispatcher("/WEB-INF/views/projects/list.jsp")
           .forward(req, resp);
    }
}
