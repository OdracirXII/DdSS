<%@ page import ="java.sql.*" %>
<%
     String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basewad",
            "root", "admin");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from alumno where usuario='" + userid + "' and clave='" + pwd + "'");
    if (rs.next()) {
        session.setAttribute("usuario", userid);
        session.setAttribute("password", pwd);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        response.sendRedirect("success.jsp");
    } else {
        out.println("Fallo el login <a href='index.jsp'>Intentalo de Nuevo</a>");
    }
%>