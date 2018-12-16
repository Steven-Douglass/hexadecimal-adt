
public class InvalidHexadecimal extends NumberFormatException {
	private static final long serialVersionUID = 1748843846605881576L;

	public InvalidHexadecimal(String hexValue) {
		super();
		System.out.println(hexValue + " is not a valid hexadecimal number.");
	}
}