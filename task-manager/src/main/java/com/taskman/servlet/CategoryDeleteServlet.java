package com.taskman.servlet;

import com.taskman.dao.CategoryDAO;
import com.taskman.dao.CategoryDAOImpl;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/categories/delete")
public class CategoryDeleteServlet extends HttpServlet {

    private CategoryDAO dao = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.delete(id);
        resp.sendRedirect(req.getContextPath() + "/categories");
    }
}
