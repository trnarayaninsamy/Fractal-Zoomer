package fractalzoomer.core;


import fractalzoomer.main.MainWindow;
import fractalzoomer.functions.barnsley.Barnsley1;
import fractalzoomer.functions.barnsley.Barnsley3;
import fractalzoomer.functions.barnsley.Barnsley2;
import fractalzoomer.functions.math.Cot;
import fractalzoomer.functions.math.Cosh;
import fractalzoomer.functions.math.Cos;
import fractalzoomer.functions.math.Coth;
import fractalzoomer.functions.math.Exp;
import fractalzoomer.functions.Fractal;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula10;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula11;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula12;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze_f_g.Formula13;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze_f_g.Formula15;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze_f_g.Formula16;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze_f_g.Formula17;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze_f_g.Formula18;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze_f_g.Formula14;
import fractalzoomer.functions.formulas.kaliset.Formula19;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula2;
import fractalzoomer.functions.formulas.kaliset.Formula20;
import fractalzoomer.functions.formulas.kaliset.Formula21;
import fractalzoomer.functions.formulas.kaliset.Formula22;
import fractalzoomer.functions.formulas.kaliset.Formula24;
import fractalzoomer.functions.formulas.kaliset.Formula25;
import fractalzoomer.functions.formulas.kaliset.Formula26;
import fractalzoomer.functions.formulas.kaliset.Formula23;
import fractalzoomer.functions.formulas.m_like_generalization.Formula1;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula27;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula3;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula4;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula5;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula6;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula7;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula8;
import fractalzoomer.functions.formulas.m_like_generalization.c_azb_dze.Formula9;
import fractalzoomer.functions.general.FrothyBasin;
import fractalzoomer.functions.halley.HalleySin;
import fractalzoomer.functions.halley.Halley4;
import fractalzoomer.functions.halley.HalleyPoly;
import fractalzoomer.functions.halley.HalleyGeneralized8;
import fractalzoomer.functions.householder.HouseholderGeneralized8;
import fractalzoomer.functions.halley.HalleyCos;
import fractalzoomer.functions.halley.HalleyGeneralized3;
import fractalzoomer.functions.halley.Halley3;
import fractalzoomer.functions.householder.Householder3;
import fractalzoomer.functions.householder.HouseholderSin;
import fractalzoomer.functions.householder.HouseholderCos;
import fractalzoomer.functions.householder.Householder4;
import fractalzoomer.functions.householder.HouseholderPoly;
import fractalzoomer.functions.householder.HouseholderGeneralized3;
import fractalzoomer.functions.general.Lambda;
import fractalzoomer.functions.math.Log;
import fractalzoomer.functions.magnet.Magnet1;
import fractalzoomer.functions.magnet.Magnet2;
import fractalzoomer.functions.mandelbrot.MandelbrotFifth;
import fractalzoomer.functions.mandelbrot.MandelbrotNth;
import fractalzoomer.functions.general.Manowar;
import fractalzoomer.functions.mandelbrot.MandelbrotSeventh;
import fractalzoomer.functions.mandelbrot.MandelbrotFourth;
import fractalzoomer.functions.mandelbrot.Mandelbar;
import fractalzoomer.functions.mandelbrot.MandelbrotNinth;
import fractalzoomer.functions.mandelbrot.MandelbrotPoly;
import fractalzoomer.functions.mandelbrot.MandelbrotEighth;
import fractalzoomer.functions.mandelbrot.MandelbrotSixth;
import fractalzoomer.functions.mandelbrot.Mandelbrot;
import fractalzoomer.functions.mandelbrot.MandelbrotTenth;
import fractalzoomer.functions.mandelbrot.MandelbrotCubed;
import fractalzoomer.functions.newton.NewtonCos;
import fractalzoomer.functions.newton.NewtonGeneralized3;
import fractalzoomer.functions.newton.Newton3;
import fractalzoomer.functions.newton.NewtonGeneralized8;
import fractalzoomer.functions.newton.NewtonPoly;
import fractalzoomer.functions.general.Phoenix;
import fractalzoomer.functions.newton.NewtonSin;
import fractalzoomer.functions.newton.Newton4;
import fractalzoomer.functions.general.Spider;
import fractalzoomer.functions.schroder.Schroder4;
import fractalzoomer.functions.schroder.SchroderGeneralized3;
import fractalzoomer.functions.schroder.SchroderSin;
import fractalzoomer.functions.schroder.Schroder3;
import fractalzoomer.functions.schroder.SchroderPoly;
import fractalzoomer.functions.schroder.SchroderCos;
import fractalzoomer.functions.schroder.SchroderGeneralized8;
import fractalzoomer.functions.general.SierpinskiGasket;
import fractalzoomer.functions.mandelbrot.MandelbrotWth;
import fractalzoomer.functions.math.Sinh;
import fractalzoomer.functions.math.Sin;
import fractalzoomer.functions.math.Tan;
import fractalzoomer.functions.math.Tanh;
import fractalzoomer.functions.szegedi_butterfly.SzegediButterfly1;
import fractalzoomer.functions.szegedi_butterfly.SzegediButterfly2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrkalona
 */
