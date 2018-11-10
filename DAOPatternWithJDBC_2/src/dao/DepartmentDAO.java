/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Employee;

/**
 *
 * @author achyut
 */
public class DepartmentDAO implements DAOInterface {

    Connection conn;

    public DepartmentDAO() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public ArrayList<Object> getAll() {

        String sql = "select * from departments";
        ArrayList<Object> departments = new ArrayList();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Department d = new Department();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                departments.add(d);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departments;
    }

    @Override
    public Object get(int id) {
        String sql = "SELECT * FROM departments WHERE id = " + id;
        Department d = new Department();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    @Override
    public boolean insert(Object obj) {
        String sql = "insert into departments values(?,?)";
        Department d = (Department) obj;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, d.getId());
            stmt.setString(2, d.getName());

            int rowsInserted = stmt.executeUpdate();
            stmt.close();

            if (rowsInserted > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        String sql = "update departments set name = ? where id = ?";
        Department d = (Department) obj;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, d.getName());
            stmt.setInt(2, d.getId());

            int rowsUpdated = stmt.executeUpdate();
            stmt.close();

            if (rowsUpdated > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(Object obj) {
        String sql = "DELETE FROM departments WHERE id = ?";
        Employee e = (Employee) obj;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, e.getId());

            int rowsDeleted = stmt.executeUpdate();
            stmt.close();

            if (rowsDeleted > 0) {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
