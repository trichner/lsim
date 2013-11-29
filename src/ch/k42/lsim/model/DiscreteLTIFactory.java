package ch.k42.lsim.model;

import cern.colt.matrix.DoubleFactory1D;
import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
public class DiscreteLTIFactory {

    private Algebra algebra = Algebra.DEFAULT;

    public DiscreteLTI fromContinousLTI(DoubleMatrix2D A, DoubleMatrix2D B, DoubleMatrix2D C, DoubleMatrix2D D,DoubleMatrix1D x0, double T_s){
        DoubleMatrix2D AT = A.assign(new ConstMult(T_s));
        DoubleMatrix2D A_d = Minions.expm(AT); // e^A*T
        DoubleMatrix2D Ainv = algebra.inverse(A);

        DoubleMatrix2D B_d = algebra.mult(algebra.mult(Ainv,Minions.subtract(A_d, DoubleFactory2D.dense.identity(A.rows()))),B);// A^(-1)*(A_d-I)*B

        return new DiscreteLTI(A_d,B_d,C,D,x0);
    }

    public DiscreteLTI fromContinousLTI(DoubleMatrix2D A, DoubleMatrix2D B, DoubleMatrix2D C, DoubleMatrix2D D, double T_s){
        return fromContinousLTI(A,B,C,D, DoubleFactory1D.dense.make(A.rows(),0),T_s);
    }
}
