package basic;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExamMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		int VisitorCount;
		
		
		//creating dummy data to work with
		ArrayList<String> array1 = new ArrayList<String>();
		ArrayList<String> array2 = new ArrayList<String>();
		ArrayList<String> array3 = new ArrayList<String>();
		
		array1.add("Nick");
		array1.add("John");
		array2.add("Nick");
		array2.add("Andrew");
		array3.add("Nick");
		array3.add("Alex");
		
		VisitorsOfCity object1 = new VisitorsOfCity("Athens", 1, 2, 3, 4, 5, false, 11.11, 12.12, array1);
		VisitorsOfCity object2 = new VisitorsOfCity("Rome", 6, 7, 8, 9, 1, false, 21.21, 22.22, array2);
		VisitorsOfCity object3 = new VisitorsOfCity("thessaloniki", 2, 3, 4, 5, 6, false, 31.31, 32.32, array3);
		
		// Arraylist for loading Visitors from file
		ArrayList<VisitorsOfCity> storedVisitors = new ArrayList<VisitorsOfCity>();
		
		//----------adding visitors to file---------------------------------------------
		
		
//		// --------extracting Visitor count from file--------
//		VisitorCount = VisitorsOfCity.retrieveVisitorCount();
//		System.out.println("Objects in file: " +VisitorCount);
//		// --------loading the traveller List from File--------
//		storedVisitors = VisitorsOfCity.RetrieveVisitors(VisitorCount);
//		System.out.println(VisitorCount+" Visitors Loaded");
//		
//		//---------adding the new objects to the arrayList--------
//		storedVisitors.add(object1);
//		VisitorCount++;
//		storedVisitors.add(object2);
//		VisitorCount++;
//		storedVisitors.add(object3);
//		VisitorCount++;
//		System.out.println("new objects added!");
//
//		//-------storing the new arraylist to the file------------
//		VisitorsOfCity.saveVisitorsToFile(storedVisitors);
//		//-------storing the new Visitor Count to the file---------
//		VisitorsOfCity.saveVisitorCount(VisitorCount);
//		System.out.println("now there are "+VisitorCount+" objects in the file");
//		
//		
		
		
		
		//------------reading the file----------------------------
		// --------extracting Visitor count from file--------
		VisitorCount = VisitorsOfCity.retrieveVisitorCount();
		System.out.println("Objects in file: " +VisitorCount);
		// --------loading the traveller List from File--------
		storedVisitors = VisitorsOfCity.RetrieveVisitors(VisitorCount);
		System.out.println(VisitorCount+" objects Loaded");
		for (VisitorsOfCity c:storedVisitors) {
			System.out.println(c.getName()+" "+c.getMuseums());
		}
	}

}
