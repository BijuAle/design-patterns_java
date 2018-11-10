/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Department;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Biju Ale
 */
public class DepartmentDAOTest {

    DepartmentDAO daoDept;

    public DepartmentDAOTest() {
        daoDept = new DepartmentDAO();
    }

//    @Test
//    public void testOfInsertDepartment(){
//        Department d = new Department();
//        d.setId(4);
//        d.setName("Admin");        
//        assertEquals(true, dao.insert(d));
//    }
    @Test
    public void testOfGetOneDepartment() {
        Department d = (Department) daoDept.get(1);
        assertEquals("Account", d.getName());
    }

    @Test
    public void testOfGetAllDepartment() {
        ArrayList<Object> departments = daoDept.getAll();
        for (int i = 0; i < departments.size(); i++) {
            assertEquals("Account", ((Department) (departments.get(i))).getName());
            assertEquals(i+1, ((Department) (departments.get(i))).getId());
        }
    }
}
