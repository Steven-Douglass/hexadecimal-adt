
public class Driver {
	public static void main(String[] args) throws InvalidHexadecimal {
		// Testing Constructors
		System.out.println("Testing Constructors");
		HexNumber Hex1 = new HexNumber(-60);
		HexNumber Hex2 = new HexNumber("-3C");
		System.out.println("Hex1 hexadecimal value: " + Hex1.getHexValue());
		System.out.println("Hex2 decimal value: " + Hex2.getDecimalValue());

		// Testing Conversion Methods
		System.out.println("\r\nTesting Conversion Methods");
		System.out.println("Decimal value of ABC: " + HexNumber.decimalValue("ABC"));
		System.out.println("String value of 2748: " + HexNumber.hexValue(2748));

		// Testing Algorithmic Methods
		System.out.println("\r\nTesting Algorithmic Methods");
		HexNumber Hex3 = new HexNumber(-5);
		System.out.println("Hex1 decimal value: " + Hex1.getDecimalValue());
		System.out.println("Hex3 decimal value: " + Hex3.getDecimalValue());
		System.out.println("Hex1 * Hex3: " + Hex1.multiply(Hex3).getDecimalValue());
		System.out.println("Hex1 / Hex3: " + Hex1.divide(Hex3).getDecimalValue());
		System.out.println("Hex1 + Hex3: " + Hex1.add(Hex3).getDecimalValue());
		System.out.println("Hex1 - Hex3: " + Hex1.subtract(Hex3).getDecimalValue());

		// Calculating (A + (40 / 4) - 14) * 2
		System.out.println("\r\nCalculating (A + (40 / 4) - 14) * 2");
		System.out.println("The answer is: " + new HexNumber(10).add(new HexNumber(40).divide(new HexNumber(4)))
				.subtract(new HexNumber(14)).multiply(new HexNumber(2)));

		// Testing isHex()
		System.out.println("\r\nTesting isHex()");
		System.out.println("HexNumber.isHex(\"1234567890ABCDEF\"): " + HexNumber.isHex("1234567890ABCDEF"));
		System.out.println("HexNumber.isHex(\"-1234567890ABCDEF\"): " + HexNumber.isHex("-1234567890ABCDEF"));
		System.out.println("HexNumber.isHex(\"1-234567890ABCDEF\"): " + HexNumber.isHex("1-234567890ABCDEF"));
		System.out.println("HexNumber.isHex(\"1234567890ABCDEF-\"): " + HexNumber.isHex("1234567890ABCDEF-"));
		System.out.println("HexNumber.isHex(\"1234567890ABCDEFG\"): " + HexNumber.isHex("1234567890ABCDEFG"));
		
		// Testing toString()
		System.out.println("\r\n" + "Testing toString()");
		System.out.println("Hex1.toString(): " + Hex1.toString());
		System.out.println("Hex2.toString(): " + Hex2.toString());
		System.out.println("Hex3.toString(): " + Hex3.toString());
	}
}
