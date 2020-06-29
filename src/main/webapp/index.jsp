<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="frags/head.jsp" %>
    <%@include file="frags/navbar.jsp" %>
    <body>
        <%
            if (request.getParameter("semUsuario") != null) {
                out.println("<h3 style='color:red;' class='text-center'>Não é possível adicionar ao carrinho sem estar logado!");
            }
            if (request.getParameter("malPreenchido") != null) {
                out.println("<h3 style='color:red;' class='text-center'>Preencha corretamente o login!");
            }
            if (request.getParameter("dadosIncorretos") != null) {
                out.println("<h3 style='color:red;' class='text-center'>Usuário ou senha inválidos!");
            }
        %>
        <br>
        <br>
        <%@include file="frags/produtos.jsp" %>
        <%@include file="frags/jsBootstrap.jsp" %>
    </body>
</html>