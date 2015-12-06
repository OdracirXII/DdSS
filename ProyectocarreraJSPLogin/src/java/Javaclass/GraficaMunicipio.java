/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Javaclass;

import DAO.Delegate;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author OdracirXII
 */
public class GraficaMunicipio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         JFreeChart chart = ChartFactory.createPieChart3D("Alumnos por Municipio",
         getGraficaAlumnos(), true, true, Locale.getDefault());
         
         String webInfPathL2 = getServletConfig().getServletContext().getRealPath("/graficaL2.png");
         ChartUtilities.saveChartAsPNG(new File(webInfPathL2), chart, 700, 400);
         
         
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GraficaMunicipio </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<img src =\"graficaL2.png\" />");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

     public DefaultPieDataset getGraficaAlumnos(){
        DefaultPieDataset pie = new DefaultPieDataset();
        Delegate del = new Delegate();
        try{
            List datos = del.Grafica2(); 
            for(int indice = 0; indice < datos.size(); indice++){
                Grafica dto = (Grafica)datos.get(indice);
                pie.setValue(dto.getNombre(), dto.getCantidad());
                System.out.println(dto);
            }
            
        }catch(Exception ex){
                ex.printStackTrace();
                }
        return pie;
    }
    
    
}
