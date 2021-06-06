package com.DB.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @ author Andrej Simionenko, Raheela Tasneem, Fei Gu, Ibraheem Swaidan
 * @ create 2021-06-01-13.32
 * @ grade CS20_EASV_SØNDERBORG
 * @ Description This is the EASV D20 2nd semester final exam project
 * @ Supervisors Karsten Skov, Tommy Haugaard, Frank Østergaard Hansen
 * @ Version 0.1
 */
public interface IF_BaseDao<T> {

    /**
     * insert one instance into database
     * @param t the instance t.
     */
    public void add(T t);

    /**
     * modity a instance from the database
     * @param t the instance be changed
     */
    public void modify(T t);

    /**
     * remove a instance from the database
     * @param t the instance's primary key
     */
    public void delete(T t);

    /**
     * select a instance form the database
     * @param t which instance be choose
     * @return
     */
    public ResultSet getInstance(T t);


    /**
     * select all the instance from a table
      * @return
     */
    public ArrayList<T> getAll();
}
