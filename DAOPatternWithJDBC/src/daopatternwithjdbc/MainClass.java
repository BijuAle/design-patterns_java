/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopatternwithjdbc;

/**
 *
 * @author Biju Ale
 */
public class MainClass {

    public static void main(String[] args) {

        DAOInterface daoEmp = new DAOEmployee();

        Employee e = (Employee) daoEmp.get(3);
        Department d = ((Employee) daoEmp.get(3)).getDpt();

        System.out.println("Employee ID: " + e.getId());
        System.out.println("Employee Name: " + e.getName());
        System.out.println("Employee DOB: " + e.getDob());
        System.out.println("Employees' department ID: " + d.getId());
        System.out.println("Employee's department: " + d.getName());
    }
}
