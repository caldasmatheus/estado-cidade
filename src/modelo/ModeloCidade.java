/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static com.sun.org.apache.regexp.internal.RETest.test;
import static jdk.nashorn.internal.objects.NativeRegExp.test;

/**
 *
 * @author mathe
 */
public class ModeloCidade {
    
    private int codigo;
    private String nome;
    private int cod_estado;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cod_estado
     */
    public int getCod_estado() {
        return cod_estado;
    }

    /**
     * @param cod_estado the cod_estado to set
     */
    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }
    
}
