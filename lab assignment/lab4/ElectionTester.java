import java.util.Scanner;
public class ElectionTester {
	public static void main(String[] args) {
		MyDate election = new MyDate(2019, 3, 24);
		
		Person a = new Person("Lalisa", "Manoban", 1997, 3, 27);
		printPersonElectionInfo(a, election);
		
		Person b = new Person("Nuda", "Inter", 2012, 1, 16);
		printPersonElectionInfo(b, election);
		
		// Create another Person object with your information
		// Print your information, age, and election eligibility.
		
		/*
		 * YOUR CODE GOES HERE
		 */
		Person c = new Person("Da", "Surada", 2001, 2, 10);
		printPersonElectionInfo(c, election);
		// Write a program to take 3 persons information from the user
		// (Hint: Use scanner and for loop to get input)
		Person [] d = new Person [3] ;
		String fname ;
		String lname ;
		int uyear ;
		int um;
		int ud;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter firstname:");
			fname = scan.next();
			System.out.println("Enter lastname:");
			lname = scan.next();
			System.out.println("Enter year of birthday:");
			uyear = scan.nextInt();
			System.out.println("Enter month of birthday:");
			um = scan.nextInt();
			System.out.println("Enter day of birhtday:");
			ud = scan.nextInt();
			
			d[i] = new Person(fname, lname, uyear, um, ud);
			printPersonElectionInfo(d[i], election);

		}

		

		/*
		 * YOUR CODE GOES HERE
		 */
		
		
		
		// Challenge Bonus
		// Instead of taking 3 persons' information, write a program to continuously take input from the user
		// until the user types 'q' to quite the program.
		
		/*
		 * YOUR CODE GOES HERE
		 */
		while(true){
			System.out.println("Enter firstname:");
			fname = scan.next();
			if(fname.equals("q")){
				System.out.println("Exit the program");
				break;
			}
			System.out.println("Enter lastname:");
			lname = scan.next();
			System.out.println("Enter year of birthday:");
			uyear = scan.nextInt();
			System.out.println("Enter month of birthday:");
			um = scan.nextInt();
			System.out.println("Enter day of birhtday:");
			ud = scan.nextInt();
			
			Person xx = new Person(fname, lname, uyear, um, ud);
			printPersonElectionInfo(xx, election);
		}
	}
	
	public static void printPersonElectionInfo(Person p, MyDate election) {
		p.printPersonInfo();
		System.out.println("Age: " + p.getAge(election));
		if(p.isEligible(election))
			System.out.println("This person is eligible to vote.");
		else
			System.out.println("This person is NOT eligible to vote");
		
		System.out.println("-----------------------------------");
	}
}
