/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalzoomer.planes.fold;

import fractalzoomer.core.Complex;
import fractalzoomer.planes.Plane;

/**
 *
 * @author hrkalona2
 */
public class FoldInPlane extends Plane {

    private Complex center;

    public FoldInPlane(double plane_transform_radius) {

        super();
        center = new Complex(plane_transform_radius, 0);

    }

    @Override
    public Complex getPixel(Complex pixel) {
        
        return pixel.fold_in(center);
  
    }
}
