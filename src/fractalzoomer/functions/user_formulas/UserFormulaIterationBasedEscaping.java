/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalzoomer.functions.user_formulas;

import fractalzoomer.core.Complex;
import fractalzoomer.fractal_options.DefaultInitialValue;
import fractalzoomer.fractal_options.DefaultPerturbation;
import fractalzoomer.fractal_options.InitialValue;
import fractalzoomer.fractal_options.Perturbation;
import fractalzoomer.functions.Julia;
import fractalzoomer.in_coloring_algorithms.AtanReTimesImTimesAbsReTimesAbsIm;
import fractalzoomer.in_coloring_algorithms.CosMag;
import fractalzoomer.in_coloring_algorithms.DecompositionLike;
import fractalzoomer.in_coloring_algorithms.MagTimesCosReSquared;
import fractalzoomer.in_coloring_algorithms.MaximumIterations;
import fractalzoomer.in_coloring_algorithms.ReDivideIm;
import fractalzoomer.in_coloring_algorithms.SinReSquaredMinusImSquared;
import fractalzoomer.in_coloring_algorithms.Squares;
import fractalzoomer.in_coloring_algorithms.Squares2;
import fractalzoomer.in_coloring_algorithms.ZMag;
import fractalzoomer.main.MainWindow;
import fractalzoomer.out_coloring_algorithms.BinaryDecomposition;
import fractalzoomer.out_coloring_algorithms.BinaryDecomposition2;
import fractalzoomer.out_coloring_algorithms.Biomorphs;
import fractalzoomer.out_coloring_algorithms.ColorDecomposition;
import fractalzoomer.out_coloring_algorithms.EscapeTime;
import fractalzoomer.out_coloring_algorithms.EscapeTimeColorDecomposition;
import fractalzoomer.out_coloring_algorithms.EscapeTimeAlgorithm1;
import fractalzoomer.out_coloring_algorithms.EscapeTimeAlgorithm2;
import fractalzoomer.out_coloring_algorithms.EscapeTimeEscapeRadius;
import fractalzoomer.out_coloring_algorithms.EscapeTimeGaussianInteger;
import fractalzoomer.out_coloring_algorithms.EscapeTimeGaussianInteger2;
import fractalzoomer.out_coloring_algorithms.EscapeTimeGaussianInteger3;
import fractalzoomer.out_coloring_algorithms.EscapeTimeGaussianInteger4;
import fractalzoomer.out_coloring_algorithms.EscapeTimeGaussianInteger5;
import fractalzoomer.out_coloring_algorithms.EscapeTimeGrid;
import fractalzoomer.out_coloring_algorithms.EscapeTimePlusIm;
import fractalzoomer.out_coloring_algorithms.EscapeTimePlusRe;
import fractalzoomer.out_coloring_algorithms.EscapeTimePlusReDivideIm;
import fractalzoomer.out_coloring_algorithms.EscapeTimePlusRePlusImPlusReDivideIm;
import fractalzoomer.out_coloring_algorithms.SmoothBinaryDecomposition;
import fractalzoomer.out_coloring_algorithms.SmoothBinaryDecomposition2;
import fractalzoomer.out_coloring_algorithms.SmoothBiomorphs;
import fractalzoomer.out_coloring_algorithms.SmoothEscapeTime;
import fractalzoomer.out_coloring_algorithms.SmoothEscapeTimeGrid;
import fractalzoomer.parser.ExpressionNode;
import fractalzoomer.parser.Parser;
import java.util.ArrayList;

/**
 *
 * @author hrkalona2
 */
public class UserFormulaIterationBasedEscaping extends Julia {
  private ExpressionNode[] expr;
  private Parser[] parser;
  private int iterations;
    
