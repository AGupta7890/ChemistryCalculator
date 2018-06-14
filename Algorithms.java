package xCR;

import java.util.Arrays;
import java.util.Map;

public class Algorithms {

	
	
	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String[] names;
	private Map<String, ElementDatabase> map;
	private Element compound;
	
	private String firstElement;
	private String secondElement;
	private String secondPoly;
	private int firstNumber;
	private int secondNumber;
	
	private int singleBonds;
	private int doubleBonds;
	private int tripleBonds;
    
	private BondTypeCovalent bondType;  //new BondTypeCovalent(PTable.map, firstElement, secondElement, firstNumber, secondNumber);
	
	// CONSTRUCTOR
	public Algorithms(String[] names, Map<String, ElementDatabase> map, Element compound) {
		// DEFINITION
		this.names = names;
		this.map = map;
		this.compound = compound;
		this.firstElement = compound.getFirstElement();
		this.secondElement = compound.getSecondElement();
		this.secondPoly = compound.getSecondPoly();
		this.firstNumber = compound.getFirstNumber();
		this.secondNumber = compound.getSecondNumber();
        this.bondType = new BondTypeCovalent(PTable.map, firstElement, secondElement, firstNumber, secondNumber);
		
	}

	public boolean isException(String x) {
		if (x.equals("B") || x.equals("S") || x.equals("P") || x.equals("N")) {
			return true;
		} else
			return false;
	}
    //****************************************************
	//STANDARD GETTERS
	public static String getAlpha() {
		return ALPHA;
	}

	public String[] getNames() {
		return names;
	}

	public Map<String, ElementDatabase> getMap() {
		return map;
	}

	public Element getCompound() {
		return compound;
	}

	public String getFirstElement() {
		return firstElement;
	}

	public String getSecondElement() {
		return secondElement;
	}

	public String getSecondPoly() {
		return secondPoly;
	}

