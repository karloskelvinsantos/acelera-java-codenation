package com.challenge.desafio;

import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class ClasseCalculavel {
    
    @Somar
    private BigDecimal valor1;

    @Subtrair
    private BigDecimal valor2;

    @Somar
    private BigDecimal valor3;

    /**
     * @return the valor1
     */
    public BigDecimal getValor1() {
        return valor1;
    }

    /**
     * @param valor1 the valor1 to set
     */
    public void setValor1(BigDecimal valor1) {
        this.valor1 = valor1;
    }

    /**
     * @return the valor2
     */
    public BigDecimal getValor2() {
        return valor2;
    }

    /**
     * @param valor2 the valor2 to set
     */
    public void setValor2(BigDecimal valor2) {
        this.valor2 = valor2;
    }

    /**
     * @return the valor3
     */
    public BigDecimal getValor3() {
        return valor3;
    }

    /**
     * @param valor3 the valor3 to set
     */
    public void setValor3(BigDecimal valor3) {
        this.valor3 = valor3;
    }
}