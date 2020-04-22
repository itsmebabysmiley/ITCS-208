
public class NameSearcherTester {

	public static void main(String[] args)
	{
		System.out.println("***************** NORMAL****************");
		NameSearcher linearA = new LinearNameSearcher("/Users/baby/Downloads/lab13_package/test.txt");		
		System.out.print("[Linear-Case1] "+linearA.find("Zebra"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearA.getNumComparisons()+"\n");
		
		linearA.resetCompareCounter();
		System.out.print("[Linear-Case2] "+linearA.find("ant"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearA.getNumComparisons()+"\n");
		
		linearA.resetCompareCounter();
		System.out.print("[Linear-Case3] "+linearA.find("tiger"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearA.getNumComparisons()+"\n");
		

		NameSearcher linearB = new LinearNameSearcher("/Users/baby/Downloads/lab13_package/unsortedName.txt");		
		System.out.print("[Linear-Case4] "+linearB.find("Monkey D. Luffy"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
		
		linearB.resetCompareCounter();
		System.out.print("[Linear-Case5] "+linearB.find("Monkey"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
		
		linearB.resetCompareCounter();
		System.out.print("[Linear-Case6] "+linearB.find("trafalgar d. water law"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
		
		linearB.resetCompareCounter();
		System.out.print("[Linear-Case7] "+linearB.find("Yonta Maria Grand Fleet"));
		System.out.println(" >>> Number of Comparisons (Linear):"+linearB.getNumComparisons()+"\n");
				
		//BONUS
		System.out.println("********* BONUS for CRAZY PEOPLE************");
		
		NameSearcher binaryC = new BinaryNameSearcher("/Users/baby/Downloads/lab13_package/test.txt");		
		
		binaryC.sortWord();
		System.out.print("[Binary-Case1] "+binaryC.find("Zebra"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryC.getNumComparisons()+"\n");
	
		binaryC.resetCompareCounter();
		System.out.print("[Binary-Case2] "+binaryC.find("ant"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryC.getNumComparisons()+"\n");
		
		binaryC.resetCompareCounter();
		System.out.print("[Binary-Case3] "+binaryC.find("tiger"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryC.getNumComparisons()+"\n");

		NameSearcher binaryD = new BinaryNameSearcher("/Users/baby/Downloads/lab13_package/unsortedName.txt");
		binaryD.sortWord();
		System.out.print("[Binary-Case4] "+binaryD.find("Monkey D. Luffy"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");
		
		binaryD.resetCompareCounter();
		System.out.print("[Binary-Case5] "+binaryD.find("Monkey"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");
		
		binaryD.resetCompareCounter();
		System.out.print("[Binary-Case6] "+binaryD.find("trafalgar d. water law"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");
		
		binaryD.resetCompareCounter();
		System.out.print("[Binary-Case7] "+binaryD.find("Yonta Maria Grand Fleet"));
		System.out.println(" >>> Number of Comparisons (Binary):"+binaryD.getNumComparisons()+"\n");
	}
}
