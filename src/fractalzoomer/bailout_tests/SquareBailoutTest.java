package fractalzoomer.bailout_tests;

import fractalzoomer.core.Complex;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrkalona2
 */
public class SquareBailoutTest extends BailoutTest {
 
    public SquareBailoutTest(double bound) {
        
        super(bound);
        
    }
    
     @Override //infinity norm   
     public boolean escaped(Complex z) {
         
        return z.getAbsRe() >= bound || z.getAbsIm() >= bound;
         
     }
    
}
