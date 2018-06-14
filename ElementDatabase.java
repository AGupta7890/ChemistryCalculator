package xCR;

//import java.io.*;
//import java.util.*;
public class ElementDatabase  {
  
  private int atomicNumber;
  private String symbol;
  private String name;
  private double atomicMass;
  private String eConfig;
  private double electronegativity;
  private int atomicRadius;
  private int ionizationEnergy;
  private int activationEnergy;
  private String possibleOxiStates;
  private String bondingType;
  private String metalOrNot;
  private String yearDiscovered;
  
  public ElementDatabase(int atomicNumber,
                       String symbol,
                       String name,
                       double atomicMass,
                       String eConfig,
                       double electronegativity,
                       int atomicRadius,
                       int ionizationEnergy,
                       int activationEnergy,
                       String possibleOxiStates,
                       String bondingType,
                       String metalOrNot,
                       String yearDiscovered)  {
    
    this.atomicNumber = atomicNumber;
    this.symbol = symbol;
    this.name = name;
    this.atomicMass = atomicMass;
    this.eConfig = eConfig;
    this.electronegativity = electronegativity;
    this.atomicRadius = atomicRadius;
    this.ionizationEnergy = ionizationEnergy;
    this.activationEnergy = activationEnergy;
    this.possibleOxiStates = possibleOxiStates;
    this.bondingType = bondingType;
    this.metalOrNot = metalOrNot;
    this.yearDiscovered = yearDiscovered;
    
                   /* Scanner input = new Scanner (new File ("PeriodicTableEdited.txt"));                                
                      atomicNumber = input.nextInt();
                      symbol = input.next();*/
                                 
  }
  //ATOMIC NUMBER INT
  public int getAtomicNumber() {
   return atomicNumber; 
  }
  //SYMBOL STRING
   public String getSymbol() {
   return symbol; 
  }
   //ATOMIC MASS DOUBLE
   public double getAtomicMass() {
    return atomicMass; 
   }
   //E CONFIG STRING
   public String getEConfig(){
    return eConfig; 
   }
   //ELECTRONEGATIVITY DOUBLE
   public double getEN() {
    return electronegativity; 
   }
   //ATOMIC RADIUS INT
   public int getAtomicRadius() {
    return atomicRadius; 
   }
   //IONIZATION ENERGY INT
   public int getIonizationEnergy() {
    return ionizationEnergy; 
   }
   //EA INT
   public int getEA() {
    return activationEnergy; 
   }
   //POSSIBLE OXIDATION STATES STRING
   public String getPossibleOxiStates() {
    return possibleOxiStates; 
   }
   //BONDING TYPE STRING
   public String getBondingType() {
     return bondingType;
   }
   //METAL OR NOT STRING
   public String getMetalOrNot() {
    return metalOrNot; 
   }
   //YEAR DISCOVERED STRING
   public String getYearDiscovered() {
    return yearDiscovered; 
   }
   
	public int getValenceE () {
		int sum = 0;
		String[] orbitals = getEConfig().split("-");
		if (getSymbol().equals("H")) return 1;
		else if (getSymbol().equals("He")) return 2;
		else
		for (int i = 1; i < orbitals.length; i++){
		  sum += Integer.parseInt(orbitals[i].substring(2));
		   }
		  return sum;
	}
    public int getFullShell () {
    	String nextNoble;
    	int i = getAtomicNumber();
    	while (!PTable.map.get(PTable.names[i-1]).getMetalOrNot().equals("noble-gas")) i++;
    	//while (!PTable.map.get(PTable.names[i-1]).getMetalOrNot().equals("noble-gas")) i++;
    	nextNoble = PTable.names[i];
    	
    	String[] orbitals = PTable.map.get(nextNoble).getEConfig().split("-");
    	try {
    	int sum = PTable.map.get((orbitals[0].substring(orbitals[0].indexOf('[')+1,orbitals[0].indexOf(']')))).getValenceE();
    	return sum;
    	}catch(StringIndexOutOfBoundsException e) {
          return 2;
    	}finally {}
    }
  
  public String toString () {
    return (           symbol + ": " 
                       + name + ", "
                       + "\nAtomic Number:" + atomicNumber
                       + "\nAtomic Mass: " + atomicMass
                       + "\nElectron Configuration: " + eConfig
                       + "\nNumber of Valence Electrons: " + Integer.toString(getValenceE())
                       + "\nEN: " + electronegativity
                       + "\nAtomic Radius: " + atomicRadius
                       + "\nIonization Energy: " + ionizationEnergy
                       + "\nActivation Energy: " + activationEnergy
                       + "\nPossible Oxitation States: " + possibleOxiStates
                       + "\nBonding Type: " + bondingType
                       + "\nMetal Or Not?: " + metalOrNot
                       + "\nYear Discovered: " + yearDiscovered);
  }
  
                       /*public static void main (String[]args) {
    
                         PeriodicTable table = new PeriodicTable ();
                         System.out.println(table.getAtomicNumber() + " | " + table.getSymbol()); 
                          }*/
}