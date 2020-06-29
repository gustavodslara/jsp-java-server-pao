<%-- 
    Document   : login
    Created on : 27/06/2020, 16:50:58
    Author     : gustavo
--%>

<%@page import="com.gustavolara.tsi.javaserverpao.model.ItemVenda"%>
<%@page import="java.util.List"%>
<%@page import="com.gustavolara.tsi.javaserverpao.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session != null) {
        Object logado = session.getAttribute("logado");
        if (logado == null) {
            out.println("<form class='form-login' method='POST' action='/Autenticar'>");
            out.println("<div class='form-group'>");
            out.println("<input type='email' class='input-login form-control' name='email' placeholder='Email'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<input type='password' class='input-login form-control' name='senha' placeholder='Senha'>");
            out.println("</div>");
            out.println("<button type='submit' class='btn btn-primary'>Entrar</button>");
            out.println("</form>");
        } else {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            out.println("<div class='usuario-logado'>");
            out.println("<span>Olá,</span>");
            out.println("<h4>" + usuario.getNome() + "</h4>");
            out.println("<div class='row pink'>");
            out.println("<div class='col pink'>");
            List<ItemVenda> carrinho = (List<ItemVenda>) session.getAttribute("carrinho");
            int qtd = carrinho != null ? carrinho.size() : 0;
            out.println("<a href='/carrinho.jsp' class='btn btn-primary' type='submit'>"
                    + "<img class='cart' src='../assets/shopping-cart.svg'>"
                    + qtd +"</a>");
            out.println("</div>");
            out.println("<div class='col pink'>");
            out.println("<form action='/Sair'><button class='btn btn-primary' type='submit'>Sair</button></form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
        }
    }
%>
