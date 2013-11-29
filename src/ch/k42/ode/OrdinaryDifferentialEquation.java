package ch.k42.ode;

import cern.colt.matrix.DoubleMatrix1D;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 18:00
 * To change this template use File | Settings | File Templates.
 */
public interface OrdinaryDifferentialEquation {

    /**
     * calculates y' = f(x,y)
     * @param x input
     * @param y last step
     * @return derivative
     */
    public DoubleMatrix1D eval(DoubleMatrix1D x, DoubleMatrix1D y);
}
