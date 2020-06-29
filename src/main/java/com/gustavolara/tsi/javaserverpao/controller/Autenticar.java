/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavolara.tsi.javaserverpao.controller;

import com.gustavolara.tsi.javaserverpao.model.Usuario;
import com.gustavolara.tsi.javaserverpao.persistence.UsuarioDao;
import com.gustavolara.tsi.javaserverpao.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gustavo
 */
public class Autenticar extends HttpServlet {

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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean logado = false;
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            response.sendRedirect("/?malPreenchido=1");
        } else {
            senha = Util.md5Hash(senha);
            UsuarioDao usuarioDao = new UsuarioDao();
            try {
                Usuario usuario = usuarioDao.getLoginInfo(email);
                HttpSession session = request.getSession(true);
                logado = usuario != null ? usuario.getSenha().equals(senha) : false;
                if (logado) {
                    session.setAttribute("logado", logado);
                    usuario.setSenha("");
                    session.setAttribute("usuario", usuario);
                } else {
                    session.invalidate();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            response.sendRedirect(logado ? "/" : "/?dadosIncorretos=1");
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
