/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrkalona2
 */
public class InversedMu3Plane extends Plane {

    public InversedMu3Plane() {

        super();

    }

    @Override
    public Complex getPixel(Complex pixel) {

        return pixel.divide(1, pixel).sub(1.401155189);

    }
}