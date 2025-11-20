package com.taskman.dao;

import com.taskman.config.DBUtil;
import com.taskman.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImpl implements TaskDAO {

    @Override
    public List<Task> getAll() {
        List<Task> list = new ArrayList<>();

        String sql = "SELECT * FROM tasks ORDER BY id DESC";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Task t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setDescription(rs.getString("description"));
                t.setPriority(rs.getString("priority"));
                t.setDueDate(String.valueOf(rs.getDate("due_date")));
                t.setStatus(rs.getString("status"));
                t.setProjectId((Integer) rs.getObject("project_id"));
                t.setCategoryId((Integer) rs.getObject("category_id"));
                t.setCreatedBy((Integer) rs.getObject("created_by"));

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Task getById(int id) {
        Task t = null;
        String sql = "SELECT * FROM tasks WHERE id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                t = new Task();
                t.setId(rs.getInt("id"));
                t.setTitle(rs.getString("title"));
                t.setDescription(rs.getString("description"));
                t.setPriority(rs.getString("priority"));
                t.setDueDate(String.valueOf(rs.getDate("due_date")));
                t.setStatus(rs.getString("status"));
                t.setProjectId((Integer) rs.getObject("project_id"));
                t.setCategoryId((Integer) rs.getObject("category_id"));
                t.setCreatedBy((Integer) rs.getObject("created_by"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    @Override
    public boolean insert(Task task) {
        String sql = """
                INSERT INTO tasks(title, description, priority, due_date, status,
                project_id, category_id, created_by)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getPriority());
            ps.setString(4, task.getDueDate());
            ps.setString(5, task.getStatus());

            if (task.getProjectId() == null) ps.setNull(6, Types.INTEGER);
            else ps.setInt(6, task.getProjectId());

            if (task.getCategoryId() == null) ps.setNull(7, Types.INTEGER);
            else ps.setInt(7, task.getCategoryId());

            ps.setInt(8, task.getCreatedBy());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Task task) {
        String sql = """
                UPDATE tasks SET title=?, description=?, priority=?, due_date=?,
                status=?, project_id=?, category_id=? WHERE id=?
                """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, task.getTitle());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getPriority());
            ps.setString(4, task.getDueDate());
            ps.setString(5, task.getStatus());

            if (task.getProjectId() == null) ps.setNull(6, Types.INTEGER);
            else ps.setInt(6, task.getProjectId());

            if (task.getCategoryId() == null) ps.setNull(7, Types.INTEGER);
            else ps.setInt(7, task.getCategoryId());

            ps.setInt(8, task.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM tasks WHERE id=?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
