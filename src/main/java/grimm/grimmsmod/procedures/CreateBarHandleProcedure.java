package grimm.grimmsmod.procedures;

public class CreateBarHandleProcedure {
	public static String execute(double fill, double max, double mlen) {
		String tmp = "";
		double filled = 0;
		filled = (fill * mlen) / max;
		for (int index0 = 0; index0 < (int) mlen; index0++) {
			if (filled > 0) {
				filled = filled - 1;
				tmp = tmp + "#";
			} else {
				tmp = tmp + " ";
			}
		}
		return "[" + tmp + "]";
	}
}
