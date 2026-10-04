package main.java.com.ItsAdamLY.Solvers;

import main.java.com.ItsAdamLY.Function;

public class ODE
{
    private final LinAlg linAlg;

    public ODE()
    {
        this.linAlg = new LinAlg();
    }

    public double[][] RungeKutta4(Function.MathFunction f, double a, double b, double[] y0, double h)
    {
        int N = (int) ((b - a) / h);

        double t = a;
        double[] y = new double[y0.length]; // Match state vector dimension
        double[][] result = new double[N + 1][y0.length]; // Store results for each step
        result[0] = y0.clone(); // Store initial condition

        for (int i = 0; i < N; i++)
        {
            double[] k1 = f.param(t, y0);
            double[] k2 = f.param(t + h / 2.0, linAlg.vAddition(y0, linAlg.vScalarMultiply(h / 2.0, k1)));
            double[] k3 = f.param(t + h / 2.0, linAlg.vAddition(y0, linAlg.vScalarMultiply(h / 2.0, k2)));
            double[] k4 = f.param(t + h, linAlg.vAddition(y0, linAlg.vScalarMultiply(h, k3)));

            // y_{n+1} = y_n + h*(k1 + 2k2 + 2k3 + k4)/6 componentwise
            for (int j = 0; j < y0.length; j++)
            {
                y[j] = y0[j] + h * (k1[j] + 2.0 * k2[j] + 2.0 * k3[j] + k4[j]) / 6.0;
            }

            // Update for next iteration
            t += h;
            System.arraycopy(y, 0, y0, 0, y.length); // Update y0 for the next step
            result[i + 1] = y.clone(); // Store the result for this step
        }

        return result;
    }
}