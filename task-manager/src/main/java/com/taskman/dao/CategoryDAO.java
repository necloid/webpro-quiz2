package com.taskman.dao;

import com.taskman.model.Category;
import java.util.List;

public interface CategoryDAO {
    List<Category> getAll();
    Category getById(int id);
    boolean insert(Category c);
    boolean update(Category c);
    boolean delete(int id);
}
