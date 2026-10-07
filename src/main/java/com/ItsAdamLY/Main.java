package com.ItsAdamLY;

import com.ItsAdamLY.Solvers.ODE;

public class Main
{
    public static void main(String[] args)
    {
        ODE ode = new ODE();

        double omega = 2.0;
        Function.MathFunction function = (x, y) -> new double[]
                {
                        y[1],
                        (Math.exp(2*x)*Math.sin(x)) - 2*y[0] + 2*y[1]
                };

        double[] y = new double[]{-0.4 , -0.6};
        double x = 0.0;
        double h = 0.1; // Step size

        double[][] result = ode.RungeKutta4(function, 0.0, 1.0, y, h);

        for (double[] doubles : result)
        {
            double exact_u1 = 0.2*Math.exp(2*x)*(Math.sin(x) - 2*Math.cos(x));
            double exact_u2 = 0.2*Math.exp(2*x)*(4*Math.sin(x) - 3*Math.cos(x));

            System.out.printf("%-5.1f | %-12.8f | %-12.8f | %-12.8f | %-12.8f%n", x, doubles[0], exact_u1, doubles[1], exact_u2);
            x += h;
        }
    }
}