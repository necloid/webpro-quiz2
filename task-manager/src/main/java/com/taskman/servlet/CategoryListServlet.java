package com.taskman.servlet;

import com.taskman.dao.CategoryDAO;
import com.taskman.dao.CategoryDAOImpl;
import com.taskman.model.Category;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;     // <-- IMPORTANT

@WebServlet("/categories")
public class CategoryListServlet extends HttpServlet {

    private CategoryDAO categoryDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Category> categories = categoryDAO.getAll();
        req.setAttribute("categories", categories);

        req.getRequestDispatcher("/WEB-INF/views/categories/list.jsp")
            .forward(req, resp);
    }
}

