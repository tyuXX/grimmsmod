package grimm.grimmsmod.procedures;

public class CoordsTextValueProcedure {
	public static String execute(double x, double y, double z) {
		return "X: " + new java.text.DecimalFormat("##.##").format(x) + " Y: " + new java.text.DecimalFormat("##.##").format(y) + " Z: " + new java.text.DecimalFormat("##.##").format(z);
	}
}
