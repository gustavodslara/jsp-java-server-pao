/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gustavolara.tsi.javaserverpao.model;

/**
 *
 * @author gustavo
 */
public enum Perfil {
    USUARIO {
        @Override
        public String toString() {
            return "Usuário";
        }
    },
    CLIENTE {
        @Override
        public String toString() {
            return "Cliente";
        }
    };

    public static Perfil fromInteger(int x) {
        return x == 0 ? USUARIO : CLIENTE;
    }
}
