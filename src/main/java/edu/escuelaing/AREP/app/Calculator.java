package edu.escuelaing.AREP.app;

import java.util.List;
public class Calculator {
    public static Double calculateMedia(List<Double> lista1) {
        Double suma =0.0;
        for(Double x:lista1){
            suma += x;
        }
        return suma / lista1.size();
    }


    public static Double calcularDesviacion (List<Double> lista1) {
        Double calculo = 0.0;
        Double media = calculateMedia(lista1);
        int n = lista1.size();
        for (int i = 0; i < n; i++) {
            calculo += (double) Math.pow((lista1.get(i) - media), 2);
        }
        return (Double) Math.sqrt(calculo / (n - 1));
    }
}