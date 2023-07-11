package com.ejercicio.myaskgpt.main.Enums;

public enum CostEnums {
    QUESTION (15.00);

    private final double value;
    CostEnums(double value){
        this.value = value;
    }

    public static double valueOfQuestion(){
        return QUESTION.value;
    }
}
