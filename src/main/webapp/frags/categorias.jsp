<%-- 
    Document   : categorias
    Created on : 26/06/2020, 03:09:26
    Author     : gustavo
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.util.List"%>
<%@page import="com.gustavolara.tsi.javaserverpao.model.Categoria"%>
<%@page import="com.gustavolara.tsi.javaserverpao.persistence.CategoriaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    try {
        CategoriaDao categoriaDao = new CategoriaDao();
        List<Categoria> categorias = categoriaDao.findAll();
        for (Categoria c : categorias) {
            out.println("<li class='nav-item'>");
            out.println("<a class='nav-link' href='/?categoria=" + c.getId() + "'>");
            out.println(c.getNome());
            out.println("</a>");
            out.println("</li>");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
%>
