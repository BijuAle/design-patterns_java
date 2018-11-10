/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Employee;

/**
 *
 * @author Biju Ale
 */
public class EmployeeDAO implements DAOInterface {

    Connection conn;

    public EmployeeDAO() {
        this.conn = ConnectionFactory.getConnection();
    }

    @Override
    public ArrayList<Object> getAll() {
        ArrayList<Object> employees = new ArrayList();
        String query = "SELECT e.id, e.name, e.dob, e.dept_id, d.id, d.name FROM employees AS e, departments AS d WHERE e.dept_id = d.id";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("e.id"));
                e.setName(rs.getString("e.name"));
                e.setDob(rs.getDate("e.dob"));

                Department d = new Department();
                d.setId(rs.getInt("d.id"));
                d.setName(rs.getString("d.name"));

                e.setDept(d);
                employees.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employees;
    }

    @Override
    public Object get(int id) {
        String query = "SELECT e.id, e.name, e.dob, e.dept_id, d.id, d.name FROM employees AS e, departments AS d WHERE e.dept_id = d.id";
        Employee e = new Employee();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                e.setId(rs.getInt("e.id"));
                e.setName(rs.getString("e.name"));
                e.setDob(rs.getDate("e.dob"));

                Department d = new Department();
                d.setId(rs.getInt("d.id"));
                d.setName(rs.getString("d.name"));

                e.setDept(d);
            }
            stmt.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    @Override
    public boolean insert(Object obj) {


        String sql = "insert into employees values(?,?,?,?)";
        Employee e = (Employee) obj;
        Department d = (Department) e.getDept();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, e.getId());
            stmt.setString(2, e.getName());
            stmt.setDate(3, new java.sql.Date(e.getDob().getTime()));
            stmt.setInt(4, d.getId());

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
        String sql = "UPDATE EMPLOYEES SET name = ?, dob = ?, dept_id = ?  WHERE id = ?";
        Employee e = (Employee) obj;
        Department d = (Department) e.getDept();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, e.getName());
            stmt.setDate(2, new java.sql.Date(e.getDob().getTime()));
            stmt.setInt(3, d.getId());
            stmt.setInt(4, e.getId());

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
        String sql = "DELETE FROM EMPLOYEES WHERE id = ?";
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
