package com.ItsAdamLY;

public class Function
{
    @FunctionalInterface
    public interface MathFunction
    {
        double[] param(double x, double[] y);
    }
}
