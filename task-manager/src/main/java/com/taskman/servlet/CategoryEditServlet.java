package com.taskman.servlet;

import com.taskman.dao.CategoryDAO;
import com.taskman.dao.CategoryDAOImpl;
import com.taskman.model.Category;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/categories/edit")
public class CategoryEditServlet extends HttpServlet {

    private CategoryDAO dao = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category c = dao.getById(id);
        req.setAttribute("category", c);
        req.getRequestDispatcher("/WEB-INF/views/categories/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Category c = new Category();
        c.setId(Integer.parseInt(req.getParameter("id")));
        c.setName(req.getParameter("name"));
        c.setColor(req.getParameter("color"));
        dao.update(c);
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}
