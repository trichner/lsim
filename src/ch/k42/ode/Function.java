package ch.k42.ode;

import cern.colt.matrix.DoubleMatrix1D;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public interface Function {
    public DoubleMatrix1D eval(DoubleMatrix1D vector);
}
