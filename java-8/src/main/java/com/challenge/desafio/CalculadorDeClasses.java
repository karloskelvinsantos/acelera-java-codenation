package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        BigDecimal soma = BigDecimal.ZERO;
        try {
            for (Field field : obj.getClass().getFields()) {
                if (field.isAnnotationPresent(Somar.class) && field.getType().isInstance(BigDecimal.class)) {
                    soma.add((BigDecimal) field.get(obj));
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return soma;
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        BigDecimal soma = BigDecimal.ZERO;
        try {
            for (Field field : obj.getClass().getFields()) {
                if (field.isAnnotationPresent(Subtrair.class) && field.getType().isInstance(BigDecimal.class)) {
                    soma.add((BigDecimal) field.get(obj));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soma;
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return somar(obj).subtract(subtrair(obj));
    }
}