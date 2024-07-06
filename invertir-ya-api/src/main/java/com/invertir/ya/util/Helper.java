package com.invertir.ya.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Helper
{
    public double calculateMortgage(double principal, double annualInterest, int period)
    {
        double monthlyInterest = annualInterest / 12 / 100;
        int numberOfPayments = period * 12;
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
