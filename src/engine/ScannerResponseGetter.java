package engine;

import java.util.Scanner;
/**
 * a class i wrote to get typed responses from the user by way of a Scanner.
 * this is the third time i've reused it and i feel pretty good about that.
 * 
 * @author alexislow
 */
public class ScannerResponseGetter {
	
	Scanner kb = new Scanner(System.in); // the Scanner which is used in all but one
	                                     // of these methods
	
	/**
	 * prompts a user to input an integer within a specified range.
	 * checks that user input is valid; reprompts user if it is not, 
	 * until the user enters a valid integer.
	 * 
	 * @param prompt           the string prompting a user selection
	 * @param lowestVal        the lowest value that can be selected
	 * @param highestVal       the highest value that can be selected
	 * @param displayRange     indicates whether to display the range of choices
	 *                         in the format "between lowestVal and highestVal:"
	 *                         
	 * @return                 the integer the user input that is within the 
	 *                         specified range
	 */
	public int intRequest(String prompt, int lowestVal, int highestVal, boolean displayRange) {
		int response;
		
		while (true) {
			System.out.print(prompt);
			if (displayRange) {
				System.out.print("between " + lowestVal + " and " + highestVal + ": ");
			}
			else {
				System.out.println(": ");
			}
			try {
				response = Integer.parseInt(kb.nextLine());
				if (response >= lowestVal && response <= highestVal) {
					break;
				}
				throw new Exception();
			} catch (Exception e) {
				System.out.println("\n   Invalid input. Please try again.");
			} 
		}
		return response;
	}
	
	/**
	 * prompts a user to input a double within a specified range.
     * checks that user input is valid; reprompts user if it is not, 
     * until the user enters a valid double.
     * 
     * @param prompt           the string prompting a user selection
     * @param lowestVal        the lowest value that can be selected
     * @param highestVal       the highest value that can be selected
     * @param displayRange     indicates whether to display the range of choices
     *                         in the format "between lowestVal and highestVal:"
     *                         
     * @return                 the double the user input that is within the 
     *                         specified range
	 */
	public double doubleRequest(String prompt, double lowestVal, double highestVal, boolean displayRange) {
		
		double response;
		
		while (true) {
			System.out.print(prompt);
			if (displayRange) {
				System.out.print("between " + lowestVal + " and " + highestVal + ": ");
			}
			else {
				System.out.println(": ");
			}
			
			try {
				response = Double.parseDouble(kb.nextLine());
				if (response >= lowestVal && response <= highestVal) {
					break;
				}
				throw new Exception();
			} catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
			}
		}
		return response;
	}
	
	/**
	 * prompts a user to enter "yes/y" or "no/n", disregarding case.
	 * converts this answer into a boolean value.
	 * reprompts user if invalid input is provided, until the user
	 * provides a valid response.
	 * 
	 * @param prompt   the String prompting user entry
	 * 
	 * @return         the boolean value parsed from the response.
	 */
	public boolean requestConfirmation(String prompt) {
		
		boolean answer;
		
		while (true) {
			
			System.out.print("\n" + prompt);
			
			String response = kb.nextLine();
			
			if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
				
				answer = true;
				break;
				
			}
			else if (response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no")) {
				
				answer = false;
				break;
				
			}
			else {
				
				System.out.println("Invalid input. Please try again.");
				
			}
		}
		
		return answer;
		
	}
	
	/**
	 * prompts a user to enter a String.
	 * this is almost certainly unsafe for any secure application--
	 * the String is not checked at all, simply returned.
	 * 
	 * @param prompt   the String prompting user entry
	 * @return         a String containing the entire line input by the user
	 */
	public String stringRequest(String prompt) {
		
		System.out.print("\n" + prompt);
		
		return kb.nextLine();
		
	}
	
	/**
	 * closes the Scanner.
	 * only call this when the program is exiting or else you will have problems.
	 * and don't come crying to me if you do.
	 */
	public void close() {
	    this.kb.close();
	}

}
