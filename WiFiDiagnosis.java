/**
 * Name:		David Rodriguez
 * Instructor:	Grigoriy Grinberg
 * Description:	Wifi Diagnosis Tool
 * Due:			06/14/2021
 * 
 * Pledge: I, David Rodriguez, pledge that I have completed this
 * programming assignment independently.
 * All work provided here is of my own.
 * 
 */

//package A1_WifiTroubleShooter;

import java.util.Scanner;

/**
 * This is a Wifi Connectivity Diagnosis Tool. 
 * It guides a user through instructions for troubleshooting connectivity.
 * @author David Rodriguez
 *
 */
public class WiFiDiagnosis {

	public static void main(String[] args) {
		//Declaring variables
		int step =1;		//used to label each instruction step
		String answer="";	//used to store user input
		char character='n';	//used to store the user input's first character
		String solution=""; //used to display the solution that worked
		Scanner scan = new Scanner(System.in);
		
		//Print program header
		printHeader();
		
		
		//Loop through steps as long as answer is 'no'/'n'
		do {
			System.out.println("-------------------------------------------------------------");
			
			//Display instructions according to which step we're at
			switch(step) {
				case 1:
					System.out.printf("Step %s: Reboot the computer and re-attempt connecting.\n",step);
					solution = "Great! Rebooting the computer solved the issue.";
					break;
					
				case 2:	
					System.out.printf("Step %s: Reboot the wifi router and re-attempt connecting.\n",step); 
					solution = "Great! Rebooting the router solved the issue.";
					break;
					
				case 3:	
					System.out.printf("Step %s: Ensure that the router's cables are properly plugged in.\n"
							+ "\tMake sure that power is connected to the router.\n",step); 
					solution = "Great! Checking the router connections solved the issue.";
					break;
					
				case 4:	
					System.out.printf("Step %s: Move the computer closer to the router and retry connecting.\n",step); 
					solution = "Great! Moving the computer closer solved the issue.";
					break;
					
				case 5:	
					System.out.println("We're sorry. Please contact your Internet Service Provider.");
					break;
			}// end switch statement
			
			//If we reached the last step, then break loop
			if(step == 5) break;
			
			//Prompt user if this fixed the issue
			System.out.print("Did this fix the issue?: (y/n)");
			answer = scan.nextLine();
			System.out.println();
			
			character = ' ';
			if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no") ||
				answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))
				character = answer.toLowerCase().charAt(0);
			
			//Check for a valid answer
			while(character != 'Y' && character != 'y' && character != 'N' && character != 'n'){
				
				System.out.println("Your answer must be either [ \"yes\" | \"no\" | \"y\" | \"n\" ]");
				System.out.print("Did this fix the issue?: ");
				answer = scan.nextLine();
				
				System.out.println();
				character = ' ';
				if(answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no") ||
					answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))
					character = answer.toLowerCase().charAt(0);
			}
			
			//Increment to the next step
			if(character =='n')
				step++;
			
		}while(character == 'n');
		
		if(character == 'y')
			System.out.println(solution);
		
		
		System.out.println("**************************************************************");
		System.out.println("****** Thanks for using WhyFi(x) - Wifi Diagnosis Tool! ******");
		System.out.println("******              by David Rodriguez                  ******");
		System.out.println("**************************************************************");
		scan.close();
	}
	
	/**
	 * Method used to print application header.
	 */
	public static void printHeader() {
		System.out.println("**************************************************************");
		System.out.println("***********   WhyFi(x) - Wifi Diagnosis Tool  ****************");
		System.out.println("**************************************************************");
		
		System.out.println("\nThis tool will help you troubleshoot your wifi connectivity.");
		System.out.println("Answer the questions to identify the issue.");
		System.out.println("Type your answer (yes/no or y/n) then hit enter to continue.");
		
		
		
	}
}
