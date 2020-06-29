<%-- 
    Document   : header
    Created on : 26/06/2020, 06:35:16
    Author     : gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="header">
    <div class="container-fluid logo">
        <div class="row">
            <div class="col-sm">
                <a href="/">
                    <img src="../assets/logo.png" />
                </a>
            </div>
            <div class="col-sm login">
                <%@include file="login.jsp" %>
            </div>
        </div>
    </div>

    <nav class="navbar navbar-expand-lg">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Início</a>
                </li>
                <%@include file="categorias.jsp" %>
            </ul>
        </div>
    </nav>
</div>
