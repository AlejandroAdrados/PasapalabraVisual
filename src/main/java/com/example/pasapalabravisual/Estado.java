/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.pasapalabravisual;

/**
 *
 * ¡ * @author Julia Martínez Vélez
 *
 * @author Ana León Cruz
 * @author Marta Soria Morales
 */
enum Estado {
    ACERTADO, FALLADO, NO_COTESTADO;

    public Estado getACERTADO() {
        return ACERTADO;
    }

    public static Estado getFALLADO() {
        return FALLADO;
    }

    public static Estado getNO_COTESTADO() {
        return NO_COTESTADO;
    }

}
