package com.taskman.dao;

import com.taskman.model.Project;
import java.util.List;

public interface ProjectDAO {
    List<Project> getAll();
    Project getById(int id);
    boolean insert(Project p);
    boolean update(Project p);
    boolean delete(int id);
}
