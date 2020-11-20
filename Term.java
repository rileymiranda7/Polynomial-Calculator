
public class Term implements Comparable<Term> {
	
	private int coefficient;
	private int powerOfX;
	
	public Term(int coefficient, int powerOfX) {
		this.coefficient = coefficient;
		this.powerOfX = powerOfX;
	}
	
	public Term(String s) {
		// splits along x
		String[] splitted = s.split("x");
		System.out.println("s: " + s);
		if (s.equals("-x")) {
			coefficient = -1;
			powerOfX = 1;
		}
		else if (s.equals("x")) {
			coefficient = 1;
			powerOfX = 1;
		}
		// if term has no coefficient but does have an exponent
		else if (s.substring(0, 1).equals("x") && s.length() > 1) {
			coefficient = 1;
			powerOfX = Integer.parseInt(s.substring(1));
		}
		// if string doesn't contain x it is just a constant with power of 0
		else if (!s.contains("x")) {
			coefficient = Integer.parseInt(s);
			powerOfX = 0;
		}
		// for terms starting with "-x"
		else if (s.substring(0, 2).equals("-x")) {
			coefficient = -1;
			powerOfX = Integer.parseInt(splitted[1]);
		}
		// makes negative terms have negative coefficient
		else if (splitted[0].substring(0, 1).equals("-")) {
			coefficient = Integer.parseInt(splitted[0].substring(1));
			coefficient = coefficient * -1;
			powerOfX = Integer.parseInt(splitted[1]);
		}
		else {
			coefficient = Integer.parseInt(splitted[0]);
			powerOfX = Integer.parseInt(splitted[1]);
		}
	}
	
	public int getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(int c) {
		coefficient = c;
	}
	
	public int getPowerOfX() {
		return powerOfX;
	}
	
	public void setPowerOfX(int p) {
		powerOfX = p;
	}
	
	public boolean powersEqual(Term t) {
		if (powerOfX == t.powerOfX) {
			return true;
		}
		else {
			return false;
		}
	}
	// For a.compareTo(b):
	// returns - if a < b, 0 for a == b, and + if a > b
	public int compareTo(Term t) {
		// a's power is larger
		if (powerOfX > t.getPowerOfX()) {return -1;}
		// equal powers
		else if (powerOfX == t.getPowerOfX()) {
			// a's coefficient is larger
			if (coefficient > t.getCoefficient()) {return -1;}
			// b's coefficient is larger
			else if (coefficient < t.getCoefficient()) {return 1;}
			// coefficients are equal
			else {return 0;}
		}
		// b's power is larger
		else {return 1;}
	}
	
} // end Class Term
