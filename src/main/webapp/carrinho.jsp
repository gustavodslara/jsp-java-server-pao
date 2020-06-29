<%@page import="com.gustavolara.tsi.javaserverpao.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="frags/head.jsp" %>
    <%@include file="frags/navbar.jsp" %>
    <body>
        <br><br>
        <%
            if (session != null) {
                Boolean logado = (Boolean) session.getAttribute("logado");
                if (logado != null && logado) {
                    List<ItemVenda> carrinho = (List<ItemVenda>) session.getAttribute("carrinho");
                    carrinho = carrinho != null ? carrinho : new ArrayList<ItemVenda>();
                    out.println("<div class='container'>");
                    for (ItemVenda item : carrinho) {
                        Produto p = item.getProduto();
                        out.println("<div class='row d-flex justify-content-center'>");
                        out.println("<div class='card carrinho'>");
                        out.println("<div class='row no-gutters'>");
                        out.println("<div class='col-auto'>");
                        out.println("<img class='img-fluid'"
                                + " src='" + p.getImagem() + "'alt='" + p.getNome() + "'>");
                        out.println("</div>");
                        out.println("<div class='col'>");
                        out.println("<div class='card-block px-2'>");
                        out.println("<h4 class='card-title'>" + p.getNome() + "</h4>");
                        out.println("<p class='card-text'>" + p.getDescricao() + "</p>");
                        out.println("<p style='vertical-align:text-bottom'>Preço:R$"
                                + p.getValor() + "</p>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("<div class='card-footer w-100 text-muted'>");
                        out.println("<h5 style='background-color:transparent;'>Quantidade: " + item.getQtd() + "</h5>");
                        out.println("<p style='background-color:transparent;'>Total: R$" + item.getTotal() + "</p>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("<br>");
                    }
                    out.println("</div>");
                }
            }

            out.println("");
        %>
        <br><br>
        <%@include file="frags/jsBootstrap.jsp" %>
    </body>
</html>