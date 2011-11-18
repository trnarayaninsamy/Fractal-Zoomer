
import java.awt.Color;
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hrkalona
 */
public class SettingsJulia extends SettingsFractals implements Serializable {
  private double xJuliaCenter;
  private double yJuliaCenter;

    public SettingsJulia(double xCenter, double yCenter, double size, int max_iterations, int color_choice, Color fractal_color, int out_coloring_algorithm, double color_intensity, int function, int bailout, boolean inverse_plane, boolean burning_ship, double z_exponent, int color_cycling_location, double xJuliaCenter, double yJuliaCenter) {

        super(xCenter, yCenter, size, max_iterations, color_choice, fractal_color, out_coloring_algorithm, color_intensity, function, bailout, inverse_plane, burning_ship, z_exponent, color_cycling_location);
        this.xJuliaCenter = xJuliaCenter;
        this.yJuliaCenter = yJuliaCenter;

    }

    public double getXJuliaCenter() {

        return xJuliaCenter;

    }

    public double getYJuliaCenter() {

        return yJuliaCenter;

    }

}