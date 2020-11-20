import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

public class Polynomial {
	LinkedList<Term> termList = new LinkedList<Term>();
	ListIterator<Term> iter = termList.listIterator();
	
	public Polynomial() {}
	public Polynomial(Term t) {
		termList.add(t);
	}
	public Polynomial(String s) {
		// splits term along whitespace
		System.out.println(s);
		String[] splitted = s.split(" ");
		System.out.println("splitted length: " + splitted.length);
		for (int i = 0; i < splitted.length; i++) {
			// makes sure coefficient is negative if minus sign is in front
			if (splitted[i].equals("-")) {
				termList.add(new Term("-" + splitted[i + 1]));
				i++;
			}
			// skips + elements
			else if (splitted[i].equals("+")) {
				
			}
			// adds positive elements
			else {
				termList.add(new Term(splitted[i]));
			}
		}
	}
	
	public Polynomial add(Polynomial p1, Polynomial p2) {
		// adds polynomial to end and then sorts by descending degree
		for (Term t : p1.termList) {
			p2.termList.add(t);
		}
		p2.sort();
		ArrayList<Term> arr = new ArrayList<Term>();
		for (Term t: p2.termList) {
			arr.add(t);
		}
		// combines like-terms by setting current index to combined result and removes next element
		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i).getPowerOfX() == arr.get(i + 1).getPowerOfX()) {
				int coe = arr.get(i).getCoefficient() + arr.get(i + 1).getCoefficient();
				arr.set(i, new Term(coe, arr.get(i).getPowerOfX()));
				arr.remove(i + 1);
			}
		}
		
		// convert back to linkedList
		Polynomial result = new Polynomial();
		for (Term t: arr) {
			result.termList.add(t);
		}
		return result;
		
	}// end add method
	
	public Polynomial multiply(Polynomial p) {
	    // initialize new empty polynomial
		Polynomial r = new Polynomial();
		// multiply each possible pair of terms from each list and add to new Polynomial
		for (Term t: termList) {
			int tCoe = t.getCoefficient();
			int tPow = t.getPowerOfX();
			for (Term q: p.termList) {
				int qCoe = q.getCoefficient();
				int qPow = q.getPowerOfX();
				int coe = tCoe * qCoe;
				int pow = tPow + qPow;
				r.add(r, new Polynomial(new Term(coe, pow)));
			}
		}
		r.sort();
		// combine like-terms
		//convert to arrayList(can't iterate and modify with LinkedList)
		ArrayList<Term> arr = new ArrayList<Term>();
		for (Term t: r.termList) {
			arr.add(t);
		}
		// combines like-terms by setting current index to combined result and removes next element
		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i).getPowerOfX() == arr.get(i + 1).getPowerOfX()) {
				int coe = arr.get(i).getCoefficient() + arr.get(i + 1).getCoefficient();
				arr.set(i, new Term(coe, arr.get(i).getPowerOfX()));
				arr.remove(i + 1);
			}
		}
		
		// convert back to linkedList
		Polynomial result = new Polynomial();
		for (Term t: arr) {
			result.termList.add(t);
		}
		return result;
	}// end multiply method
	
	public String toString() {
		// index for element of list
		int i = 1;
		String s = "";
		for (Term t : termList) {
			// Don't print anything for terms that equate to 0
			if (t.getCoefficient() == 0)
			{
				
			}
			// Formatting for the first term with coefficient not equal to 0
			else if ((t.getCoefficient() < 0 && i == 1) || (t.getCoefficient() > 0 && i == 1)) {
				if (t.getCoefficient() == -1 && t.getPowerOfX() == 1) {
					s = s + "-x";
					i++;
				}
				else if (t.getCoefficient() == -1 && t.getPowerOfX() != 1) {
					s = s + "-x" + t.getPowerOfX();
					i++;
				}
				else if (t.getPowerOfX() == 1) {
					s = s + t.getCoefficient() + "x";
					i++;
				}
				// Don't print x if power is 0
				else if (t.getPowerOfX() == 0) {
					s = s + t.getCoefficient();
					i++;
				}
				// Don't print coefficient of 1
				else if (t.getCoefficient() == 1) {
					s = s + "x" + t.getPowerOfX();
					i++;
				}
				// Just print x for coefficient and power of 1
				else if (t.getCoefficient() == 1 && t.getPowerOfX() == 1) {
					s = s + "x";
				}
				else {
					s = s + t.getCoefficient() + "x" + t.getPowerOfX();
					i++;
				}
			}
			// Formatting for all terms after first
				// Formatting for negative terms
			else if (t.getCoefficient() < 0) {
				// don't print power of one and coefficient of 1
				if (t.getPowerOfX() == 1 && t.getCoefficient() == -1) {
					s = s + " - x";
					i++;
				}
				// don't print power of 1
				else if (t.getPowerOfX() == 1) {
					s = s + " - " + (-1 * t.getCoefficient()) + "x";
					i++;
				}
				else if (t.getPowerOfX() == 0) {
					s = s + " - " + (-1 * t.getCoefficient());
					i++;
				}
				// Don't print coefficient of 1
				else if (t.getCoefficient() == -1) {
					s = s + " - " + "x" + t.getPowerOfX();
					i++;
				}
				// Just print x for coefficient and power of 1
				else if (t.getCoefficient() == 1 && t.getPowerOfX() == 1) {
					s = s + " - " + "x";
				}
				else {
					s = s + " - " + (-1 * t.getCoefficient()) + "x" + t.getPowerOfX();
					i++;
				}
			}
			// formatting for positive terms
			else {
				if (t.getPowerOfX() == 1) {
					s = s + " + " + t.getCoefficient() + "x";
					i++;
				}
				else if (t.getPowerOfX() == 0) {
					s = s + " + " + t.getCoefficient();
					i++;
				}
				// Don't print coefficient of 1
				else if (t.getCoefficient() == 1) {
					s = s + " + " + "x" + t.getPowerOfX();
					i++;
				}
				// Just print x for coefficient and power of 1
				else if (t.getCoefficient() == 1 && t.getPowerOfX() == 1) {
					s = s + " + " + "x";
				}
				else {
					s = s + " + " + t.getCoefficient() + "x" + t.getPowerOfX();
					i++;
				}
			}
		}
		return s;
	} // end toString method 
	
	// sorts terms from highest to lowest
	public void sort() {
		Collections.sort(termList);
	}
	
} // end Class Polynomial