	public int getFirstNumber() {
		return firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public int getSingleBonds() {
		return singleBonds;
	}

	public int getDoubleBonds() {
		return doubleBonds;
	}

	public int getTripleBonds() {
		return tripleBonds;
	}
	
	// IONIC GET ALGORITHM METHODS
	// ****************************************************


	public String getOxidationStates() {
		int oxiOne = secondNumber;
		int oxiTwo = firstNumber;
		String[] s1 = map.get(firstElement).getPossibleOxiStates().split(",");
		String[] s2 = map.get(secondElement).getPossibleOxiStates().split(",");
		int n = 0;
		int m = 0;
		for (int i = 0; i < s1.length; i++) {
			if (!s1[i].equals(Integer.toString(oxiOne)))
				n++;
		}
		for (int i = 0; i < s2.length; i++) {
			if (!s2[i].equals(Integer.toString(oxiTwo)))
				m++;
		}

		if (n == s1.length || m == s2.length)
			return "Error: Please enter a legitimate value!";

		else
			return "\nOxidation State for first element " + firstElement + " is: +" + oxiOne + "."
					+ "\nOxidation State for second element " + secondElement + " is: -" + oxiTwo + ".";
	}

	public String getBondPolarityIonic() {
		double en = Math.abs(map.get(firstElement).getEN() - map.get(secondElement).getEN());
		return "The Difference in Electronegativity is: " + en
				+ " and contains a metal + non-metal. Therefore this is an ionic compound.";
	}

	public String molecularPolarityIonic() {
		return "As an ionic compound, the molecular is polar! The cations, or the metal, are positive, as metals tend to\n"
				+ "lose electrons. The anions, or the non-metals, are negative, as they tend to gain electrons. In this case,\n"
				+ "the metal is: " + firstElement + " and the non-metal is: " + secondElement + ".\n"
				+ "The intermolecular forces are ionic.\n";
	}

	// COVALENT GET ALGORITHM METHODS
	// ***********************************************

	public String getEPG() {
		if (bondType.getERegions() == 2) return "The Electron-Pair Geometry shape of the central atom is: Linear\n";
    	if (bondType.getERegions() == 3) return "The Electron-Pair Geometry shape of the central atom is: Trigonal Planar\n";
    	if (bondType.getERegions() == 4) return "The Electron-Pair Geometry shape of the central atom is: Tetrahedral\n";
    	if (bondType.getERegions() == 5) return "The Electron-Pair Geometry shape of the central atom is: Trigonal Bipyramid\n";
    	if (bondType.getERegions() == 6) return "The Electron-Pair Geometry shape of the central atom is: Octahedral\n";
    	else return "Not a binary compound or incorrect format; please input accepted compounds.";
	}
	
	public String getMG() {
		if (bondType.getERegions() == 2 && (firstNumber + secondNumber - 1) == 1) return "The Molecular Geometry shape of the central atom is: Linear.\n";
	   	if (bondType.getERegions() == 2 && (firstNumber + secondNumber - 1) == 2) return "The Molecular Geometry shape of the central atom is: Linear.\n";
    	if (bondType.getERegions() == 3 && (firstNumber + secondNumber - 1) == 3) return "The Molecular Geometry shape of the central atom is: Trigonal Planar.\n";
    	if (bondType.getERegions() == 3 && (firstNumber + secondNumber - 1) == 2) return "The Molecular Geometry shape of the central atom is: Bent.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 4) return "The Molecular Geometry shape of the central atom is: Tetrahedral.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 3) return "The Molecular Geometry shape of the central atom is: Trigonal Pyramid.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 2) return "The Molecular Geometry shape of the central atom is: Bent.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 5) return "The Molecular Geometry shape of the central atom is: Trigonal Bipyramid.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 4) return "The Molecular Geometry shape of the central atom is: See-Saw.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 3) return "The Molecular Geometry shape of the central atom is: T-Shaped.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 2) return "The Molecular Geometry shape of the central atom is: Linear.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 6) return "The Molecular Geometry shape of the central atom is: Octahedral.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 5) return "The Molecular Geometry shape of the central atom is: Square Pyramid.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 4) return "The Molecular Geometry shape of the central atom is: Square Planar.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 3) return "The Molecular Geometry shape of the central atom is: T-Shaped.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 2) return "The Molecular Geometry shape of the central atom is: Linear.\n";
    	else return "Not a binary compound or incorrect format; please input accepted compounds.";
	}
	
	public String getHBD() {
		if (bondType.getERegions() == 2) return "The Hybridization is of the central atom is: sp\n";
    	if (bondType.getERegions() == 3) return "The Hybridization is of the central atom is: sp2\n";
    	if (bondType.getERegions() == 4) return "The Hybridization is of the central atom is: sp3\n";
    	if (bondType.getERegions() == 5) return "The Hybridization is of the central atom is: sp3d\n";
    	if (bondType.getERegions() == 6) return "The Hybridization is of the central atom is: sp3d2\n";
    	else return "Not a binary compound or incorrect format; please input accepted compounds.";
	}
	
	public String getBondAngles() {
		if (bondType.getERegions() == 2 && (firstNumber + secondNumber - 1) == 1) return "The bond angles are: 180°.\n";
		if (bondType.getERegions() == 2 && (firstNumber + secondNumber - 1) == 2) return "The bond angles are: 180°.\n";
    	if (bondType.getERegions() == 3 && (firstNumber + secondNumber - 1) == 3) return "The bond angles are: 120°.\n";
    	if (bondType.getERegions() == 3 && (firstNumber + secondNumber - 1) == 2) return "The bond angles are: <120°.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 4) return "The bond angles are: 109°.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 3) return "The bond angles are: <109°.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 2) return "The bond angles are: <<109°.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 5) return "The bond angles are: 120° between equatorial, 90° between axial.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 4) return "The bond angles are: <120° between equatorial, <90° between axial.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 3) return "The bond angles are: <90° between axial.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 2) return "The bond angles are: 180°.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 6) return "The bond angles are: 90°.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 5) return "The bond angles are: <90° equatorial and axial.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 4) return "The bond angles are: 90°.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 3) return "The bond angles are: <90°.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 2) return "The bond angles are: 180°.\n";
    	else return "Not a binary compound or incorrect format; please input accepted compounds.";
	}
	
	public String getCovalentPolarity() {
		if (bondType.getERegions() == 2 && (firstNumber + secondNumber - 1) == 1) return "The Molecular polarity is probably non-polar!.\n";
		if (bondType.getERegions() == 2 && (firstNumber + secondNumber - 1) == 2) return "The Molecular polarity is probably non-polar!.\n";
    	if (bondType.getERegions() == 3 && (firstNumber + secondNumber - 1) == 3) return "The Molecular polarity is probably non-polar!.\n";
    	if (bondType.getERegions() == 3 && (firstNumber + secondNumber - 1) == 2) return "The Molecular polarity is probably polar!.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 4) return "The Molecular polarity is probably non-polar!.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 3) return "The Molecular polarity is probably polar!.\n";
    	if (bondType.getERegions() == 4 && (firstNumber + secondNumber - 1) == 2) return "The Molecular polarity is probably polar!.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 5) return "The Molecular polarity is probably non-polar!.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 4) return "The Molecular polarity is probably polar!.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 3) return "The Molecular polarity is probably polar!.\n";
    	if (bondType.getERegions() == 5 && (firstNumber + secondNumber - 1) == 2) return "The Molecular polarity is probably non-polar!.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 6) return "The Molecular polarity is probably non-polar!.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 5) return "The Molecular polarity is probably polar!.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 4) return "The Molecular polarity is probably non-polar!.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 3) return "The Molecular polarity is probably polar!.\n";
    	if (bondType.getERegions() == 6 && (firstNumber + secondNumber - 1) == 2) return "The Molecular polarity is probably non-polar!.\n";
    	else return "Not a binary compound or incorrect format; please input accepted compounds.";
	}

	public String getBondPolarityCovalent() {
		double en = Math.abs(map.get(firstElement).getEN() - map.get(secondElement).getEN());
		if (en<0.5) return ("This EN difference between " + firstElement + " and " + secondElement + " is: " + en + ", therefore the bonds are non-polar.");
		else
			{
               String newString =  "This EN difference between " + firstElement + " and " + secondElement + " is: " + en + ", therefore the " ;
		             String newerString = (map.get(firstElement).getEN() > map.get(secondElement).getEN()) ? firstElement + " is more slightly negative" : secondElement + " is more slightly negative";
		             return newString + newerString;
			}
	}
	
	public String getIonicInfo() {
		/*
		 * Things to output: Bond: Ionic -- Oxidation States (other element's #)
		 * -- Bond polarity -- molecular polarity (via shape)--
		 */ return "Please ensure this compound exists, otherwise some information, such as charges, may be incorrect!\n"
				+ "This compound is an ionic compound.\n" + getOxidationStates() + "\n" + getBondPolarityIonic() + "\n"
				+ molecularPolarityIonic() + "\n\n";
	}

	public String getCovalentInfo() {
		/*
		 * Things to output: Bond: Covalent-- bond types (double/triple) shape
		 * hybridization bond angles bond polarity molecular polarity
		 * Intermolecular forces
		 */
     
		return "Please ensure this compound exists, otherwise some information may be incorrect!\n"
				+ "This compound is a covalent compound.\n"
		        + bondType.toString() + "\n"
		        + getBondPolarityCovalent() +"\n\n---------------------------------------------\n\n";
	}
	
    public String getHBDInfo() {
    	String newString = getEPG() + getMG() + getHBD() + getBondAngles() + "\n\nProperties\n\n" + getCovalentPolarity()
    	                   + "\nIf both the bonds and the shape(molecular polarity) are polar, then the molecule is polar."
    	                   + "\nOtherwise, if the bonds are not polar, then the molecule may only be polar if the shape is."
    	                   + "\nPolar molecules engage in dipole-dipole with itself. Non-polar molecules use London Dispersion Forces."
    	                   + "\nLDFs are weaker than dipole-dipoles, which are weaker than Hydrogen bonds. The greater the bond, the"
    	                   + "\nmore energy is required to separate the atoms, and therefore have greater melting, boiling, and solublity points.\n\n";
        return newString +"\n\n---------------------------------------------\n\n";	
    }
    
	public String getBasicInfo() {
		return map.get(firstElement).toString() + " \n\n" + map.get(secondElement).toString() + "\n\n---------------------------------------------\n\n";
	}


	@Override
	public String toString() {
		return "Algorithms [names=" + Arrays.toString(names) + ", map=" + map + ", compound=" + compound
				+ ", firstElement=" + firstElement + ", secondElement=" + secondElement + ", secondPoly=" + secondPoly
				+ ", firstNumber=" + firstNumber + ", secondNumber=" + secondNumber + ", singleBonds=" + singleBonds
				+ ", doubleBonds=" + doubleBonds + ", tripleBonds=" + tripleBonds + "]";
	}
}
