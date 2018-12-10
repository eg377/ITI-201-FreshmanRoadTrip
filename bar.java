import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class bar{

	static double startGPA = 3.0;
	static int startHealth = 75;

	public static void nextMenu(){
		boolean loopNextMenu = true;
		Scanner in = new Scanner(System.in);
		System.out.println("[c] to continue");
		while(loopNextMenu){
			String q1 = in.nextLine();
			if(q1.equals("c")){
				loopNextMenu = false;
			}
		} 
	}

	public static void waitHere(int seconds){
		try{
			Thread.sleep(seconds*1000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public static void printMenu(){
		System.out.println("\n==================== MENU =====================");

		System.out.print("1. Type 'b' or 'bar' to see your energy and GPA bar.\n"+
			"2. Type 'bp' or 'backpack' to open your bag.\n"+
			"3. Type 'e' or 'exit' to close menu.\n");


		System.out.println(" ");
	}

	public static void continuePlayer(){
		Scanner in = new Scanner(System.in);
		boolean loopContinuePlayer = true;
		boolean loopContinuePlayer2 = true;
		printMenu();
		while(loopContinuePlayer){
			String q1 = in.nextLine(); 
			if(q1.equals("b") || q1.equals("bar") || q1.equals("Bar")){
				printEnergyBar(Backpack.currentHealth);
				printGPABar(Backpack.currentGPA);
				waitHere(1);
				if(loopContinuePlayer2 == false){
					loopContinuePlayer = false; // end the loop once we get the response we want
				}else{
					printMenu();
				}
			}else if(q1.equals("bp") || q1.equals("backpack") || q1.equals("Backpack")){
				Backpack.printBackpack();
				waitHere(1);
				if(loopContinuePlayer2 == false){
					loopContinuePlayer = false; // end the loop once we get the response we want
				}else{
					printMenu();
				}
			}else if(q1.equals("e") || q1.equals("exit") || q1.equals("E")){
				loopContinuePlayer2 = false;
				loopContinuePlayer = false;
			}else{
				printMenu();
			}
		}
	}

	public static void welcomePlayer(){
		// ignore code that is commented out for now
		
		// Start of the game

		//boolean returnBol = false;

		boolean welcome = true;
		boolean q1Loop = true;
		Scanner in = new Scanner(System.in);

		while(welcome){
			waitHere(1);
			System.out.println("\nWelcome to The Freshmen Bus Trip!\n");
			waitHere(1);
			nextMenu();

			while(q1Loop){
				System.out.println("Are you ready to start your day at Rutgers University? y or n\n");
				String q1 = in.nextLine(); 
				//	Making sure q1 is lower case, in case user types Y or YES
				q1 = q1.toLowerCase();
				//System.out.println(q1);
				
				if(q1.equals("y") || q1.equals("yes")){
					q1Loop = false; // end the loop once we get the response we want
				}else{
					System.out.println("Let me ask again.\n");
				}
			}

			// Continue story 
			// Introduction of objective
			waitHere(1);
			System.out.println("===================================================="+
				"=======================================================================================");
			System.out.println("\nAs a Rutgers students you need to need to maintain your energy level"+
				" above 25%"+
				" and GPA above a 2.0, otherwise you will have to meet with the DEAN!");
			waitHere(2);
			nextMenu();

			System.out.println("\nYour goal is to make it to 3 classes with the largest amount of energy and maximum GPA.");
			waitHere(2);
			nextMenu();

			System.out.println("\nAs you wake up in your dorm room to start the day you'll begin with a "+
				startGPA+" GPA and "+startHealth+"% of your energy.");
			waitHere(2);
			nextMenu();
			// First display of the bars
			waitHere(2);
			printEnergyBar(startHealth);
			waitHere(2);
			printGPABar(startGPA);
			nextMenu();

			//System.out.println();
			//Main.waitHere(1);
			//System.out.println("Don't forget to check your backpack with the 'b' key before you leave for class!");
			
			welcome = false;
		}
	}

	public static void printEnergyBar(int currentPercentile){
		//	Since the energy bar value can be anything from 0-100, divide the number 
		//	by 2 so bar is not too larger, bc we use barCurrentPercentile to 
		//	determine how many dashes to print for the bar
		int barCurrentPercentile = currentPercentile/2; // 0-50
		
		System.out.print("\nEnergy Bar: \n");

		//	Top part of the bar
		for(int i = 0; i < 50; i++){
			System.out.print("-");
		}
		System.out.println();

		//	Center of the bar
		System.out.print("|");
		for(int i = 0; i < barCurrentPercentile-1; i++){
			System.out.print("*");
		}
		System.out.print("|");

		for(int i = 0; i < 50-barCurrentPercentile-1; i++){
			System.out.print(" ");
		}
		System.out.print("|");
		// 	Bottom of the bar
		System.out.println();
		for(int i = 0; i < 50; i++){
			System.out.print("-");
		}
		

		// Prints the value below and at the end of the bar 
		System.out.println();
		for(int i = 0; i < barCurrentPercentile-1; i++){
			System.out.print(" ");
		}

		System.out.println(currentPercentile+"%");
	}

	public static void printGPABar(double currentGPA){
		//	Since the GPA value value can be anything from 0-4, multiply the number 
		//	by 12.5 so bar is not too short.
		// 	Reason for 12.5 bc 50/4 = 12.5
		//	And 50 is the max value to we have reasonably sized bar for GPA, just like energy
		// 	where the value is divided by 2 from the max possible of 100
		double barCurrentGPAvalue = currentGPA*12.5; //0-50
		
		System.out.print("\nGPA Bar: \n");

		//	Top part of the bar
		for(int i = 0; i < 50; i++){
			System.out.print("-");
		}
		System.out.println();

		//	Center of the bar
		System.out.print("|");
		for(int i = 0; i < barCurrentGPAvalue-1; i++){
			System.out.print("*");
		}
		System.out.print("|");

		for(int i = 0; i < 50-barCurrentGPAvalue-2; i++){
			System.out.print(" ");
		}
		System.out.print("|");
		// 	Bottom of the bar
		System.out.println();
		for(int i = 0; i < 50; i++){
			System.out.print("-");
		}

		// Prints the value below and at the end of the bar 
		System.out.println();
		for(int i = 0; i < barCurrentGPAvalue-1; i++){
			System.out.print(" ");
		}
		System.out.println(currentGPA+" GPA");
	}

	public static void main(String[] args){
		printEnergyBar(startHealth);
		printGPABar(startGPA);
	}
}