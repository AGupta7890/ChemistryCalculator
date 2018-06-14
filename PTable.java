package xCR;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class PTable {
	
// SURVEY:
// https://goo.gl/forms/vW5sl71gCuAJZaJa2
	//Pennsylvania State University supplied periodic table
	//https://pixabay.com/en/chemistry-icon-laboratory-science-856929/ icon
  
    static String names[] = new String[118];
    static Map<String, ElementDatabase> map = new HashMap<String, ElementDatabase>();
	
  public static void main (String[]args) throws FileNotFoundException {
    
 /**********************************************************************************************************************************
   * Creating the Periodic Table
   */
   
  //TYPE ORDER OF ELEMENT PARAMETERS:
  //INT,    STRING, STRING, DOUBLE, STRING,  DOUBLE, INT,    INT, INT, STRING, STRING,  STRING, STRING
  //NUMBER, SYMBOL, NAME,   MASS,   ECONFIG, EN,     RADIUS, IE,  EA,  OXI,    BONDING, METAL,  DATE
    
    Scanner nameInput = new Scanner(new File ("ElementSymbols.txt"));
    Scanner tableInput = new Scanner(new File("PeriodicTableEdited.txt"));
    
    //String names[] = new String[118];

    for (int m = 0; m < names.length; m++) {
     names[m] =  nameInput.nextLine().trim();
    }
    
    String lineInfo[] = new String[118];
    
    int i = 0;
    while (tableInput.hasNext()) {
      lineInfo[i] = tableInput.nextLine();
      i++;
    }
    //System.out.println(lineInfo[12]); //TEST
    
   //Map<String, Element> map = new HashMap<String, Element>();
      
   for (int n = 0; n < names.length; n++) {

     String[] holder = lineInfo[n].split(":");
     
     map.put(names[n].toString(), new ElementDatabase(Integer.parseInt(holder[0].trim()),
                                   holder[1].trim(), 
                                   holder[2].trim(),
                                   Double.parseDouble(holder[3].trim()), 
                                   holder[4].trim(), 
                                   Double.parseDouble(holder[5].trim()), 
                                   Integer.parseInt(holder[6].trim()),
                                   Integer.parseInt(holder[7].trim()),
                                   Integer.parseInt(holder[8].trim()),
                                   holder[9].trim(),
                                   holder[10].trim(), 
                                   holder[11].trim(), 
                                   holder[12].trim()));
     

     //map.put(names[0], new Element(1, "a", "a", 1.0, "a", 1.0, 1, 1, 1, "a", "a", "a", "a")); //CREATION TEST
     //System.out.println(map.get(array[0])/*.getAtomicNumber()*/); //PRINT ELEMENT TEST     
     //System.out.print(holder[4] + "\n"); //TEST
   }
   
   nameInput.close();
   tableInput.close();
   
/**************************************************************************************************************************************
  * Periodic Table Finished
  */
   
/***************************************************************************
  * TEST PRINT TOSTRING()
  *
   //String h = names[1];
   //System.out.println(h);
   System.out.println(map.get("C").toString()); //PRINT ELEMENT TEST
   
   //String he = names[45];
   //System.out.println(he);
   //System.out.println(map.get(names[symbolToArrayNumber("Pd", names)]).toString()); //PRINT ELEMENT TEST
   //System.out.println(Arrays.toString(names));
/**************************************************************************
  * TEST PRINT END
  */
   
 /**************************************************************************************************
  * USER INPUT
  */
   
   /*
   Scanner userInput = new Scanner(System.in);
   System.out.println("Enter Binary Compound:");
   String inputCompound = userInput.nextLine();
   System.out.println("Enter which element you wish to find hybridization of:");
   String inputHBD = userInput.nextLine();
   Algorithms alg = new Algorithms(names, map, inputCompound, inputHBD);
   System.out.println(alg.toString());
   System.out.println(alg.getBasicInfo());
   System.out.println(alg.getValenceE("Al")); */
   
   //TWO MAJOR GET METHODS: covalentInfo and ionicInfo, with basicInfo
   
   //Get covalent/ionic
   //Get bonds
   //Get Oxidation states
   //Get shape
   //Get hybridization
   //Get bond angles
   //Get bond polarity
   //Get molecular polarity?
   //Get Intermolecular Forces
   //
   
  GUIs gui = new GUIs();
  gui.start();
 // Element compound = new Element("Ca2Cl");
 // System.out.println(compound.getCapital() + " " + compound.getFirstElement() + " " + compound.getSecondElement() + " " + compound.getFirstNumber() + " " + compound.getSecondNumber());
 }
  
}