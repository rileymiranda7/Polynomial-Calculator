import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

public class PolyCalcMain {

	public static void main(String[] args) {
		/*
		 * 
		 * @author Riley Miranda
		 * 
		 * Description:
		 *   Program stores, sorts by descending degree, adds, multiplies, and converts polynomials from Strings and back.
		 *
		 */
        
		// Intro
		System.out.println("Welcome to a program for working with polynomials.");
		System.out.println("So far you can sort polynomials by descending degree of terms and mulitply or add polynomials together.");
		System.out.println("Subtract and divide functionality coming soon :)");
		
		Scanner in = new Scanner(System.in);
		
		// Create UserInterface object
		UserInterface ui = new UserInterface();
		
					
		boolean stillUsing = true;
		while (stillUsing) {
			
			// User picks what to do now
			ui.whatNext();
			
			
		}
		
	
		//Polynomial p = new Polynomial(new Term(-1, 1));
		//p.add(new Polynomial(new Term(-10, 0)));
		//p.add(new Polynomial(new Term(9, 7)));
		//p.add(new Polynomial(new Term(5, 10)));
		//System.out.println("As inputed: " + p.toString());
		//p.sort();
		//System.out.println("When sorted: " + p.toString());
		//Polynomial r = p.multiply(p);
		//System.out.println("p(x) x p(x): " + r.toString());
		
		Polynomial c = new Polynomial("5x10 + 9x7 - x - 10");
		c = c.multiply(c);
		System.out.println("Inputted as String and multiplied: " + c.toString());
		
		Polynomial d = new Polynomial("x2 + 10");
		System.out.println(d.toString());
	}
	
	
	
	
	
	

}
