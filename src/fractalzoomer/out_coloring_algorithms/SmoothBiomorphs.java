/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalzoomer.out_coloring_algorithms;

import fractalzoomer.core.Complex;

/**
 *
 * @author hrkalona2
 */
public class SmoothBiomorphs extends OutColorAlgorithm {

    protected double log_bailout_squared;
    protected double bailout;
    protected int algorithm;

    public SmoothBiomorphs(double log_bailout_squared, double bailout, int algorithm) {

        super();
        this.log_bailout_squared = log_bailout_squared;
        this.bailout = bailout;
        this.algorithm = algorithm;

    }

    @Override
    public double getResult(Object[] object) {

        if(algorithm == 0) {
            double temp = ((Complex)object[2]).norm_squared();
            double temp2 = ((Complex)object[1]).norm_squared();

            temp += 0.000000001;
            temp = Math.log(temp);

            double temp3 = (Integer)object[0] + (log_bailout_squared - temp) / (Math.log(temp2) - temp);

            double temp4 = ((Complex)object[1]).getRe();
            double temp5 = ((Complex)object[1]).getIm();

            return temp4 > -bailout && temp4 < bailout || temp5 > -bailout && temp5 < bailout ? temp3 + 100800 : temp3 + 100850;
        }
        else {
            double temp = ((Complex)object[2]).norm_squared();
            double temp2 = ((Complex)object[1]).norm_squared();

            temp2 = Math.log(temp2);
            double p = temp2 / Math.log(temp);
            
            p = p <= 0 ? 1e-33 : p;

            double a = Math.log(temp2 / log_bailout_squared);
            double f = a / Math.log(p);

            double temp3 = (Integer)object[0] + 1 - f;

            double temp4 = ((Complex)object[1]).getRe();
            double temp5 = ((Complex)object[1]).getIm();

            return temp4 > -bailout && temp4 < bailout || temp5 > -bailout && temp5 < bailout ? temp3 + 100800 : temp3 + 100850;
        }

    }

    @Override
    public double getResult3D(Object[] object) {

        return getResult(object);

    }
}
