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
public class SmoothEscapeTimeColorDecompositionMagnet extends ColorDecomposition {

    protected double log_convergent_bailout;
    protected int algorithm;

    public SmoothEscapeTimeColorDecompositionMagnet(double log_convergent_bailout, int algorithm) {

        super();
        this.log_convergent_bailout = log_convergent_bailout;
        this.algorithm = algorithm;

    }

    @Override
    public double getResult(Object[] object) {


        double temp3 = 0;
        if(!(Boolean)object[2]) {
            if(algorithm == 0) {
                double temp = Math.log(((Complex)object[4]).distance_squared(1));
                temp3 = (log_convergent_bailout - temp) / (Math.log((Double)object[3]) - temp);
            }
            else {
                double temp4 = Math.log(((Double)object[3]));

                double power = temp4 / Math.log(((Complex)object[4]).distance_squared(1));

                double f = Math.log(log_convergent_bailout / temp4) / Math.log(power);

                temp3 = f;
            }
        }

        return Math.abs(((Integer)object[0]) + (((Complex)object[1]).arg() / pi2 + 0.75) * pi59 + temp3) + 100800;

    }
}
