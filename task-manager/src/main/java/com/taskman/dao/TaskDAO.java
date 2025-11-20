package com.taskman.dao;

import com.taskman.model.Task;
import java.util.List;

public interface TaskDAO {
    List<Task> getAll();
    Task getById(int id);
    boolean insert(Task t);
    boolean update(Task t);
    boolean delete(int id);
}
