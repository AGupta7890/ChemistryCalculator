package xCR;

public class Element {
	
	private String firstElement;
	private String secondElement;
	private String secondPoly;
	private int firstNumber;
	private int secondNumber;
	String inputCompound;
	private int capitalIndex;
	
	//public static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public Element(String inputCompound) {
		//C2H4
		this.inputCompound = inputCompound;
		if (inputCompound.length() == 2 && !Character.isDigit(inputCompound.charAt(0)) && !Character.isDigit(inputCompound.charAt(1)) && Character.isUpperCase(inputCompound.charAt(1))) {
			this.firstElement = inputCompound.substring(0, 1);
			this.secondElement = inputCompound.substring(1);
			this.firstNumber = 1;
			this.secondNumber = 1;
		}
		else if(inputCompound.length() == 2 && !Character.isDigit(inputCompound.charAt(0)) && !Character.isDigit(inputCompound.charAt(1)) && Character.isLowerCase(inputCompound.charAt(1))){
			this.firstElement = inputCompound;
			this.firstNumber = 1;
			this.secondElement = "H";
			this.secondNumber = 1;
		}
		else if(inputCompound.length() == 2 && Character.isDigit(inputCompound.charAt(1))) {
			this.firstElement = inputCompound.substring(0, 1);
			this.secondElement = "H";
			this.firstNumber = Integer.parseInt(inputCompound.substring(1));
			this.secondNumber = 1;
		}
		else if(inputCompound.length() == 1){
			this.firstElement = inputCompound;
			this.secondElement = "H";
			this.firstNumber = 1;
			this.secondNumber = 1;
		}
		else {
		int i = 1;
		while (i < inputCompound.length() && (Character.isLowerCase(inputCompound.charAt(i)) || Character.isDigit(inputCompound.charAt(i)))) i++; // 2
		
		this.capitalIndex = i;
		String firstHalf = inputCompound.substring(0, capitalIndex);  //C2
		String secondHalf = inputCompound.substring(capitalIndex);    //H4
		
		int n = 0;
		while (n < firstHalf.length() && Character.isLetter(firstHalf.charAt(n))) n++;
		try {
		this.firstElement = firstHalf.substring(0,  n);
		this.firstNumber = Integer.parseInt(firstHalf.substring(n));
		} catch(StringIndexOutOfBoundsException | NumberFormatException e) {
			this.firstElement = firstHalf;
			this.firstNumber = 1;
		}finally{}
		
		int m = 0;
		while (m < secondHalf.length() &&( Character.isLetter(secondHalf.charAt(m)) || !Character.isDigit(secondHalf.charAt(m)))) m++;
		try {
		this.secondElement = secondHalf.substring(0,  m);
		this.secondNumber = Integer.parseInt(secondHalf.substring(m));
		}catch (StringIndexOutOfBoundsException | NumberFormatException e) {
			this.secondElement = secondHalf;
			this.secondNumber = 1;
		}finally {}
	 }
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
	public int getCapital() {
		return capitalIndex;
	}
	@Override
	public String toString() {
		return "Element [firstElement=" + firstElement + ", secondElement=" + secondElement + ", firstNumber="
				+ firstNumber + ", secondNumber=" + secondNumber + "]";
	}
}