    public UserFormulaIterationBasedEscaping(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, double n_norm, int out_coloring_algorithm, int in_coloring_algorithm, boolean smoothing, boolean periodicity_checking, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean init_value, double[] initial_vals, String[] user_formula, String user_plane) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, n_norm, periodicity_checking, plane_type, rotation_vals, rotation_center, user_plane);
        
      
        if(perturbation) {
            pertur_val = new Perturbation(perturbation_vals[0], perturbation_vals[1]);
        }
        else {
            pertur_val = new DefaultPerturbation(perturbation_vals[0], perturbation_vals[1]);
        }
        
        if(init_value) {
            init_val = new InitialValue(initial_vals[0], initial_vals[1]);
        }
        else {
            init_val = new DefaultInitialValue(initial_vals[0], initial_vals[1]);
        }

        switch (out_coloring_algorithm) {

            case MainWindow.ESCAPE_TIME:
                if(!smoothing) {
                    out_color_algorithm = new EscapeTime();
                }
                else {
                    out_color_algorithm = new SmoothEscapeTime(Math.log(bailout_squared));
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION:
                if(!smoothing) {
                    out_color_algorithm = new BinaryDecomposition();
                }
                else {
                    out_color_algorithm = new SmoothBinaryDecomposition(Math.log(bailout_squared));
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION2:
                if(!smoothing) {
                    out_color_algorithm = new BinaryDecomposition2();
                }
                else {
                    out_color_algorithm = new SmoothBinaryDecomposition2(Math.log(bailout_squared));
                }
                break;
            case MainWindow.ITERATIONS_PLUS_RE:
                out_color_algorithm = new EscapeTimePlusRe();
                break;
            case MainWindow.ITERATIONS_PLUS_IM:
                out_color_algorithm = new EscapeTimePlusIm();
                break;
            case MainWindow.ITERATIONS_PLUS_RE_DIVIDE_IM:
                out_color_algorithm = new EscapeTimePlusReDivideIm();
                break;
            case MainWindow.ITERATIONS_PLUS_RE_PLUS_IM_PLUS_RE_DIVIDE_IM:
                out_color_algorithm = new EscapeTimePlusRePlusImPlusReDivideIm();
                break;
            case MainWindow.BIOMORPH:
                if(!smoothing) {
                    out_color_algorithm = new Biomorphs(bailout);
                }
                else {
                    out_color_algorithm = new SmoothBiomorphs(Math.log(bailout_squared), bailout);
                }
                break;
            case MainWindow.COLOR_DECOMPOSITION:
                out_color_algorithm = new ColorDecomposition();
                break;
            case MainWindow.ESCAPE_TIME_COLOR_DECOMPOSITION:
                out_color_algorithm = new EscapeTimeColorDecomposition();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER:
                out_color_algorithm = new EscapeTimeGaussianInteger();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER2:
                out_color_algorithm = new EscapeTimeGaussianInteger2();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER3:
                out_color_algorithm = new EscapeTimeGaussianInteger3();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER4:
                out_color_algorithm = new EscapeTimeGaussianInteger4();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER5:
                out_color_algorithm = new EscapeTimeGaussianInteger5();
                break;
            case MainWindow.ESCAPE_TIME_ALGORITHM:
                out_color_algorithm = new EscapeTimeAlgorithm1(2);
                break;
            case MainWindow.ESCAPE_TIME_ALGORITHM2:
                out_color_algorithm = new EscapeTimeAlgorithm2();
                break;
            case MainWindow.ESCAPE_TIME_ESCAPE_RADIUS:
                out_color_algorithm = new EscapeTimeEscapeRadius(Math.log(bailout_squared));
                break;
            case MainWindow.ESCAPE_TIME_GRID:
                if(!smoothing) {
                    out_color_algorithm = new EscapeTimeGrid(Math.log(bailout_squared));
                }
                else {
                    out_color_algorithm = new SmoothEscapeTimeGrid(Math.log(bailout_squared));
                }
                break;
                         
        }


        switch (in_coloring_algorithm) {
            
            case MainWindow.MAXIMUM_ITERATIONS:
                in_color_algorithm = new MaximumIterations();
                break;
            case MainWindow.Z_MAG:
                in_color_algorithm = new ZMag(smoothing);
                break;
            case MainWindow.DECOMPOSITION_LIKE:
                in_color_algorithm = new DecompositionLike(smoothing);       
                break;
            case MainWindow.RE_DIVIDE_IM:
                in_color_algorithm = new ReDivideIm(smoothing);       
                break;
            case MainWindow.COS_MAG:
                in_color_algorithm = new CosMag(smoothing);       
                break;
            case MainWindow.MAG_TIMES_COS_RE_SQUARED:
                in_color_algorithm = new MagTimesCosReSquared(smoothing);       
                break;
            case MainWindow.SIN_RE_SQUARED_MINUS_IM_SQUARED:
                in_color_algorithm = new SinReSquaredMinusImSquared(smoothing);       
                break;
            case MainWindow.ATAN_RE_TIMES_IM_TIMES_ABS_RE_TIMES_ABS_IM:
                in_color_algorithm = new AtanReTimesImTimesAbsReTimesAbsIm(smoothing);       
                break;
            case MainWindow.SQUARES:
                in_color_algorithm = new Squares(smoothing);       
                break;
            case MainWindow.SQUARES2:
                in_color_algorithm = new Squares2();       
                break;
                
        }
        
        parser = new Parser[user_formula.length];
        expr = new ExpressionNode[user_formula.length];
        
        for(int i = 0; i < parser.length; i++) {
            parser[i] = new Parser();
            expr[i] = parser[i].parse(user_formula[i]);   
        }   
       
    }

    public UserFormulaIterationBasedEscaping(double xCenter, double yCenter, double size, int max_iterations, int bailout_test_algorithm, double bailout, double n_norm, int out_coloring_algorithm, int in_coloring_algorithm, boolean smoothing, boolean periodicity_checking, int plane_type, double[] rotation_vals, double[] rotation_center, String[] user_formula, String user_plane, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, bailout_test_algorithm, bailout, n_norm, periodicity_checking, plane_type, rotation_vals, rotation_center, user_plane, xJuliaCenter, yJuliaCenter);
            
        switch (out_coloring_algorithm) {

            case MainWindow.ESCAPE_TIME:
                if(!smoothing) {
                    out_color_algorithm = new EscapeTime();
                }
                else {
                    out_color_algorithm = new SmoothEscapeTime(Math.log(bailout_squared));
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION:
                if(!smoothing) {
                    out_color_algorithm = new BinaryDecomposition();
                }
                else {
                    out_color_algorithm = new SmoothBinaryDecomposition(Math.log(bailout_squared));
                }
                break;
            case MainWindow.BINARY_DECOMPOSITION2:
                if(!smoothing) {
                    out_color_algorithm = new BinaryDecomposition2();
                }
                else {
                    out_color_algorithm = new SmoothBinaryDecomposition2(Math.log(bailout_squared));
                }
                break;
            case MainWindow.ITERATIONS_PLUS_RE:
                out_color_algorithm = new EscapeTimePlusRe();
                break;
            case MainWindow.ITERATIONS_PLUS_IM:
                out_color_algorithm = new EscapeTimePlusIm();
                break;
            case MainWindow.ITERATIONS_PLUS_RE_DIVIDE_IM:
                out_color_algorithm = new EscapeTimePlusReDivideIm();
                break;
            case MainWindow.ITERATIONS_PLUS_RE_PLUS_IM_PLUS_RE_DIVIDE_IM:
                out_color_algorithm = new EscapeTimePlusRePlusImPlusReDivideIm();
                break;
            case MainWindow.BIOMORPH:
                if(!smoothing) {
                    out_color_algorithm = new Biomorphs(bailout);
                }
                else {
                    out_color_algorithm = new SmoothBiomorphs(Math.log(bailout_squared), bailout);
                }
                break;
            case MainWindow.COLOR_DECOMPOSITION:
                out_color_algorithm = new ColorDecomposition();
                break;
            case MainWindow.ESCAPE_TIME_COLOR_DECOMPOSITION:
                out_color_algorithm = new EscapeTimeColorDecomposition();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER:
                out_color_algorithm = new EscapeTimeGaussianInteger();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER2:
                out_color_algorithm = new EscapeTimeGaussianInteger2();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER3:
                out_color_algorithm = new EscapeTimeGaussianInteger3();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER4:
                out_color_algorithm = new EscapeTimeGaussianInteger4();
                break;
            case MainWindow.ESCAPE_TIME_GAUSSIAN_INTEGER5:
                out_color_algorithm = new EscapeTimeGaussianInteger5();
                break;
            case MainWindow.ESCAPE_TIME_ALGORITHM:
                out_color_algorithm = new EscapeTimeAlgorithm1(2);
                break;
            case MainWindow.ESCAPE_TIME_ALGORITHM2:
                out_color_algorithm = new EscapeTimeAlgorithm2();
                break;
            case MainWindow.ESCAPE_TIME_ESCAPE_RADIUS:
                out_color_algorithm = new EscapeTimeEscapeRadius(Math.log(bailout_squared));
                break;
            case MainWindow.ESCAPE_TIME_GRID:
                if(!smoothing) {
                    out_color_algorithm = new EscapeTimeGrid(Math.log(bailout_squared));
                }
                else {
                    out_color_algorithm = new SmoothEscapeTimeGrid(Math.log(bailout_squared));
                }
                break;
                         
        }


        switch (in_coloring_algorithm) {
            
            case MainWindow.MAXIMUM_ITERATIONS:
                in_color_algorithm = new MaximumIterations();
                break;
            case MainWindow.Z_MAG:
                in_color_algorithm = new ZMag(smoothing);
                break;
            case MainWindow.DECOMPOSITION_LIKE:
                in_color_algorithm = new DecompositionLike(smoothing);       
                break;
            case MainWindow.RE_DIVIDE_IM:
                in_color_algorithm = new ReDivideIm(smoothing);       
                break;
            case MainWindow.COS_MAG:
                in_color_algorithm = new CosMag(smoothing);       
                break;
            case MainWindow.MAG_TIMES_COS_RE_SQUARED:
                in_color_algorithm = new MagTimesCosReSquared(smoothing);       
                break;
            case MainWindow.SIN_RE_SQUARED_MINUS_IM_SQUARED:
                in_color_algorithm = new SinReSquaredMinusImSquared(smoothing);       
                break;
            case MainWindow.ATAN_RE_TIMES_IM_TIMES_ABS_RE_TIMES_ABS_IM:
                in_color_algorithm = new AtanReTimesImTimesAbsReTimesAbsIm(smoothing);       
                break;
            case MainWindow.SQUARES:
                in_color_algorithm = new Squares(smoothing);       
                break;
            case MainWindow.SQUARES2:
                in_color_algorithm = new Squares2();       
                break;
                
        }
        
        parser = new Parser[user_formula.length];
        expr = new ExpressionNode[user_formula.length];
        
        for(int i = 0; i < parser.length; i++) {
            parser[i] = new Parser();
            expr[i] = parser[i].parse(user_formula[i]);   
        }    

    }

    //orbit
    public UserFormulaIterationBasedEscaping(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, double[] rotation_vals, double[] rotation_center, boolean perturbation, double[] perturbation_vals, boolean init_value, double[] initial_vals, String[] user_formula, String user_plane) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, rotation_center, user_plane);
        
        
        if(perturbation) {
            pertur_val = new Perturbation(perturbation_vals[0], perturbation_vals[1]);
        }
        else {
            pertur_val = new DefaultPerturbation(perturbation_vals[0], perturbation_vals[1]);
        }
        
        if(init_value) {
            init_val = new InitialValue(initial_vals[0], initial_vals[1]);
        }
        else {
            init_val = new DefaultInitialValue(initial_vals[0], initial_vals[1]);
        }
        
        parser = new Parser[user_formula.length];
        expr = new ExpressionNode[user_formula.length];
        
        for(int i = 0; i < parser.length; i++) {
            parser[i] = new Parser();
            expr[i] = parser[i].parse(user_formula[i]);   
        }    

    }

    public UserFormulaIterationBasedEscaping(double xCenter, double yCenter, double size, int max_iterations, ArrayList<Complex> complex_orbit, int plane_type, double[] rotation_vals, double[] rotation_center, String[] user_formula, String user_plane, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, rotation_center, user_plane, xJuliaCenter, yJuliaCenter);
        
        parser = new Parser[user_formula.length];
        expr = new ExpressionNode[user_formula.length];
        
        for(int i = 0; i < parser.length; i++) {
            parser[i] = new Parser();
            expr[i] = parser[i].parse(user_formula[i]);   
        }    
        
    }

    @Override
    protected void function(Complex[] complex) {
    
        if(iterations % 4 == 0) {
            if(parser[0].foundN()) {
                parser[0].setNvalue(new Complex(iterations, 0));
            }
            parser[0].setZvalue(complex[0]);

            if(parser[0].foundC()) {
                parser[0].setCvalue(complex[1]);
            }
            
            complex[0] = expr[0].getValue();
        }
        else if(iterations % 4 == 1) {
            if(parser[1].foundN()) {
                parser[1].setNvalue(new Complex(iterations, 0));
            }
            parser[1].setZvalue(complex[0]);

            if(parser[1].foundC()) {
                parser[1].setCvalue(complex[1]);
            }
            
            complex[0] = expr[1].getValue();
        }
        else if(iterations % 4 == 2) {
            if(parser[2].foundN()) {
                parser[2].setNvalue(new Complex(iterations, 0));
            }
            parser[2].setZvalue(complex[0]);

            if(parser[2].foundC()) {
                parser[2].setCvalue(complex[1]);
            }
            
            complex[0] = expr[2].getValue();
        }
        else  {
            if(parser[3].foundN()) {
                parser[3].setNvalue(new Complex(iterations, 0));
            }
            parser[3].setZvalue(complex[0]);

            if(parser[3].foundC()) {
                parser[3].setCvalue(complex[1]);
            }
            
            complex[0] = expr[3].getValue();
        }
    }
    
    @Override
    public double calculateFractalWithoutPeriodicity(Complex pixel) {
        
        iterations = 0;

        Complex tempz = new Complex(pertur_val.getPixel(init_val.getPixel(pixel)));
        
        Complex[] complex = new Complex[2];
        complex[0] = tempz;//z
        complex[1] = new Complex(pixel);//c
        
        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }

        for (; iterations < max_iterations; iterations++) {
                  
            if(bailout_algorithm.escaped(complex[0])) {
                Object[] object = {iterations, complex[0], zold};
                return out_color_algorithm.getResult(object);
            }
            zold.assign(complex[0]);
            function(complex);
            
            if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }
        
        }
  
        
        Object[] object = {max_iterations, complex[0]};
        return in_color_algorithm.getResult(object);
 

    }
    
    @Override
    public double[] calculateFractal3DWithPeriodicity(Complex pixel) {

        iterations = 0;

        check = 3;
        check_counter = 0;

        update = 10;
        update_counter = 0;

        period = new Complex();

        Complex tempz = new Complex(pertur_val.getPixel(init_val.getPixel(pixel)));
        
        Complex[] complex = new Complex[2];
        complex[0] = tempz;//z
        complex[1] = new Complex(pixel);//c

        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }
        
        double temp;

        for (; iterations < max_iterations; iterations++) {
            if(bailout_algorithm.escaped(complex[0])) {
                Object[] object = {iterations, complex[0], zold};
                temp = out_color_algorithm.getResult(object);
                double[] array = {40 * Math.log(temp - 100799) - 100, temp};
                return array;
            }
            zold.assign(complex[0]);
            function(complex);
            
           if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }


            if(periodicityCheck(complex[0])) {
                double[] array = {40 * Math.log(max_iterations + 1) - 100, max_iterations};
                return array;
            }

        }

        double[] array = {40 * Math.log(max_iterations + 1) - 100, max_iterations};
        return array;

    }
    
    @Override
    public double[] calculateFractal3DWithoutPeriodicity(Complex pixel) {
        
        iterations = 0;

        Complex tempz = new Complex(pertur_val.getPixel(init_val.getPixel(pixel)));
        
        Complex[] complex = new Complex[2];
        complex[0] = tempz;//z
        complex[1] = new Complex(pixel);//c
        

        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }
        
        double temp;

        for (; iterations < max_iterations; iterations++) {
                  
            if(bailout_algorithm.escaped(complex[0])) {
                Object[] object = {iterations, complex[0], zold};
                temp = out_color_algorithm.getResult(object);
                double[] array = {40 * Math.log(temp - 100799) - 100, temp};
                return array;
               
            }
            zold.assign(complex[0]);
            function(complex);
            
            if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }
        
        }
  
        
        Object[] object = {max_iterations, complex[0]};
        temp = in_color_algorithm.getResult(object);
        double result = temp == max_iterations ? max_iterations : max_iterations + temp - 100820;
        double[] array = {40 * Math.log(result + 1) - 100, temp};
        return array;

    }
    

  
    @Override
    public void calculateFractalOrbit() {
        iterations = 0;

        Complex[] complex = new Complex[2];
        complex[0] = new Complex(pertur_val.getPixel(init_val.getPixel(pixel_orbit)));//z
        complex[1] = new Complex(pixel_orbit);//c
        

        Complex temp = null;
        
        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }
        
        for (; iterations < max_iterations; iterations++) {
           zold.assign(complex[0]);
           function(complex);
           
           if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }
           
           temp = rotation.getPixel(complex[0], true);
           
           if(Double.isNaN(temp.getRe()) || Double.isNaN(temp.getIm()) || Double.isInfinite(temp.getRe()) || Double.isInfinite(temp.getIm())) {
               break;
           }
           
           complex_orbit.add(temp);
        }

    }
    
    @Override
    public double calculateJuliaWithPeriodicity(Complex pixel) {
      iterations = 0;

        check = 3;
        check_counter = 0;

        update = 10;
        update_counter = 0;

        period = new Complex();


        Complex[] complex = new Complex[2];
        complex[0] = pixel;//z
        complex[1] = new Complex(seed);//c

        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }

        for (; iterations < max_iterations; iterations++) {
            if(bailout_algorithm.escaped(complex[0])) {
                Object[] object = {iterations, complex[0], zold};
                return out_color_algorithm.getResult(object);
            }
            zold.assign(complex[0]);
            function(complex);
            
            if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }

            if(periodicityCheck(complex[0])) {
                return max_iterations;
            }
        }
        
        return max_iterations;
    }


    @Override
    public double calculateJuliaWithoutPeriodicity(Complex pixel) {
      iterations = 0;

        Complex[] complex = new Complex[2];
        complex[0] = pixel;//z
        complex[1] = new Complex(seed);//c

        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }

        for (; iterations < max_iterations; iterations++) {
            if(bailout_algorithm.escaped(complex[0])) {
                Object[] object = {iterations, complex[0], zold};
                return out_color_algorithm.getResult(object);
            }
            zold.assign(complex[0]);
            function(complex);
            
            if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }
  
        }

        Object[] object = {max_iterations, complex[0]};
        return in_color_algorithm.getResult(object);
        
    }
    
    @Override
    public double[] calculateJulia3DWithPeriodicity(Complex pixel) {
      iterations = 0;

        check = 3;
        check_counter = 0;

        update = 10;
        update_counter = 0;

        period = new Complex();


        Complex[] complex = new Complex[2];
        complex[0] = pixel;//z
        complex[1] = new Complex(seed);//c

        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }

        double temp;
        
        for (; iterations < max_iterations; iterations++) {
            if(bailout_algorithm.escaped(complex[0])) {
                Object[] object = {iterations, complex[0], zold};
                temp = out_color_algorithm.getResult(object);
                double[] array = {40 * Math.log(temp - 100799) - 100, temp};
                return array;
            }
            zold.assign(complex[0]);
            function(complex);
            
            if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }

            if(periodicityCheck(complex[0])) {
                double[] array = {40 * Math.log(max_iterations + 1) - 100, max_iterations};
                return array;
            }
        }
        
        double[] array = {40 * Math.log(max_iterations + 1) - 100, max_iterations};
        return array;
        
    }


    @Override
    public double[] calculateJulia3DWithoutPeriodicity(Complex pixel) {
      iterations = 0;

        Complex[] complex = new Complex[2];
        complex[0] = pixel;//z
        complex[1] = new Complex(seed);//c

        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }
        
        double temp;

        for (; iterations < max_iterations; iterations++) {
            if(bailout_algorithm.escaped(complex[0])) {
                Object[] object = {iterations, complex[0], zold};
                temp = out_color_algorithm.getResult(object);
                double[] array = {40 * Math.log(temp - 100799) - 100, temp};
                return array;
            }
            zold.assign(complex[0]);
            function(complex);
            
            if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }
  
        }

        Object[] object = {max_iterations, complex[0]};
        temp = in_color_algorithm.getResult(object);
        double result = temp == max_iterations ? max_iterations : max_iterations + temp - 100820;
        double[] array = {40 * Math.log(result + 1) - 100, temp};
        return array;
        
    }

    @Override
    public void calculateJuliaOrbit() {
      iterations = 0;

        Complex[] complex = new Complex[2];
        complex[0] = pixel_orbit;//z
        complex[1] = seed;//c

        Complex temp = null;
        
        Complex zold = new Complex();
        
        if(parser[0].foundP()) {
            parser[0].setPvalue(new Complex());
        }
        
        for (; iterations < max_iterations; iterations++) {
           zold.assign(complex[0]);
           function(complex);
           
            if(parser[0].foundP()) {
                parser[0].setPvalue(new Complex(zold));
            }
            
            if(parser[1].foundP()) {
                parser[1].setPvalue(new Complex(zold));
            }
            
            if(parser[2].foundP()) {
                parser[2].setPvalue(new Complex(zold));
            }
            
            if(parser[3].foundP()) {
                parser[3].setPvalue(new Complex(zold));
            }
           
           temp = rotation.getPixel(complex[0], true);
           
           if(Double.isNaN(temp.getRe()) || Double.isNaN(temp.getIm()) || Double.isInfinite(temp.getRe()) || Double.isInfinite(temp.getIm())) {
               break;
           }
           
           complex_orbit.add(temp);
        }

    }
    
}