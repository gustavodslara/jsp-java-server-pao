/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavolara.tsi.javaserverpao.persistence;

import com.gustavolara.tsi.javaserverpao.model.Categoria;
import com.gustavolara.tsi.javaserverpao.model.Produto;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gustavo
 */
public class ProdutoDao extends Dao {

    public void create(Produto p) throws SQLException {
        open();
        stmt = con.prepareStatement("insert into produtos"
                + "(nome, descricao, valor, imagem, id_categoria) "
                + "values(?,?,?,?,?)");
        stmt.setString(1, p.getNome());
        stmt.setString(1, p.getDescricao());
        stmt.setDouble(1, p.getValor().doubleValue());
        stmt.setString(1, p.getImagem());
        stmt.setLong(1, p.getCategoria().getId());
        stmt.execute();
        stmt.close();
        close();
    }

    public void delete(Long cod) throws SQLException {
        open();
        stmt = con.prepareStatement("delete from produtos where id = ?");
        stmt.setLong(1, cod);
        stmt.execute();
        stmt.close();
        close();
    }

    public void update(Produto p) throws SQLException {
        open();
        stmt = con.prepareStatement("update produtos "
                + "set nome = ?, "
                + "descricao = ?, "
                + "valor = ?, "
                + "imagem = ?, "
                + "id_categoria = ? "
                + "where id = ?");
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getDescricao());
        stmt.setDouble(3, p.getValor().doubleValue());
        stmt.setString(4, p.getImagem());
        stmt.setLong(5, p.getCategoria().getId());
        stmt.setLong(6, p.getId());
        stmt.execute();
        stmt.close();
        close();
    }

    public List<Produto> findAll() throws SQLException {
        open();
        stmt = con.prepareStatement("select p.*, c.nome from produtos p inner join categorias c on p.id_categoria = c.id;");
        rs = stmt.executeQuery();
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getLong(1));
            produto.setNome(rs.getString(2));
            produto.setDescricao(rs.getString(3));
            produto.setValor(BigDecimal.valueOf(rs.getDouble(4)));
            produto.setImagem(rs.getString(5));
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong(6));
            categoria.setNome(rs.getString(7));
            produto.setCategoria(categoria);
            lista.add(produto);
        }
        stmt.close();
        close();
        return lista;
    }

    public Produto findById(Long cod) throws SQLException {
        open();
        stmt = con.prepareStatement("select p.*, c.nome from produtos p inner join categorias c on p.id_categoria = c.id where p.id = ?");
        stmt.setLong(1, cod);
        rs = stmt.executeQuery();
        Produto produto = null;
        if (rs.next()) {
            produto = new Produto();
            produto.setId(rs.getLong(1));
            produto.setNome(rs.getString(2));
            produto.setDescricao(rs.getString(3));
            produto.setValor(BigDecimal.valueOf(rs.getDouble(4)));
            produto.setImagem(rs.getString(5));
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong(6));
            categoria.setNome(rs.getString(7));
            produto.setCategoria(categoria);
        }
        stmt.close();
        close();
        return produto;
    }
    
    public List<Produto> findAllDestaques() throws SQLException {
        open();
        stmt = con.prepareStatement("select p.*, c.nome from produtos p "
                + "inner join categorias c on p.id_categoria = c.id "
                + "inner join produtos_destaque pd on p.id = pd.id_produto;");
        rs = stmt.executeQuery();
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getLong(1));
            produto.setNome(rs.getString(2));
            produto.setDescricao(rs.getString(3));
            produto.setValor(BigDecimal.valueOf(rs.getDouble(4)));
            produto.setImagem(rs.getString(5));
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong(6));
            categoria.setNome(rs.getString(7));
            produto.setCategoria(categoria);
            lista.add(produto);
        }
        stmt.close();
        close();
        return lista;
    }
    
    public List<Produto> findByCategoria(Long cod) throws SQLException {
        open();
        stmt = con.prepareStatement("select p.*, c.nome from produtos p "
                + "inner join categorias c on p.id_categoria = c.id "
                + "where id_categoria = ?");
        stmt.setLong(1, cod);
        rs = stmt.executeQuery();
        List<Produto> lista = new ArrayList<>();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getLong(1));
            produto.setNome(rs.getString(2));
            produto.setDescricao(rs.getString(3));
            produto.setValor(BigDecimal.valueOf(rs.getDouble(4)));
            produto.setImagem(rs.getString(5));
            Categoria categoria = new Categoria();
            categoria.setId(rs.getLong(6));
            categoria.setNome(rs.getString(7));
            produto.setCategoria(categoria);
            lista.add(produto);
        }
        stmt.close();
        close();
        return lista;
    }
}
