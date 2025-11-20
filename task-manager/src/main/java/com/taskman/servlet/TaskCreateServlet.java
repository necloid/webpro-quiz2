package com.taskman.servlet;

import com.taskman.dao.TaskDAO;
import com.taskman.dao.TaskDAOImpl;
import com.taskman.model.Project;
import com.taskman.model.Task;
import com.taskman.dao.CategoryDAO;
import com.taskman.dao.CategoryDAOImpl;
import com.taskman.dao.ProjectDAO;
import com.taskman.dao.ProjectDAOImpl;
import com.taskman.model.Category;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/tasks/create")
public class TaskCreateServlet extends HttpServlet {

    private TaskDAO taskDAO = new TaskDAOImpl();
    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    private ProjectDAO projectDAO = new ProjectDAOImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Category> categories = categoryDAO.getAll();
        List<Project> projects = projectDAO.getAll();

        req.setAttribute("categories", categories);
        req.setAttribute("projects", projects);

        req.getRequestDispatcher("/WEB-INF/views/tasks/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Task t = new Task();
        t.setTitle(req.getParameter("title"));
        t.setDescription(req.getParameter("description"));
        t.setPriority(req.getParameter("priority"));
        t.setStatus(req.getParameter("status"));
        t.setDueDate(req.getParameter("dueDate"));

        String cat = req.getParameter("categoryId");
        t.setCategoryId(cat == null || cat.isEmpty() ? null : Integer.parseInt(cat));

        String proj = req.getParameter("projectId");
        t.setProjectId(proj == null || proj.isEmpty() ? null : Integer.parseInt(proj));

        Integer userId = (Integer) req.getSession().getAttribute("userId");
        if (userId == null) {
            resp.sendRedirect("../login");
            return;
        }

        taskDAO.insert(t);
        resp.sendRedirect("../tasks");
    }
}
