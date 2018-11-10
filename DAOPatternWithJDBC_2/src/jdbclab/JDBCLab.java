/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbclab;

import dao.DAOInterface;
import dao.DepartmentDAO;
import dao.EmployeeDAO;
import dbutil.ConnectionFactory;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Department;
import model.Employee;

/**
 *
 * @author Biju Ale
 */
public class JDBCLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        DAOInterface daoDept = new DepartmentDAO();
        DAOInterface daoEmp = new EmployeeDAO();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dob = null;

        Random rdmGen = new Random();
        int randomID = rdmGen.nextInt(100);

//***************Testing DepartmentDAO class****************************************************************************************************
        System.out.println("Fetching 1 department. (Testing DepartmentDAO's 'get' method)");
        Department d1 = (Department) daoDept.get(1);
        System.out.println(d1.getId() + "\t" + d1.getName());
        //---------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\nFetching all departments (Testing DepartmentDAO's 'getAll' method)");
        ArrayList<Object> departments = daoDept.getAll();
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(((Department) (departments.get(i))).getId() + "\t" + ((Department) (departments.get(i))).getName());
        }
        System.out.println("\nInserting new employees. (Testing DepartmentDAO's 'insert' method)");
        Employee e3 = new Employee();
        Department d3 = new Department();
        d3.setId(1);
        d3.setName("Account");

        String str_dob = "2011-02-22";
        try {
            dob = formatter.parse(str_dob);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
//        java.sql.Date dob = new java.sql.Date(myDate.getTime());

        e3.setId(randomID);
        e3.setName("Chhaya Pandey");
        e3.setDob(dob);
        e3.setDept(d3);
        System.out.println("Insertd?\t" + daoEmp.insert(e3));
        //---------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\nUpdating an employee record. (Testing DepartmentDAO's 'update' method)");
        d3.setId(2);
        d3.setName("Marketting");

        String new_date = "2000-02-22";
        try {
            dob = formatter.parse(new_date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
//        java.sql.Date newDate = new java.sql.Date(dob.getTime());

        e3.setId(randomID);
        e3.setName("Chhaya Chhaya");
        e3.setDob(dob);
        e3.setDept(d3);
        System.out.println("Updated?\t" + daoEmp.update(e3));

        //---------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\nDeleting an employee record. (Testing DepartmentDAO's 'delete' method)");
        System.out.println("Deleted?\t" + daoEmp.delete(e3));
        //---------------------------------------------------------------------------------------------------------------------------------------
        //***************Testing EmployeeDAO class******************************************************************************************************
        System.out.println("\nFetching 1 employee. (Testing EmployeeDAO's 'get' method)");
        Employee e1 = (Employee) daoEmp.get(1);
        Department d2 = (Department) e1.getDept();
        System.out.println(e1.getId() + "\t" + e1.getName() + "\t" + e1.getDob() + "\t" + d2.getId() + "\t" + d2.getName());
        //---------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("\nFetching all employees (Testing EmployeeDAO's 'getAll' method)");
        ArrayList<Object> employees = daoEmp.getAll();

        for (Object eachEmployee : employees) {
            Employee e = (Employee) eachEmployee;
            Department de = (Department) e.getDept();
            System.out.println("Emp. ID " + e.getId() + "\t" + e.getName() + "\t" + e.getDob() + "\tDept. ID " + de.getId() + "\t" + de.getName()
            );
        }
        System.out.println("\nInserting new departments. (Testing DepartmentDAO's 'insert' method)");

        System.out.println("\nUpdating an department record. (Testing DepartmentDAO's 'update' method)");

        System.out.println("\nDeleting an department record. (Testing DepartmentDAO's 'delete' method)");
        //---------------------------------------------------------------------------------------------------------------------------------------
        ConnectionFactory.closeConnection();
    }

}
