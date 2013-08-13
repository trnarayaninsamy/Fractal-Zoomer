/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalzoomer.planes;

import fractalzoomer.core.Complex;

/**
 *
 * @author hrkalona2
 */
public class InversedLambda2Plane extends Plane {
    
    public InversedLambda2Plane() {
        
        super();
        
    }

    @Override
    public Complex getPixel(Complex pixel) {
        
        Complex temp = pixel.reciprocal();
        temp = temp.plus(0.5);
        return temp.times(temp.sub(1, 0));
        
    }
    
}
