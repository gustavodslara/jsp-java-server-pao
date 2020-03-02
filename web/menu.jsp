<%-- 
    Document   : menu
    Created on : 28/02/2020, 21:24:37
    Author     : Aluno
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="db.ConnectionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%            
            try {
                Connection c = ConnectionFactory.getConnectionFactory();
                Statement s = c.createStatement();
                String query = "SELECT * FROM CATEGORIA_PRODUTO";
                ResultSet r = s.executeQuery(query);
                while (r.next()) {
                    out.println("<a href='produtos.jsp/cod_cat='");
                    out.println(r.getString("codigo_categoria") + "/>");
                    out.println(r.getString("nome_categoria") + "</a>");
                }
                c.close();
            } catch (SQLException ex) {
                out.println("Erro de conexão" + ex);
            }
            %>
    </body>
</html>
