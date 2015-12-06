package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.List;

/**
 *
 * @author Moweno
 */
public class Delegate {
    private Connection con;
    private Facade facadita;
    
    public Delegate(){
        String usuario = "root";
        String contra = "admin";
        String url = "jdbc:mysql://127.0.0.1:3306/basewad";
        String driver = "com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, contra);
           
        }catch(Exception e){
            e.printStackTrace();
        }
        facadita = new Facade(con);
    }
    
    public List Grafica() throws SQLException{
        return facadita.grafica();
    }
    
    public List Grafica2() throws SQLException{
        return facadita.grafica2();
    }
    
    public List Grafica3() throws SQLException{
        return facadita.grafica3();
    }
}
