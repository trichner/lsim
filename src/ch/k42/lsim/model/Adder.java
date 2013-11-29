package ch.k42.lsim.model;

import cern.colt.function.DoubleDoubleFunction;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 22:45
 * To change this template use File | Settings | File Templates.
 */
public class Adder implements DoubleDoubleFunction {
    @Override
    public double apply(double v, double v2) {
            return v+v2;
    }
}
