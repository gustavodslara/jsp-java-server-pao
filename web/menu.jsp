<%-- 
    Document   : menu
    Created on : 28/02/2020, 21:24:37
    Author     : gustavo
--%>

<%@page import="db.ConnectionFactory"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="frag/headBootstrap.jsp" %>
</head>
<body>
    <%
        try {
            Connection c = ConnectionFactory.getConnectionFactory();
            Statement s = c.createStatement();
            String query = "SELECT * FROM CATEGORIA_PRODUTO";
            ResultSet r = s.executeQuery(query);
            while (r.next()) {
                out.println("<div class='container'>");
                out.println("<a class='btn' href='produtos.jsp/cod_cat='");
                out.println(r.getString("codigo_categoria") + "/>");
                out.println(r.getString("nome_categoria") + "</a>");
                out.println("</div>");
            }
            c.close();
        } catch (SQLException ex) {
            out.println("Erro de conexão" + ex);
        }
    %>
    <%@include file="frag/jsBootstrap.jsp" %>
</body>
</html>
