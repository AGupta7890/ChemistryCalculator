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
   }
   
   nameInput.close();
   tableInput.close();
   
  GUIs gui = new GUIs();
  gui.start();
 }
  
}
