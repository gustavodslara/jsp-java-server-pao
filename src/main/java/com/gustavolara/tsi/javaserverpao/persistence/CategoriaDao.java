/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavolara.tsi.javaserverpao.persistence;

import com.gustavolara.tsi.javaserverpao.model.Categoria;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class CategoriaDao extends Dao {

    public void create(Categoria c) throws SQLException {
        open();
        stmt = con.prepareStatement("insert into categorias(nome) values(?)");
        stmt.setString(1, c.getNome());
        stmt.execute();
        stmt.close();
        close();
    }

    public void delete(Long cod) throws SQLException {
        open();
        stmt = con.prepareStatement("delete from categorias where id = ?");
        stmt.setLong(1, cod);
        stmt.execute();
        stmt.close();
        close();
    }

    public void update(Categoria c) throws SQLException {
        open();
        stmt = con.prepareStatement("update categorias set nome = ? where id = ?");
        stmt.setString(1, c.getNome());
        stmt.setLong(2, c.getId());
        stmt.execute();
        stmt.close();
        close();
    }

    public List<Categoria> findAll() throws SQLException {
        open();
        stmt = con.prepareStatement("select * from categorias");
        rs = stmt.executeQuery();
        List<Categoria> lista = new ArrayList<>();
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong(1));
            categoria.setNome(rs.getString(2));
            lista.add(categoria);
        }
        stmt.close();
        close();
        return lista;
    }

    public Categoria findById(Long cod) throws SQLException {
        open();
        stmt = con.prepareStatement("select * from categorias where id = ?");
        stmt.setLong(1, cod);
        rs = stmt.executeQuery();
        Categoria categoria = null;
        if (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getLong(1));
            categoria.setNome(rs.getString(2));
        }
        stmt.close();
        close();
        return categoria;
    }
}