public class DrawOrbit extends Thread {
  protected Fractal pixel_orbit;
  protected BufferedImage image;
  protected ArrayList<Complex> complex_orbit;
  protected MainWindow ptr;
  protected boolean orbit_style;
  protected boolean julia;
  protected boolean grid;
  protected int image_size;
  protected Color orbit_color;

    public DrawOrbit(double xCenter, double yCenter, double size, int max_iterations, int pixel_x, int pixel_y, int image_size, BufferedImage image, MainWindow ptr, Color orbit_color, boolean orbit_style, int plane_type, boolean burning_ship, boolean grid, int function , double z_exponent, double[] z_exponent_complex, double[] rotation_vals, boolean perturbation, double[] perturbation_vals, boolean init_val, double[] initial_vals, double[] coefficients) {

        this.image_size = image_size;
        
        double xPixel = xCenter - size * 0.5 + size * pixel_x / image_size;
        double yPixel = yCenter - size * 0.5 + size * pixel_y / image_size;

        complex_orbit = new ArrayList<Complex>(max_iterations + 1);
        complex_orbit.add(new Complex(xPixel, yPixel));

        switch (function) {
            case 0:
                pixel_orbit = new Mandelbrot(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 1:
                pixel_orbit = new MandelbrotCubed(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 2:
                pixel_orbit = new MandelbrotFourth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 3:
                pixel_orbit = new MandelbrotFifth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 4:
                pixel_orbit = new MandelbrotSixth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 5:
                pixel_orbit = new MandelbrotSeventh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 6:
                pixel_orbit = new MandelbrotEighth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 7:
                pixel_orbit = new MandelbrotNinth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case 8:
                pixel_orbit = new MandelbrotTenth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship);
                break;
            case MainWindow.MANDELBROTNTH:
                pixel_orbit = new MandelbrotNth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship, z_exponent);
                break;
            case MainWindow.MANDELBROTWTH:
                pixel_orbit = new MandelbrotWth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship, z_exponent_complex);
                break;
            case MainWindow.MANDELPOLY:
                pixel_orbit = new MandelbrotPoly(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals, burning_ship, coefficients);
                break;
            case MainWindow.LAMBDA:
                pixel_orbit = new Lambda(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.MAGNET1:
                pixel_orbit = new Magnet1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.MAGNET2:
                pixel_orbit = new Magnet2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.NEWTON3:
                pixel_orbit = new Newton3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.NEWTON4:
                pixel_orbit = new Newton4(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.NEWTONGENERALIZED3:
                pixel_orbit = new NewtonGeneralized3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.NEWTONGENERALIZED8:
                pixel_orbit = new NewtonGeneralized8(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.NEWTONSIN:
                pixel_orbit = new NewtonSin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.NEWTONCOS:
                pixel_orbit = new NewtonCos(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.NEWTONPOLY:
                pixel_orbit = new NewtonPoly(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, coefficients);
                break;
            case MainWindow.BARNSLEY1:
                pixel_orbit = new Barnsley1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.BARNSLEY2:
                pixel_orbit = new Barnsley2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.BARNSLEY3:
                pixel_orbit = new Barnsley3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.MANDELBAR:
                pixel_orbit = new Mandelbar(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.SPIDER:
                pixel_orbit = new Spider(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.MANOWAR:
                pixel_orbit = new Manowar(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.PHOENIX:
                pixel_orbit = new Phoenix(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.SIERPINSKI_GASKET:
                pixel_orbit = new SierpinskiGasket(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HALLEY3:
                pixel_orbit = new Halley3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HALLEY4:
                pixel_orbit = new Halley4(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HALLEYGENERALIZED3:
                pixel_orbit = new HalleyGeneralized3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HALLEYGENERALIZED8:
                pixel_orbit = new HalleyGeneralized8(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HALLEYSIN:
                pixel_orbit = new HalleySin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HALLEYCOS:
                pixel_orbit = new HalleyCos(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HALLEYPOLY:
                pixel_orbit = new HalleyPoly(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, coefficients);
                break;
            case MainWindow.SCHRODER3:
                pixel_orbit = new Schroder3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.SCHRODER4:
                pixel_orbit = new Schroder4(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.SCHRODERGENERALIZED3:
                pixel_orbit = new SchroderGeneralized3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.SCHRODERGENERALIZED8:
                pixel_orbit = new SchroderGeneralized8(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.SCHRODERSIN:
                pixel_orbit = new SchroderSin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.SCHRODERCOS:
                pixel_orbit = new SchroderCos(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.SCHRODERPOLY:
                pixel_orbit = new SchroderPoly(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, coefficients);
                break;
            case MainWindow.HOUSEHOLDER3:
                pixel_orbit = new Householder3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HOUSEHOLDER4:
                pixel_orbit = new Householder4(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HOUSEHOLDERGENERALIZED3:
                pixel_orbit = new HouseholderGeneralized3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HOUSEHOLDERGENERALIZED8:
                pixel_orbit = new HouseholderGeneralized8(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HOUSEHOLDERSIN:
                pixel_orbit = new HouseholderSin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HOUSEHOLDERCOS:
                pixel_orbit = new HouseholderCos(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals);
                break;
            case MainWindow.HOUSEHOLDERPOLY:
                pixel_orbit = new HouseholderPoly(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, coefficients);
                break;
            case MainWindow.EXP:
                pixel_orbit = new Exp(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.LOG:
                pixel_orbit = new Log(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.SIN:
                pixel_orbit = new Sin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.COS:
                pixel_orbit = new Cos(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.TAN:
                pixel_orbit = new Tan(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.COT:
                pixel_orbit = new Cot(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.SINH:
                pixel_orbit = new Sinh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.COSH:
                pixel_orbit = new Cosh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.TANH:
                pixel_orbit = new Tanh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.COTH:
                pixel_orbit = new Coth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA1:
                pixel_orbit = new Formula1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA2:
                pixel_orbit = new Formula2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA3:
                pixel_orbit = new Formula3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA4:
                pixel_orbit = new Formula4(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA5:
                pixel_orbit = new Formula5(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA6:
                pixel_orbit = new Formula6(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA7:
                pixel_orbit = new Formula7(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA8:
                pixel_orbit = new Formula8(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA9:
                pixel_orbit = new Formula9(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA10:
                pixel_orbit = new Formula10(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA11:
                pixel_orbit = new Formula11(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA12:
                pixel_orbit = new Formula12(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA13:
                pixel_orbit = new Formula13(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA14:
                pixel_orbit = new Formula14(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA15:
                pixel_orbit = new Formula15(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA16:
                pixel_orbit = new Formula16(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA17:
                pixel_orbit = new Formula17(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA18:
                pixel_orbit = new Formula18(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA19:
                pixel_orbit = new Formula19(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA20:
                pixel_orbit = new Formula20(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA21:
                pixel_orbit = new Formula21(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA22:
                pixel_orbit = new Formula22(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA23:
                pixel_orbit = new Formula23(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA24:
                pixel_orbit = new Formula24(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA25:
                pixel_orbit = new Formula25(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA26:
                pixel_orbit = new Formula26(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FORMULA27:
                pixel_orbit = new Formula27(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.FROTHY_BASIN:
                pixel_orbit = new FrothyBasin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.SZEGEDI_BUTTERFLY1:
                pixel_orbit = new SzegediButterfly1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
            case MainWindow.SZEGEDI_BUTTERFLY2:
                pixel_orbit = new SzegediButterfly2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, perturbation, perturbation_vals, init_val, initial_vals);
                break;
                        
        }


        this.image = image;
        this.ptr = ptr;
        this.orbit_style = orbit_style;
        this.orbit_color = orbit_color;
        this.grid = grid;
        julia = false;

    }

    public DrawOrbit(double xCenter, double yCenter, double size, int max_iterations, int pixel_x, int pixel_y, int image_size, BufferedImage image, MainWindow ptr, Color orbit_color, boolean orbit_style, int plane_type, boolean burning_ship, boolean grid, int function , double z_exponent, double[] z_exponent_complex, double[] rotation_vals, double[] coefficients, double xJuliaCenter, double yJuliaCenter) {

        this.image_size = image_size;
        
        double xPixel = xCenter - size * 0.5 + size * pixel_x / image_size;
        double yPixel = yCenter - size * 0.5 + size * pixel_y / image_size;

        complex_orbit = new ArrayList<Complex>(max_iterations + 1);
        complex_orbit.add(new Complex(xPixel, yPixel));

        switch (function) {
            case 0:
                pixel_orbit = new Mandelbrot(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 1:
                pixel_orbit = new MandelbrotCubed(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 2:
                pixel_orbit = new MandelbrotFourth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 3:
                pixel_orbit = new MandelbrotFifth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 4:
                pixel_orbit = new MandelbrotSixth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 5:
                pixel_orbit = new MandelbrotSeventh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 6:
                pixel_orbit = new MandelbrotEighth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 7:
                pixel_orbit = new MandelbrotNinth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case 8:
                pixel_orbit = new MandelbrotTenth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.MANDELBROTNTH:
                pixel_orbit = new MandelbrotNth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, z_exponent, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.MANDELBROTWTH:
                pixel_orbit = new MandelbrotWth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, z_exponent_complex, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.MANDELPOLY:
                pixel_orbit = new MandelbrotPoly(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, burning_ship, coefficients, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.LAMBDA:
                pixel_orbit = new Lambda(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.MAGNET1:
                pixel_orbit = new Magnet1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.MAGNET2:
                pixel_orbit = new Magnet2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;           
            case MainWindow.BARNSLEY1:
                pixel_orbit = new Barnsley1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.BARNSLEY2:
                pixel_orbit = new Barnsley2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.BARNSLEY3:
                pixel_orbit = new Barnsley3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.MANDELBAR:
                pixel_orbit = new Mandelbar(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.SPIDER:
                pixel_orbit = new Spider(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.MANOWAR:
                pixel_orbit = new Manowar(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.PHOENIX:
                pixel_orbit = new Phoenix(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.EXP:
                pixel_orbit = new Exp(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.LOG:
                pixel_orbit = new Log(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.SIN:
                pixel_orbit = new Sin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.COS:
                pixel_orbit = new Cos(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.TAN:
                pixel_orbit = new Tan(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.COT:
                pixel_orbit = new Cot(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.SINH:
                pixel_orbit = new Sinh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.COSH:
                pixel_orbit = new Cosh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.TANH:
                pixel_orbit = new Tanh(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.COTH:
                pixel_orbit = new Coth(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA1:
                pixel_orbit = new Formula1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA2:
                pixel_orbit = new Formula2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA3:
                pixel_orbit = new Formula3(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA4:
                pixel_orbit = new Formula4(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA5:
                pixel_orbit = new Formula5(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA6:
                pixel_orbit = new Formula6(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA7:
                pixel_orbit = new Formula7(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA8:
                pixel_orbit = new Formula8(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA9:
                pixel_orbit = new Formula9(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA10:
                pixel_orbit = new Formula10(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA11:
                pixel_orbit = new Formula11(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA12:
                pixel_orbit = new Formula12(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA13:
                pixel_orbit = new Formula13(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA14:
                pixel_orbit = new Formula14(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA15:
                pixel_orbit = new Formula15(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA16:
                pixel_orbit = new Formula16(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA17:
                pixel_orbit = new Formula17(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA18:
                pixel_orbit = new Formula18(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA19:
                pixel_orbit = new Formula19(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA20:
                pixel_orbit = new Formula20(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA21:
                pixel_orbit = new Formula21(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA22:
                pixel_orbit = new Formula22(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA23:
                pixel_orbit = new Formula23(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA24:
                pixel_orbit = new Formula24(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA25:
                pixel_orbit = new Formula25(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA26:
                pixel_orbit = new Formula26(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FORMULA27:
                pixel_orbit = new Formula27(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.FROTHY_BASIN:
                pixel_orbit = new FrothyBasin(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.SZEGEDI_BUTTERFLY1:
                pixel_orbit = new SzegediButterfly1(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
            case MainWindow.SZEGEDI_BUTTERFLY2:
                pixel_orbit = new SzegediButterfly2(xCenter, yCenter, size, max_iterations, complex_orbit, plane_type, rotation_vals, xJuliaCenter, yJuliaCenter);
                break;
                
        }


        this.image = image;
        this.ptr = ptr;
        this.orbit_style = orbit_style;
        this.orbit_color = orbit_color;
        this.grid = grid;
        julia = true;

    }

    @Override
    public void run() {
        draw();
    }

    protected void draw() {

        if(grid) {
            ptr.drawGrid(image.createGraphics());
        }

        if(julia) {
            if(orbit_style) {
                drawJuliaLine();
            }
            else {
                drawJuliaDot();
            }
        }
        else {
            if(orbit_style) {
                drawFractalLine();
            }
            else {
                drawFractalDot();
            }
        }

        ((Graphics2D)ptr.getMainPanel().getGraphics()).drawImage(image, 0, 0, ptr);
              
    }

    private void drawFractalLine() {
      int x0, y0, x1 = 0, y1 = 0, list_size;

        Graphics2D full_image_g = image.createGraphics();

        pixel_orbit.calculateFractalOrbit();

        full_image_g.setColor(orbit_color);

        full_image_g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        list_size = complex_orbit.size() - 1;

        double size = pixel_orbit.getSize();

        double temp_xcenter_size = pixel_orbit.getXCenter() - size * 0.5;
        double temp_ycenter_size = pixel_orbit.getYCenter() - size * 0.5;
        double temp_size_image_size = size / image_size;

        for(int i = 0; i < list_size; i++) {
            x0 = (int)((complex_orbit.get(i).getRe() - temp_xcenter_size) / temp_size_image_size);
            y0 = (int)((complex_orbit.get(i).getIm() - temp_ycenter_size) / temp_size_image_size);
            x1 = (int)((complex_orbit.get(i + 1).getRe() - temp_xcenter_size) / temp_size_image_size);
            y1 = (int)((complex_orbit.get(i + 1).getIm() - temp_ycenter_size) / temp_size_image_size);
            if(Math.abs(x0) == 2147483647 || Math.abs(y0) == 2147483647) {
                break;
            }
            full_image_g.drawLine(x0, y0, x1, y1);
            full_image_g.fillOval(x0, y0, 3, 3);
        }
        
        full_image_g.fillOval(x1, y1, 3, 3);

    }

    private void drawJuliaLine() {
      int x0, y0, x1 = 0, y1 = 0, list_size;

        Graphics2D full_image_g = image.createGraphics();

        pixel_orbit.calculateJuliaOrbit();

        full_image_g.setColor(orbit_color);

        full_image_g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        list_size = complex_orbit.size() - 1;

        double size = pixel_orbit.getSize();

        double temp_xcenter_size = pixel_orbit.getXCenter() - size * 0.5;
        double temp_ycenter_size = pixel_orbit.getYCenter() - size * 0.5;
        double temp_size_image_size = size / image_size;

        for(int i = 0; i < list_size; i++) {
            x0 = (int)((complex_orbit.get(i).getRe() - temp_xcenter_size) / temp_size_image_size);
            y0 = (int)((complex_orbit.get(i).getIm() - temp_ycenter_size) / temp_size_image_size);
            x1 = (int)((complex_orbit.get(i + 1).getRe() - temp_xcenter_size) / temp_size_image_size);
            y1 = (int)((complex_orbit.get(i + 1).getIm() - temp_ycenter_size) / temp_size_image_size);
            if(Math.abs(x0) == 2147483647 || Math.abs(y0) == 2147483647) {
                break;
            }
            full_image_g.drawLine(x0, y0, x1, y1);
            full_image_g.fillOval(x0, y0, 3, 3);
        }
        
        full_image_g.fillOval(x1, y1, 3, 3);        

    }

    private void drawFractalDot() {
      int x0, y0, list_size;

        Graphics2D full_image_g = image.createGraphics();

        pixel_orbit.calculateFractalOrbit();

        full_image_g.setColor(orbit_color);

        full_image_g.setFont(new Font("Arial", 1 , 11));
        list_size = complex_orbit.size();

        double size = pixel_orbit.getSize();

        double temp_xcenter_size = pixel_orbit.getXCenter() - size * 0.5;
        double temp_ycenter_size = pixel_orbit.getYCenter() - size * 0.5;
        double temp_size_image_size = size / image_size;

        for(int i = 0; i < list_size; i++) {
            x0 = (int)((complex_orbit.get(i).getRe() - temp_xcenter_size) / temp_size_image_size);
            y0 = (int)((complex_orbit.get(i).getIm() - temp_ycenter_size) / temp_size_image_size);
            if(Math.abs(x0) == 2147483647 || Math.abs(y0) == 2147483647) {
                break;
            }
            full_image_g.drawString(".", x0 - 1, y0 + 1);
        }

    }

    private void drawJuliaDot() {
      int x0, y0, list_size;

        Graphics2D full_image_g = image.createGraphics();

        pixel_orbit.calculateJuliaOrbit();

        full_image_g.setColor(orbit_color);

        full_image_g.setFont(new Font("Arial", 1 , 11));
        list_size = complex_orbit.size();

        double size = pixel_orbit.getSize();

        double temp_xcenter_size = pixel_orbit.getXCenter() - size * 0.5;
        double temp_ycenter_size = pixel_orbit.getYCenter() - size * 0.5;
        double temp_size_image_size = size / image_size;

        for(int i = 0; i < list_size; i++) {
            x0 = (int)((complex_orbit.get(i).getRe() - temp_xcenter_size) / temp_size_image_size);
            y0 = (int)((complex_orbit.get(i).getIm() - temp_ycenter_size) / temp_size_image_size);
            if(Math.abs(x0) == 2147483647 || Math.abs(y0) == 2147483647) {
                break;
            }
            full_image_g.drawString(".", x0 - 1, y0 + 1);
        }

    }

}
