<%-- 
    Document   : produtos-destaque
    Created on : 27/06/2020, 17:18:55
    Author     : gustavo
--%>

<%@page import="com.gustavolara.tsi.javaserverpao.persistence.ProdutoDao"%>
<%@page import="java.util.List"%>
<%@page import="com.gustavolara.tsi.javaserverpao.model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ProdutoDao produtoDao = new ProdutoDao();
    String categoria = request.getParameter("categoria");
    List<Produto> produtos = (categoria == null)
            ? produtoDao.findAllDestaques()
            : produtoDao.findByCategoria(Long.parseLong(categoria));
    out.println("<div class='container pagina'>");
    out.println("<div class='row d-flex justify-content-center'>");
    int count = 0;
    for (Produto p : produtos) {
        if (count < 3) {
            out.println("<div class='col'>");
            out.println("<div class='card' style='width: 18rem;'>");
            out.println("<img class='card-img-top'"
                    + " src='" + p.getImagem() + "'alt='" + p.getNome() + "'>");
            out.println("<div class='card-body'>");
            out.println("<h5 class='card-title'>" + p.getNome() + "</h5>");
            out.println("<p class='card-text'>" + p.getDescricao() + "</p>");
            out.println("<p class='vertical-align:text-bottom'>Preço: R$" + p.getValor()+ "</p>");
            out.println("<form action='/AdicionarProduto'>");
            out.println("<div class='row'>");
            out.println("<div class='col'>");
            out.println("<input class='form-control quantidade' name='quantidade' type='number' value='1' min='1'>");
            out.println("</div>");
            out.println("<div class='col'>");
            out.println("<button type='submit' class='btn btn-primary'>Adicionar</button>");
            out.println("</div>");
            out.println("</div>");
            out.println("<input class='invisible' type='text' name='produto' value='" + p.getId() + "'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            count++;
        } else {
            count = 0;
            out.println("</div><br><br><br>");
            out.println("<div class='row d-flex justify-content-center'>");
        }
    }
    out.println("</div>");
    out.println("</div>");
%>
