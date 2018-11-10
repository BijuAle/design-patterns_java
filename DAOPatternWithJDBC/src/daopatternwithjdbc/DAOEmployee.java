/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopatternwithjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Biju Ale
 */
public class DAOEmployee implements DAOInterface {

    Connection conn;

    public DAOEmployee() {
        conn = ConnectionFactory.getConnection(); //Get road
    }

    @Override
    public Object get(int id) {
        Employee e = new Employee();
        Department d = new Department();

        String query = "SELECT e.id, e.name, e.dob, d.id, d.name FROM employees AS e, departments AS d WHERE e.id = ? AND e.dept_id = d.id"; //Prevent SQL injection
        try {//Do insurance to vehicle
            PreparedStatement stmt = conn.prepareStatement(query); //Run vehicle in road
            stmt.setInt(1, id); // Define ? part of SQL injection prevention

            ResultSet rs = stmt.executeQuery(); //Prepare package.
            while (rs.next()) { //Until end of row is reached.
                e.setId(rs.getInt("e.id"));
                e.setName(rs.getString("e.name"));
                e.setDob(rs.getDate("e.dob"));

                d.setId(rs.getInt("d.id"));
                d.setName(rs.getString("d.name"));

                e.setDpt(d);
            }

            rs.close(); //Closing package /Releasing system resource
            stmt.close(); //Parking vehicle /Releasing system resource

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return e;
    }

    @Override
    public ArrayList<Object> getAll() {
        return null;
    }

    @Override
    public boolean insert(Object obj) {
        return false;

    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

}
