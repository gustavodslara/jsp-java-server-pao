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
@NoArgsConstructor
@AllArgsConstructor
public class ItemVenda {

    @Getter
    @Setter
    private Produto produto;
    @Getter
    @Setter
    private int qtd;
    @Getter
    @Setter
    private BigDecimal total;
}
