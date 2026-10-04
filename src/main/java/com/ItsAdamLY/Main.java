package main.java.com.ItsAdamLY;

import main.java.com.ItsAdamLY.Solvers.ODE;

public class Main
{
    public static void main(String[] args)
    {
        ODE ode = new ODE();

        Function.MathFunction function = (x, y) -> new double[]
                {
                        3*y[0] + 2*y[1] - (2*Math.pow(x,2) + 1)*Math.exp(2*x),
                        4*y[0] + y[1] + (Math.pow(x,2) + 2*x - 4)*Math.exp(2*x)
                };

        double[] y = new double[]{1, 1};
        double x = 0.0;
        double h = 0.1; // Step size

        double[][] result = ode.RungeKutta4(function, 0.0, 1.0, y, h);

        for (double[] doubles : result)
        {
            double exact_u1 = Math.exp(5*x)/3 - Math.exp(-x)/3 + Math.exp(2*x);
            double exact_u2 = Math.exp(5*x)/3 + 2*Math.exp(-x)/3 + Math.pow(x,2)*Math.exp(2*x);

            System.out.printf("%-5.1f | %-12.8f | %-12.8f | %-12.8f | %-12.8f%n", x, doubles[0], exact_u1, doubles[1], exact_u2);

            x += h;
        }
    }
}