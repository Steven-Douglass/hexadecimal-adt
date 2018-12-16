// This program implements a hexadecimal abstract data type. Class instances
// are immutable once instantiated. Mathematical operations are included
// to add, subtract, multiply, and divide hexadecimal numbers.
// Written by Steven Douglass

public class HexNumber {
	private String hexValue;
	private Long decimalValue;

	// Constructor from a decimal value
	public HexNumber(long decimalValue) {
		this.decimalValue = decimalValue;
		this.hexValue = hexValue(decimalValue);
	}

	// Constructor from a string hexadecimal value
	public HexNumber(String hexValue) throws InvalidHexadecimal {
		// If the string is not a valid hexadecimal value, throw an InvalidHexadecimal
		// exception
		if (!HexNumber.isHex(hexValue)) {
			throw new InvalidHexadecimal(hexValue);
		} else {
			this.hexValue = hexValue;
			this.decimalValue = decimalValue(hexValue);
		}
	}

	// Add two HexNumber instances
	public HexNumber add(HexNumber hex) {
		HexNumber newHexNumber = new HexNumber(this.getDecimalValue() + hex.getDecimalValue());
		return newHexNumber;
	}

	// Convert from a string hexadecimal to a decimal long
	public static long decimalValue(String hexValue) {
		boolean positive = true;
		Long decimalValue = (long) 0;
		char[] charArray = hexValue.toCharArray();
		if (charArray[0] == '-') {
			positive = false;
		}
		int exponent = charArray.length - 1;

		for (int i = 0; i < charArray.length; i++) {
			// Use ASCII values to check if the character is a digit from 0-9
			if (((int) charArray[i] >= 48) && ((int) charArray[i] <= 57)) {
				decimalValue += (long) (((int) charArray[i] - 48) * Math.pow(16, exponent));
				// Use ASCII values to check if the character is a letter from A-F
			} else if (Character.toUpperCase(charArray[i]) >= 65 && (Character.toUpperCase(charArray[i]) <= 70)) {
				decimalValue += (long) (((int) Character.toUpperCase(charArray[i]) - 55) * Math.pow(16, exponent));
			}
			exponent--;
		}
		if (!positive) {
			decimalValue *= -1;
		}
		return decimalValue;
	}

	// Divide two HexNumber instances
	public HexNumber divide(HexNumber hex) {
		HexNumber newHexNumber = new HexNumber(this.getDecimalValue() / hex.getDecimalValue());
		return newHexNumber;
	}

	// Return the decimal value
	public long getDecimalValue() {
		return this.decimalValue;
	}

	// Return the hexadecimal value
	public String getHexValue() {
		return this.hexValue;
	}

	// Convert a decimal value to a hexadecimal string value
	public static String hexValue(long decimalValue) {
		// Check for negative numbers
		boolean positive = true;
		if (decimalValue < 0) {
			positive = false;
		}
		// If we have a negative number, convert it to
		// a positive number for easier calculations
		if (!positive) {
			decimalValue = Math.abs(decimalValue);
		}
		long result = decimalValue / 16;
		long remainder = decimalValue % 16;
		String hexValue = "";
		// Break down our number by 16 repeatedly until it is less than 16
		while (result != 0) {
			if (remainder <= 9) {
				// Push a digit 0-9 to the front of the string
				hexValue = Character.toString((char) (remainder + 48)) + hexValue;
			} else {
				// Push a letter A-F to the front of the string
				hexValue = Character.toString((char) (remainder + 55)) + hexValue;
			}
			remainder = result % 16;
			result = result / 16;
		}
		// Push the last digit or letter to the front of the string
		if (remainder <= 9) {
			hexValue = Character.toString((char) (remainder + 48)) + hexValue;
		} else {
			hexValue = Character.toString((char) (remainder + 55)) + hexValue;
		}
		// If the number is negative, add a negative sign to the front
		if (!positive) {
			hexValue = "-" + hexValue;
		}
		// Return the hexadecimal string
		return hexValue;
	}

	// Test if a string is a valid hexadecimal number
	public static boolean isHex(String potentialHexString) {
		// Convert the string to an array of characters
		char[] charArray = potentialHexString.toCharArray();
		int valueASCII;
		int index = 0;
		// Check for negatives
		if (charArray[0] == '-') {
			index++;
		}
		// Iterate through the array of characters
		for (int i = index; i < charArray.length; i++) {
			valueASCII = Character.toUpperCase(charArray[i]);
			// If the character is not a valid ASCII value, return false
			if ((valueASCII < 47 || valueASCII > 57) && (valueASCII < 64 || valueASCII > 70)) {
				return false;
			}
		}
		// If all of the characters are valid, return true
		return true;
	}

	// Multiply two HexNumber instances
	public HexNumber multiply(HexNumber hex) {
		HexNumber newHexNumber = new HexNumber(this.getDecimalValue() * hex.getDecimalValue());
		return newHexNumber;
	}

	// Subtract two HexNumber instances
	public HexNumber subtract(HexNumber hex) {
		HexNumber newHexNumber = new HexNumber(this.getDecimalValue() - hex.getDecimalValue());
		return newHexNumber;
	}

	// Override the toString() method to return the hexadecimal value
	public String toString() {
		return this.getHexValue();
	}
}
