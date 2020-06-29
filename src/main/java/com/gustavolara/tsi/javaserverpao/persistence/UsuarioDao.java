/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavolara.tsi.javaserverpao.persistence;

import com.gustavolara.tsi.javaserverpao.model.Perfil;
import com.gustavolara.tsi.javaserverpao.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class UsuarioDao extends Dao {

    public void create(Usuario u) throws SQLException {
        open();
        stmt = con.prepareStatement("insert into usuarios"
                + "(nome, email, senha, endereco, telefone, perfil) "
                + "values(?,?,?,?,?,?)");
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());
        stmt.setString(4, u.getEndereco());
        stmt.setString(5, u.getTelefone());
        stmt.setInt(6, u.getPerfil().ordinal());
        stmt.execute();
        stmt.close();
        close();
    }

    public void delete(Long cod) throws SQLException {
        open();
        stmt = con.prepareStatement("delete from usuarios where id = ?");
        stmt.setLong(1, cod);
        stmt.execute();
        stmt.close();
        close();
    }

    public void update(Usuario u) throws SQLException {
        open();
        stmt = con.prepareStatement("update usuarios "
                + "set nome = ?, "
                + "email = ?, "
                + "senha = ?, "
                + "endereco = ?, "
                + "telefone = ?, "
                + "perfil = ?, "
                + "where id = ?");
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setString(3, u.getSenha());
        stmt.setString(4, u.getEndereco());
        stmt.setString(5, u.getTelefone());
        stmt.setInt(6, u.getPerfil().ordinal());
        stmt.setLong(7, u.getId());
        stmt.execute();
        stmt.close();
        close();
    }

    public List<Usuario> findAll() throws SQLException {
        open();
        stmt = con.prepareStatement("select * from usuarios");
        rs = stmt.executeQuery();
        List<Usuario> lista = new ArrayList<>();
        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong(1));
            usuario.setNome(rs.getString(2));
            usuario.setEmail(rs.getString(3));
            usuario.setSenha(rs.getString(4));
            usuario.setEndereco(rs.getString(5));
            usuario.setTelefone(rs.getString(6));
            usuario.setPerfil(Perfil.fromInteger(rs.getInt(7)));
            lista.add(usuario);
        }
        stmt.close();
        close();
        return lista;
    }

    public Usuario findById(Long cod) throws SQLException {
        open();
        stmt = con.prepareStatement("select * from usuarios where id = ?");
        stmt.setLong(1, cod);
        rs = stmt.executeQuery();
        Usuario usuario = null;
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getLong(1));
            usuario.setNome(rs.getString(2));
            usuario.setEmail(rs.getString(3));
            usuario.setSenha(rs.getString(4));
            usuario.setEndereco(rs.getString(5));
            usuario.setTelefone(rs.getString(6));
            usuario.setPerfil(Perfil.fromInteger(rs.getInt(7)));
        }
        stmt.close();
        close();
        return usuario;
    }

    public Usuario getLoginInfo(String email) throws SQLException {
        open();
        stmt = con.prepareStatement("select id, nome, email, senha from usuarios where email = ?");
        stmt.setString(1, email);
        rs = stmt.executeQuery();
        Usuario usuario = null;
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getLong(1));
            usuario.setNome(rs.getString(2));
            usuario.setEmail(rs.getString(3));
            usuario.setSenha(rs.getString(4));
        }
        stmt.close();
        close();
        return usuario;
    }
}
