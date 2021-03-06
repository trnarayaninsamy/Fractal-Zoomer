/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalzoomer.planes.general;

import fractalzoomer.core.Complex;
import fractalzoomer.planes.Plane;

/**
 *
 * @author hrkalona2
 */
public class CircleInversionPlane extends Plane {

    private Complex center;
    private double plane_transform_radius;

    public CircleInversionPlane(double[] plane_transform_center, double plane_transform_radius) {

        super();
        center = new Complex(plane_transform_center[0], plane_transform_center[1]);
        this.plane_transform_radius = plane_transform_radius;

    }

    @Override
    public Complex getPixel(Complex pixel) {
        
        return pixel.circle_inversion(center, plane_transform_radius);
        
    }
}
