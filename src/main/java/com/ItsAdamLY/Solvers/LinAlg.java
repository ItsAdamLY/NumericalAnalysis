package com.ItsAdamLY.Solvers;

public class LinAlg
{
    public double[] mvMultiply(double[][] matrix, double[] vector)
    {
        // matrix * vector = vector
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (cols != vector.length)
            throw new IllegalArgumentException("Matrix columns must match vector length.");

        double[] mvProduct = new double[rows];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                mvProduct[i] += matrix[i][j] * vector[j];
            }
        }
        return mvProduct;
    }

    public double[] vScalarMultiply(double scalar, double[] vector)
    {
        double[] product = new double[vector.length];

        for (int i = 0; i < vector.length; i++)
        {
            product[i] += scalar * vector[i];
        }

        return product;
    }

    public double[] vAddition(double[] v1, double[] v2)
    {
        if (v1.length != v2.length)
            throw new IllegalArgumentException("Vectors must be of the same length.");

        double[] vSum = new double[v1.length];

        for (int i = 0; i < v1.length; i++)
        {
            vSum[i] = v1[i] + v2[i];
        }

        return vSum;
    }
}
