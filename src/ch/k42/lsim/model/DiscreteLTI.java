package ch.k42.lsim.model;

import cern.colt.function.DoubleDoubleFunction;
import cern.colt.matrix.DoubleFactory1D;
import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix1D;
import cern.colt.matrix.linalg.Algebra;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */
public class DiscreteLTI {

    private DoubleMatrix2D A;
    private DoubleMatrix2D B;
    private DoubleMatrix2D C;
    private DoubleMatrix2D D;

    private DoubleMatrix1D x; // state
    private DoubleMatrix1D y; // output

    private Algebra algebra = new Algebra();


    private void init(DoubleMatrix2D A, DoubleMatrix2D B, DoubleMatrix2D C, DoubleMatrix2D D, DoubleMatrix1D x0){
        this.A = A;
        this.B = B;
        this.C = C;
        this.D = D;
        this.x = x0;
    }

    public DiscreteLTI(DoubleMatrix2D A, DoubleMatrix2D B, DoubleMatrix2D C, DoubleMatrix2D D, DoubleMatrix1D x0){
        // Do dimension checks
        init(A,B,C,D,x0);
    }

    public DiscreteLTI(DoubleMatrix2D A, DoubleMatrix2D B, DoubleMatrix2D C, DoubleMatrix2D D){
        // Do dimension checks
        DoubleMatrix1D x0 = DoubleFactory1D.dense.make(A.columns(),0);
        init(A,B,C,D,x0);
    }

    public DoubleMatrix1D step(final DoubleMatrix1D u){

        //---- x = A*x + B*u
        DoubleMatrix1D t1 = algebra.mult(A,x);
        DoubleMatrix1D t2 = algebra.mult(B,u);
        x = t1.assign(t2,new Adder());

        //---- y = C*x + D*u
        t1 = algebra.mult(C,x);
        t2 = algebra.mult(D,u);
        y = t1.assign(t2,new Adder());

        return y;
    }

    public DoubleMatrix1D getY() {
        return y;
    }

    public DoubleMatrix1D getX() {
        return x;
    }

    public DoubleMatrix2D getD() {
        return D;
    }

    public DoubleMatrix2D getC() {
        return C;
    }

    public DoubleMatrix2D getB() {
        return B;
    }

    public DoubleMatrix2D getA() {
        return A;
    }
}
