import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
	
	public UserInterface() {
		newPoly();
	}
	
	// Create hash map
	Map<String, Polynomial> polyNameMap = new HashMap<String, Polynomial>();
	
	
	public void whatNext() {
		Scanner in = new Scanner(System.in);
		System.out.println("What would you like to do next?\n\t1) Store new polynomial\n\t2) Sort polynomial");
		System.out.println("\t3) Add two polynomials together (if only one polynomial is stored you can add to itself)");
		System.out.println("\t4) Multiply two polynomials together (if only one polynomial is stored you can square it)");
		System.out.println("\t5) View stored polynomials");
		System.out.println("\t6) Exit program");
		System.out.println("Enter 1, 2, 3, 4, 5, or 6: ");
		int choice = in.nextInt();
		
		// make new poly
		if (choice == 1) {newPoly();}
		
		// sort poly
		else if (choice == 2) {	
			System.out.println("Enter name of polynomial you would like to sort: ");
			String sortThisPoly = in.next();
			System.out.println(sortThisPoly + " not sorted: " + (((polyNameMap.get(sortThisPoly))).toString()));
			polyNameMap.get(sortThisPoly).sort();
			System.out.println(sortThisPoly + " sorted: " + (((polyNameMap.get(sortThisPoly))).toString()));
		}
		
		// add polys
		else if (choice == 3) {
			System.out.println("Enter first polynomial name: ");
			String addend1 = in.next();
			System.out.println("Enter second polynomial name: ");
			String addend2 = in.next();
			System.out.print(addend1 + " + " + addend2 + " = " );
			String sum = polyNameMap.get(addend1).add(polyNameMap.get(addend1), polyNameMap.get(addend2)).toString();
			System.out.println(sum + "\n");
			System.out.println("Would you like to store this polynomial?\nEnter y/n: ");
			String choice1 = in.next();
			if (choice1.equals("y")) {
				System.out.println("What would you like to name this polynomial?");
				String name1 = in.next();
				polyNameMap.put(name1, new Polynomial(sum));
			}
		}
		
		// multiply polys
		else if (choice == 4) {
			System.out.println("Enter first polynomial name: ");
			String factor1 = in.next();
			System.out.println("Enter second polynomial name: ");
			String factor2 = in.next();
			System.out.print(factor1 + " x " + factor2 + " = " );
			String product = polyNameMap.get(factor1).multiply(polyNameMap.get(factor2)).toString();
			System.out.println(product + "\n");
			System.out.println("Would you like to store this polynomial?\nEnter y/n: ");
			String choice1 = in.next();
			if (choice1.equals("y")) {
				System.out.println("What would you like to name this polynomial?");
				String name1 = in.next();
				polyNameMap.put(name1, new Polynomial(product));
			}
			
		// view polys
		}
		else if (choice == 5) {
			System.out.println("Currently stored polynomials: ");
			polyNameMap.forEach((k, v) -> System.out.println("\t" + k + ": " + v.toString()));
		}
		
		// exit
		else if (choice == 6) {System.out.println("Goodbye"); System.exit(0);}
		else {
			System.out.println(choice + "is not a valid input.");
			whatNext();
		}
	}
	
	public void newPoly() {
		Scanner in = new Scanner(System.in).useDelimiter("\\n");
		System.out.println("\nEnter name of polynomial you would like to store: ");
		String polyName = in.next();
		System.out.println("Enter polynomial following the format of this example: 5x10 + 9x7 - x - 10");
		System.out.println("Enter polynomial: ");
		String poly = in.next();
		polyNameMap.put(polyName, new Polynomial(poly));
		
	}
	
	
}
