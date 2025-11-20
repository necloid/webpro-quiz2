package com.taskman.servlet;

import com.taskman.dao.ProjectDAO;
import com.taskman.dao.ProjectDAOImpl;
import com.taskman.model.Project;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/projects/edit")
public class ProjectEditServlet extends HttpServlet {

    private ProjectDAO dao = new ProjectDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Project p = dao.getById(id);
        req.setAttribute("project", p);
        req.getRequestDispatcher("/WEB-INF/views/projects/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Project p = new Project();
        p.setId(Integer.parseInt(req.getParameter("id")));
        p.setName(req.getParameter("name"));
        p.setDeadline(req.getParameter("deadline"));
        dao.update(p);
        resp.sendRedirect(req.getContextPath() + "/projects");
    }
}
