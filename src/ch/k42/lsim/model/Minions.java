package ch.k42.lsim.model;

import cern.colt.function.DoubleDoubleFunction;
import cern.colt.function.DoubleFunction;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;
import cern.colt.matrix.linalg.EigenvalueDecomposition;
import cern.colt.matrix.linalg.Matrix2DMatrix2DFunction;
import cern.jet.math.Functions;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class Minions {

    private static Algebra algebra = Algebra.DEFAULT;

    public static DoubleMatrix2D add(final DoubleMatrix2D A, final DoubleMatrix2D B){
        return A.assign(B,new Adder());
    }
    public static DoubleMatrix2D subtract(final DoubleMatrix2D A, final DoubleMatrix2D B){
        return A.assign(B,new Subtractor());
    }

    public static DoubleMatrix2D expm(final DoubleMatrix2D A){

        if(A.rows()!=A.columns())
            throw new IllegalArgumentException("Matrix not square");


        // [V,D] = EIG(X) and EXPM(X) = V*diag(exp(diag(D)))/V

        EigenvalueDecomposition eig = new EigenvalueDecomposition(A);

        DoubleMatrix2D V = eig.getV();
        System.out.println(V);
        DoubleMatrix2D D = eig.getD();
        System.out.println(D);

        DoubleMatrix2D ret;

        ret = expm_diag(D);
        ret = algebra.mult(V,ret);
        ret = algebra.mult(ret,algebra.inverse(V));
        return ret;
    }

    private static DoubleMatrix2D expm_diag(final DoubleMatrix2D A){
        DoubleMatrix2D ret = A.copy();
        if(ret.rows()!=ret.columns())
            throw new IllegalArgumentException("Matrix not square");

        for(int i=0;i<ret.rows();i++){
            ret.set(i,i,Functions.exp.apply(ret.get(i,i)));
        }
        return ret;
    }
}
