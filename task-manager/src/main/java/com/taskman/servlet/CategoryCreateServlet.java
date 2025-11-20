package com.taskman.servlet;

import com.taskman.dao.CategoryDAO;
import com.taskman.dao.CategoryDAOImpl;
import com.taskman.model.Category;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/categories/create")
public class CategoryCreateServlet extends HttpServlet {

    private CategoryDAO dao = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/categories/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Category c = new Category();
        c.setName(req.getParameter("name"));
        c.setColor(req.getParameter("color"));
        dao.insert(c);
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}
