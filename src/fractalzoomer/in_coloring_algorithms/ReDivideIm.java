package fractalzoomer.in_coloring_algorithms;

import fractalzoomer.in_coloring_algorithms.options.InColorOption;
import fractalzoomer.in_coloring_algorithms.options.InColorOptionDouble;
import fractalzoomer.in_coloring_algorithms.options.InColorOptionInt;
import fractalzoomer.core.Complex;
import fractalzoomer.main.MainWindow;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrkalona2
 */
public class ReDivideIm extends InColorAlgorithm {
  private InColorOption option;

    

    public ReDivideIm(int out_coloring_algorithm) { 
        super();
        
        if(out_coloring_algorithm == MainWindow.NORMAL || out_coloring_algorithm == MainWindow.BINARY_DECOMPOSITION || out_coloring_algorithm == MainWindow.BINARY_DECOMPOSITION2 || out_coloring_algorithm == MainWindow.BIOMORPH) {
            option = new InColorOptionInt();
        }
        else {
            option = new InColorOptionDouble();
        }
    
    }
    
    @Override
    public double getResult(Object[] object) {
        
        return option.getFinalResult(Math.abs(((Complex)object[1]).getRe() / ((Complex)object[1]).getIm()) * 8  + 100820);

    }
    
}
