/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daopatternwithjdbc;

import java.util.ArrayList;

/**
 *
 * @author Biju Ale
 */
public interface DAOInterface {

    Object get(int id);

    ArrayList<Object> getAll();

    boolean insert(Object obj);

    boolean update(Object obj);

    boolean delete(Object obj);

}
