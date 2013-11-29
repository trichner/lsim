package ch.k42.lsim.main;

import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix1D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix1D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;
import cern.colt.matrix.linalg.QRDecomposition;
import ch.k42.lsim.model.Minions;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas
 * Date: 29.11.13
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        DoubleMatrix2D A = DoubleFactory2D.dense.identity(3);

        double[][] rawA = {{3,1},{1,1}};

        DoubleMatrix2D B= DoubleFactory2D.dense.make(rawA);

        A = Minions.expm(A);
        System.out.println(A);

        B = Minions.expm(B);
        System.out.println(B);

    }
}
