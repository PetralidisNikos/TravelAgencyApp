package basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class VisitorsOfCity extends City implements Serializable {
	private static final long serialVersionUID = -621886291306848687L;
	
	//dilwsi tou collection traveller
	private ArrayList<String> TravellersRecommended;
	
	//konstraktoras tis neas klasis me klironomisi apo tin City kai prosthesi tou arraylist me tous traveller
	public VisitorsOfCity(String name, int museums, int cafes, int bars, int restaurants, int beaches, boolean weather, double lat, double lon,ArrayList<String> TravellersRecommended) {	
	super(name,museums,cafes,bars,restaurants,beaches,weather,lat,lon);
	TravellersRecommended = new ArrayList<String>();
	}
	public VisitorsOfCity() {}

	//getter and setter
	public ArrayList<String> getTravellersRecommended() {
		return TravellersRecommended;
	}
	public void setTravellersRecommended(ArrayList<String> travellersRecommended) {
		TravellersRecommended = travellersRecommended;
	}
	
	
	//methodos katametrisis tou arithmou twn traveller pou tous egine recommend i poli
	public int recommendedTravCount(ArrayList<String> travellerArray) {
		
		int recTravCount = 0;
		if (travellerArray != null) {
			for (int i=0 ; i < travellerArray.size() ; i++) {
				recTravCount++;
			}
			return recTravCount;
		}else {
			return 0;
		}
	}
	
		//methodos apothikeysis twn object VisitorsOfCity se ena arxeio visitors.txt
		public static void saveVisitorsToFile(ArrayList<VisitorsOfCity> visitorsToSave) {

			try {
				FileOutputStream fileout = new FileOutputStream(new File("Visitors.txt"));
				ObjectOutputStream objout = new ObjectOutputStream(fileout);
				for (VisitorsOfCity iteratedVisitor : visitorsToSave) {
					objout.writeObject(iteratedVisitor);
				}
				objout.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	
		//methodos anaktisis twn object VisitorsOfCity apo to arxeio visitors.txt
		public static ArrayList<VisitorsOfCity> RetrieveVisitors(int numberofVisitors) {

			ArrayList<VisitorsOfCity> fileList = new ArrayList<>();
			
			if(numberofVisitors !=0) {
			try { 
				FileInputStream fi = new FileInputStream(new File("Visitors.txt"));
				ObjectInputStream oi = new ObjectInputStream(fi);

				for(int i=1;i<=numberofVisitors;i++) {
					fileList.add((VisitorsOfCity) oi.readObject());
				}
				oi.close();
				fi.close();

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			}
			return fileList;
		}
	
	
		//methodos pou apothikevei to plithos twn eggrafwn se arxeio
		public static void saveVisitorCount(int counttoSave) {

			try {
				FileWriter fw = new FileWriter("VisitorCount.txt",false);
				fw.write(String.valueOf(counttoSave));
				fw.close();

			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (IOException e) {
				System.out.println("Error initializing stream");
			}
		}

		//methodos pou anaktaei to plithos twn eggrafwn apo to arxeio
		public static int retrieveVisitorCount() throws FileNotFoundException {
		
			String CounttoRetrieve;
			File file = new File("VisitorCount.txt");
			Scanner scanner = new Scanner(file);
			CounttoRetrieve = scanner.next();
			int retrieve = Integer.parseInt(CounttoRetrieve);
			scanner.close();

		return retrieve;
	}	
}
