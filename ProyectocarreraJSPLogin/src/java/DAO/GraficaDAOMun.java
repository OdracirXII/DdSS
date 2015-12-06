/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Javaclass.Grafica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asuncionez
 */
public class GraficaDAOMun {

    private static final String SQL_GRAFICAR = "call spDatosMun();";

    public List grafica2(Connection con) throws SQLException{
        CallableStatement cs = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try{
            cs = con.prepareCall(SQL_GRAFICAR);
            rs = cs.executeQuery();
            while(rs.next()){
                Grafica grafica2 = new Grafica();
                grafica2.setCantidad(Integer.parseInt(rs.getString("alumno")));
                grafica2.setNombre(rs.getString("municipio"));
                lista.add(grafica2);
            } 
        }finally{
            if(rs != null){
                rs.close();
            }
            if(cs != null)
                cs.close();
        }
        return lista;
    }
    
}
