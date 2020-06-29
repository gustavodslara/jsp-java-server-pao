/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavolara.tsi.javaserverpao.controller;

import com.gustavolara.tsi.javaserverpao.model.ItemVenda;
import com.gustavolara.tsi.javaserverpao.model.Produto;
import com.gustavolara.tsi.javaserverpao.persistence.ProdutoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gustavo
 */
public class AdicionarProduto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Boolean logado = (Boolean) session.getAttribute("logado");
            if (logado != null && logado) {

                int qtd = Integer.parseInt(request.getParameter("quantidade"));
                Long codProduto = Long.parseLong(request.getParameter("produto"));
                List<ItemVenda> carrinho = (List<ItemVenda>) session.getAttribute("carrinho");

                carrinho = carrinho != null ? carrinho : new ArrayList<ItemVenda>();
                Produto p = null;
                ProdutoDao produtoDao = new ProdutoDao();

                for (ItemVenda item : carrinho) {
                    if (item.getProduto().getId().equals(codProduto)) {
                        p = item.getProduto();
                        item.setQtd(item.getQtd() + qtd);
                        BigDecimal total = p.getValor()
                                .multiply(BigDecimal.valueOf(item.getQtd()));
                        item.setTotal(total);
                        break;
                    }
                }
                if (p == null) {
                    try {
                        p = p != null ? p : produtoDao.findById(codProduto);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    BigDecimal total = p.getValor().multiply(BigDecimal.valueOf(qtd));
                    ItemVenda item = new ItemVenda(p, qtd, total);
                    carrinho.add(item);
                }
                session.setAttribute("carrinho", carrinho);
                response.sendRedirect(request.getHeader("referer"));
            } else {
                response.sendRedirect("/?semUsuario=1");
            }
        } else {
            response.sendRedirect("/?semUsuario=1");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
