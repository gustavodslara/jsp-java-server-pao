/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavolara.tsi.javaserverpao.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author gustavo
 */
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String nome;
    @Getter
    @Setter
    private String descricao;
    @Getter
    @Setter
    private BigDecimal valor;
    @Getter
    @Setter
    private String imagem;
    @Getter
    @Setter
    private Categoria categoria;

}
