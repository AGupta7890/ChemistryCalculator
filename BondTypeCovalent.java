package xCR;

import java.util.Map;

public class BondTypeCovalent {

	private int fullShellOne;
	private int fullShellTwo;
	private int valenceOne;
	private int valenceTwo;
	private int lonePairElmtOne;
	private int lonePairElmtTwo;
	private Map<String, ElementDatabase> map;
	private String firstElement;
	private String secondElement;
	//private String secondPoly;
	private int firstNumber;
	private int secondNumber;
	private int eRegions;
	private int bondingPairs;
	private int shellTotal;
	private int valenceTotal;
	
	
	public BondTypeCovalent (Map<String, ElementDatabase> map, String firstElement,
			String secondElement, int firstNumber, int secondNumber) {
		
		this.firstElement = firstElement;
		this.secondElement = secondElement;
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		
		// TOTAL VALENCE E
		this.valenceOne = map.get(firstElement).getValenceE() * firstNumber; // 4
		this.valenceTwo = map.get(secondElement).getValenceE() * secondNumber; //28
		this.valenceTotal = this.valenceOne + this.valenceTwo; // 32

		// # OCTET ATOMS
		// EXCEPTIONS: B, S, P, N

		this.fullShellOne = map.get(firstElement).getFullShell() * firstNumber; //8
		this.fullShellTwo = map.get(secondElement).getFullShell() * secondNumber; //32

		if (firstElement.equals("P"))
			fullShellOne = 12 * firstNumber;
		if (firstElement.equals("S"))
			fullShellOne = 12 * firstNumber;
		if (firstElement.equals("B"))
			fullShellOne = 6 * firstNumber;
		if (firstElement.equals("N"))
			fullShellOne = 5 * firstNumber;
		if (secondElement.equals("P"))
			fullShellTwo = 12 * secondNumber;
		if (secondElement.equals("S"))
			fullShellTwo = 12 * secondNumber;
		if (secondElement.equals("B"))
			fullShellTwo = 6 * secondNumber;
		if (secondElement.equals("N"))
			fullShellTwo = 5 * secondNumber;

		this.shellTotal = fullShellOne + fullShellTwo; // 40

		// # BONDING ELECTRONS AND PAIRS
		int bondingE = shellTotal - valenceTotal; // 8
		this.bondingPairs = bondingE / 2; // 4
		int lonePairs = (valenceTotal - bondingE) / 2; // 12
		
		// # LONE PAIRS
		if ((fullShellOne/firstNumber)-(valenceOne/firstNumber) > (fullShellTwo/secondNumber)-(valenceTwo/secondNumber)){
		 this.lonePairElmtOne = (fullShellOne/2/firstNumber) - (firstNumber + secondNumber -1); // 0
		 this.lonePairElmtTwo = (fullShellTwo/2/secondNumber) - (bondingPairs - (firstNumber + secondNumber -1) / secondNumber); // 3
		}
		else {
		  this.lonePairElmtOne = (fullShellOne/2/firstNumber) - (bondingPairs - (firstNumber + secondNumber -1)/ firstNumber);
		  this.lonePairElmtTwo = (fullShellTwo/2/secondNumber) - (secondNumber + firstNumber -1);
		}
		if (firstNumber == 1 && secondNumber == 1){
			this.eRegions = 2;
		} else {
		this.eRegions = ((fullShellOne/firstNumber)-(valenceOne/firstNumber) > (fullShellTwo/secondNumber)-(valenceTwo/secondNumber)) ? 
				lonePairElmtOne + (firstNumber + secondNumber - 1) : lonePairElmtTwo + (firstNumber + secondNumber - 1); //CENTRAL HBD
		}
	}


	public int getFullShellOne() {
		return fullShellOne;
	}
	public int getFullShellTwo() {
		return fullShellTwo;
	}
	public int getValenceOne() {
		return valenceOne;
	}
	public int getValenceTwo() {
		return valenceTwo;
	}
	public int getLonePairElmtOne() {
		return lonePairElmtOne;
	}
	public int getLonePairElmtTwo() {
		return lonePairElmtTwo;
	}
	public int getERegions() {
		return eRegions;
	}
	public int getBondingPairs() {
		return bondingPairs;
	}
	public int getShellTotal() {
		return shellTotal;
	}
	public int getValenceTotal() {
		return valenceTotal;
	}


	@Override
	public String toString() {
		return "BondTypeCovalent [Sum of full valence shell quantity of first element: " + fullShellOne + ", and second element: " + fullShellTwo 
				+ ".\nNumber of valence electrons in first element : " + valenceOne + ", and in second element=" + valenceTwo 
				+ ".\nNumber of lone pairs in first element: " + lonePairElmtOne + ", and second element=" + lonePairElmtTwo 
				+ ".\nNumber of electron domains: " + eRegions  + ".\nNumber of bonding Pairs: " + bondingPairs 
				+ ".\n Total full valence quantity: " + shellTotal + ", Total Valence Electrons: " + valenceTotal + "]";
	}
	
	
}
