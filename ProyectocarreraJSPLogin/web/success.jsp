
<%@page import="Javaclass.GraficaServlet"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="Javaclass.Alumno"%>
 
<%
    if ((session.getAttribute("usuario") == null) || (session.getAttribute("usuario") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} else {
        
        
         
      
      
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

  <head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title>My Page</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<meta name="viewport" content="width=device-width,initial-scale=1">

	<link rel="stylesheet" href="css/style4.css">

	<script src="js/libs/modernizr-2.0.6.min.js"></script>
</head>
<body>

    
    <div id="container">
    	<header>
    	    
    	</header>

        <!-- Add nested lists to our nav menu element -->
        <nav>
            <ul>
                <li><a href=  >Home</a></li> 
              
              <li><a href=>Servicios</a>
                <ul>
                    <li><a href="/success.jsp">Menu de algo</a></li>
                    
                </ul>
             
              </li>
            </ul>
        </nav>	

        <div id="boxes">  
    	<section id="main" role="main">
            <article>
                <h1>Web Applicaction Development 2do Parcial</h1>
                
                
                
                <%
                
                Alumno currentalum = new Alumno();
                
    
                
                
    
                Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basewad",
            "root", "admin");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from alumno where usuario='" + session.getAttribute("usuario") + "' and clave='" + session.getAttribute("password") + "'");
    
    if (rs.next()) {
                
        int id = rs.getInt("idAlumno");
        String nombre = rs.getString("nombre");
        String materno = rs.getString("materno");
        String paterno = rs.getString("paterno");
        String email = rs.getString("email");
        
        String calle = rs.getString("calle");
        int numero = rs.getInt("numero");
        
        
        
        int idCarrera = rs.getInt("carrera");
        int idEntidad = rs.getInt("entidad");
        int idDelegmuni = rs.getInt("delmun");
        
        currentalum.setNombre(nombre);
        currentalum.setPaterno(paterno);
        currentalum.setMaterno(materno);
        currentalum.setIdCarrera(idCarrera);
        currentalum.setIdEntidad(idEntidad); 
        currentalum.setIdDelnum(idDelegmuni);
        currentalum.setEmail(email);
        currentalum.setCalle(calle);
        currentalum.setNumero(numero);
        
        
        }    

    
    Statement st1 = con.createStatement();
    ResultSet rs1;
    rs1 = st1.executeQuery("select * from municipio where idMunicipio='" + currentalum.getIdDelnum() + "' and idEstado='" + currentalum.getIdEntidad() + "'");
    if (rs1.next()) {
        
        
        String delnum  = rs1.getString("nombreMunicipio");
        currentalum.setDelnum(delnum);  
                    }
    
    Statement st2 = con.createStatement();
    ResultSet rs2;
    rs2 = st2.executeQuery("select * from estado where idEstado='" + currentalum.getIdEntidad() + "'");
    if (rs2.next()) {
        
        
        String ent  = rs2.getString("nombreEstado");
        currentalum.setEntidad(ent);
                    }
    
    
    Statement st3 = con.createStatement();
    ResultSet rs3;
    rs3 = st3.executeQuery("select * from carrera where idCarrera='" + currentalum.getIdCarrera() + "'");
    if (rs3.next()) {
        
        
        String carrera  = rs3.getString("nombreCarrera");
        currentalum.setCarrera(carrera);
                    }
    
    GraficaServlet currentservlet1 = new GraficaServlet();
    String currentPath1 = currentservlet1.getPath() ;
    
    
                %>
               
           
                <p> Datos del usuario </p>
                <p> <%   out.print("\n Nombre: "+currentalum.getNombre());   %>  </p>
                <p> <%   out.print("\n Apellido Paterno: "+currentalum.getPaterno());   %>  </p>
                <p> <%   out.print("\n Apellido Materno: "+currentalum.getMaterno()); %>  </p>
                <p> <%   out.print("\n Carrera: "+currentalum.getCarrera()); %>  </p>
                <p> <%   out.print("\n Email: "+currentalum.getEmail()); %>  </p>
                <p> <%   out.print("\n Entidad: "+currentalum.getEntidad());   %>  </p>
                <p> <%   out.print("\n Municipio/Delegacion: "+currentalum.getDelnum());   %>  </p>
                <p> <%   out.print("\n Calle: "+currentalum.getCalle());   %>  </p>
                <p> <%   out.print("\n Numero: "+currentalum.getNumero());   %>  </p>
                
                <img src=<%=currentPath1 %>>  
                     
                     
                
                <%  
                
                    
     out.println("<img src =\"grafica.png\" />");
                  
                  
                    
                
                %>
               
               
            </article>        
    	</section>

        <aside>
           <h2>Graficas</h2>
           <ul>
               <li> 
                <a href="GraficaServlet"> Carreras </a> <br>
               <li><a href="GraficaMunicipio"> Municipio </a></li>
               <li><a href="GraficaEntidad"> Entidad </a> <br></li></li>
               
           </ul>

          
           </ul>      
        </aside>
        </div>

    	<footer>
            Autor: Ricardo Alan Vargas
            <a href='logout.jsp'>Cerrar Sesion</a>
    	</footer>
    </div> <!--! end of #container -->


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="js/libs/jquery-1.6.2.min.js"><\/script>')</script>

<!-- scripts concatenated and minified via ant build script-->
<script src="js/plugins.js"></script>
<script src="js/script.js"></script>
<!-- end scripts-->

<script type="text/javascript" charset="utf-8">
    $(document).ready(function(){
     /* Make boxes same height */
     $('#boxes').sameHeights();
    });
</script>

</body>
</html>

<%
    }
%>
