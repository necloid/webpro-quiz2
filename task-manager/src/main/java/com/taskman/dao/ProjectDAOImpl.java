package com.taskman.dao;

import com.taskman.config.DBUtil;
import com.taskman.model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {

    @Override
public List<Project> getAll() {
    List<Project> list = new ArrayList<>();
    String sql = "SELECT * FROM projects ORDER BY id DESC";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Project p = new Project();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setDeadline(rs.getString("deadline"));
            list.add(p);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

    @Override
    public Project getById(int id) {
        Project p = null;
        String sql = "SELECT * FROM projects WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Project();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                Date d = rs.getDate("deadline");
                p.setDeadline(d == null ? null : d.toString());
            }
        } catch (Exception e) { e.printStackTrace(); }
        return p;
    }

    @Override
    public boolean insert(Project p) {
        String sql = "INSERT INTO projects(name, deadline) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            if (p.getDeadline() == null || p.getDeadline().isBlank()) ps.setNull(2, Types.DATE);
            else ps.setDate(2, Date.valueOf(p.getDeadline()));
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean update(Project p) {
        String sql = "UPDATE projects SET name=?, deadline=? WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            if (p.getDeadline() == null || p.getDeadline().isBlank()) ps.setNull(2, Types.DATE);
            else ps.setDate(2, Date.valueOf(p.getDeadline()));
            ps.setInt(3, p.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM projects WHERE id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }
}
