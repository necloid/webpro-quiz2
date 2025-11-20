package com.taskman.dao;

import com.taskman.model.User;

public interface UserDAO {
    User authenticate(String username, String password);
    User getById(int id);
}
