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
public class GraficaDAOEnt {

    private static final String SQL_GRAFICAR = "call spDatosEnt();";

    public List grafica3(Connection con) throws SQLException{
        CallableStatement cs = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try{
            cs = con.prepareCall(SQL_GRAFICAR);
            rs = cs.executeQuery();
            while(rs.next()){
                Grafica grafica3 = new Grafica();
                grafica3.setCantidad(Integer.parseInt(rs.getString("alumno")));
                grafica3.setNombre(rs.getString("estado"));
                lista.add(grafica3);
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
