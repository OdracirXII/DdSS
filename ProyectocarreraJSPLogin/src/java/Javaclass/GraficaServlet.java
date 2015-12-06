package Javaclass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.Delegate;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author Moweno
 */
@WebServlet(name = "GraficaServlet", urlPatterns = {"GraficaServlet"})
public class GraficaServlet extends HttpServlet {

    String path;
    
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
        
        JFreeChart chart = ChartFactory.createPieChart3D("Alumnos por Carrera",
            getGraficaAlumnos(), true, true, Locale.getDefault());
         

        String webInfPath = getServletConfig().getServletContext().getRealPath("/grafica.png");
        ChartUtilities.saveChartAsPNG(new File(webInfPath), chart, 700, 400);
        setPath(webInfPath);
        
        
        response.sendRedirect("success.jsp");
/*       
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GraficaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>Contenido dinamico</p>");
            out.println("<img src =\"grafica.png\" />");
            out.println("</body>");
            out.println("</html>");
        } */
    }

        
    public DefaultPieDataset getGraficaAlumnos(){
        DefaultPieDataset pie = new DefaultPieDataset();
        Delegate del = new Delegate();
        try{
            List datos = del.Grafica();
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
    
    
     public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path = path;
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

}
