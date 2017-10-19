package dictionary;

import java.util.Scanner;

public class DictionaryDriver {

	public static void main(String[] args) {
		
	
		Dictionary driver = new Dictionary();
		Scanner sc = new Scanner(System.in);
		int option;
		do{
			System.out.println("Please Select an Option:");
			System.out.println("1. Find Meaning");
			System.out.println("2. Find Synonym");
			System.out.println("3. Add word and its meaning");
			System.out.println("4. Add synonym for the word");
			System.out.println("5. Exit");
			option = sc.nextInt();
			switch (option) {
				case 1:
					System.out.println("Enter the word:");	
					String word1 = sc.next();
					//function call for finding the meaning from the word
					System.out.println("Meaning of "+ word1 +" is " + driver.viewMeaning(word1));
					break;
			
				case 2:
					System.out.println("Enter the word:");
					String word2 = sc.next();
					//function call for finding synonym
					System.out.println("Word is: "+word2);
					System.out.println("The list of synonym(s) is: " + driver.viewSynonym(word2) );
					//driver.view
					break;
				case 3:
					System.out.println("Enter the word:");
					String word4 = sc.next();
					System.out.println("Please enter meaning:");
					String meaning = sc.next();
					driver.addWord_Meaning(word4,meaning);
					break;
				case 4:
					System.out.println("Enter the word:");
					String word5 = sc.next();
					System.out.println("Please enter synonym:");
					String synonym = sc.next();
					driver.addSynonym(word5,synonym);
					break;
				case 5:
					System.exit(0);
					break;
				default:
					break;
			}
		}while(option!=5);
		
		sc.close();

	}

}
