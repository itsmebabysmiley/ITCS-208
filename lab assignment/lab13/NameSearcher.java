import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

public abstract class NameSearcher {

	protected static ArrayList<String> readNames = null;
	protected int number_of_compared = 0; 
	protected static List<String> temp = new ArrayList<String>();
	NameSearcher(String filename)
	{
		try {
			readNames = (ArrayList<String>) FileUtils.readLines(new File(filename), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//clean word
        readNames.replaceAll(name -> name.toLowerCase());  
	}

	public int getNumComparisons() {
		return number_of_compared;
	}

	public void resetCompareCounter() {
		number_of_compared = 0;
	}
	
    public void sortWord() {
	   //TODO       
    	Collections.sort(readNames);
    }

	public abstract String find(String query);


}

class LinearNameSearcher extends NameSearcher{
	LinearNameSearcher(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String find(String query) {
		
		// TODO Auto-generated method stub
		for (int i = 0; i < readNames.size(); i++) {
			number_of_compared++;
			if(query.compareToIgnoreCase(readNames.get(i)) == 0) return "Found : '"+query+"' AT_INDEX("+i+")";
		}
		return "Not Found Name: '"+query+"'";
	}
	
	
}

class BinaryNameSearcher extends NameSearcher{

	BinaryNameSearcher(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String find(String query) {
		// TODO Auto-generated method stub
		int i = 0, size = readNames.size()-1;
		while(i <= size) {
			int mid = (i+size)/2;
			number_of_compared++;
			if(query.compareToIgnoreCase(readNames.get(mid)) == 0) return "Found : '"+query+"' AT_INDEX("+mid+")";	//found word at mid of da list
			if(query.compareToIgnoreCase(readNames.get(mid)) > 0) i = mid+1; //word is bigger than mid.
			else size = mid - 1;	//word is smaller than mid 
		}
		return "Not Found Name: '"+query+"'";
	}
	
	
}

