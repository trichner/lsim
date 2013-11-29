package ch.k42.lsim.model;

import cern.colt.function.DoubleFunction;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 22:40
 * To change this template use File | Settings | File Templates.
 */
public class ConstMult implements DoubleFunction {
    private double constant;

    public ConstMult(double constant) {
        this.constant = constant;
    }

    @Override
    public double apply(double v) {
        return v*constant;
    }
}