package com.taskman.servlet;

import com.taskman.dao.ProjectDAO;
import com.taskman.dao.ProjectDAOImpl;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/projects/delete")
public class ProjectDeleteServlet extends HttpServlet {

    private ProjectDAO dao = new ProjectDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/projects");
    }
}
