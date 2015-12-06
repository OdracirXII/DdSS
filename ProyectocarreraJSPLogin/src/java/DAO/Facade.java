/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Moweno
 */
public class Facade {
    private Connection con;
    
    private GraficaDAO dao;
    private GraficaDAOMun daomun;
    private GraficaDAOEnt daoent;
    
    public Facade(Connection con){
        this.con = con;
        dao = new GraficaDAO();
        daomun = new GraficaDAOMun();
        daoent = new GraficaDAOEnt();
    }
    
    public List grafica() throws SQLException{
        return dao.grafica(con);
    }
    
    public List grafica2() throws SQLException{
        return daomun.grafica2(con);
    }
    
    public List grafica3() throws SQLException{
        return daoent.grafica3(con);
    }
    
}
