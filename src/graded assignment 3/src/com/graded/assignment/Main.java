package com.graded.assignment;


import java.util.*;
//import com.hcl.assignment.utils.*;

@SuppressWarnings("serial")
class InvalidDataEntered  extends Exception  
{  
    public InvalidDataEntered() {
    	
    }
} 


public class Main {
	static Scanner scan = CustomScanner.getScanner();
	public static void main(String[] args) throws InvalidDataEntered {

		
		MagicOfBooks magicOfBooks = new MagicOfBooks();
		boolean flag = true;
		
		try {
			
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Welcome Admin");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println();
			while(flag) {
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("Press 1 for Add the book");
				System.out.println("Press 2 for Delete the book");
				System.out.println("Press 3 for Update the book");
				System.out.println("Press 4 for Display the book");
				System.out.println("Press 5 for Count the book");
				System.out.println("Press 6 for ArrageOrder of books");
				System.out.println("Press 7 for display books from Category");
				System.out.println("Press 8 for exit");
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				System.out.println("Please Enter your choice:");
				int choice = scan.nextInt();
				System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
				switch(choice) {
				case 1:
					System.out.println("Enter Number Of Book You Want to add:");
					int n = scan.nextInt();
					System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
					for(int i=1;i<=n;i++) { 
					magicOfBooks.add();
					}
					break;
				case 2:
					magicOfBooks.delete();;
					break;
				case 3:
					magicOfBooks.update();
					break;
				case 4:
					magicOfBooks.display();
					break;
				case 5:
					magicOfBooks.count();
					break;
				case 6:
					magicOfBooks.arrageOrder();
					break;
				case 7:
					
					magicOfBooks.displayByGenre();
					
					break;
				case 8:
						flag = false;
						System.out.println("Thank You For Visit");
						System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
						break;
					
				default:
					throw new InvalidDataEntered();
				}
				}

		}
		catch(InvalidDataEntered e){
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			System.out.println("Empty String or Invalid String Entered");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	}
  }

}