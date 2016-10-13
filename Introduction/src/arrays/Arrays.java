package arrays;

public class Arrays {

	public static void main(String[] args){
		// this is how you time how quickly a computer processes
		long startTime = System.currentTimeMillis();
		
		String[] someStrings = new String[100];
		populateArray(someStrings);
		
		changeString(someStrings[99]);
		
		printArray(someStrings);
		
		//arrayIntroMethod();
		long endTime = System.currentTimeMillis();
		System.out.println("Completed method in " + (endTime-startTime) + " milliseconds");
		
		
		
		
		
	}  
	
	private static void changeString (String s){
		s = "this string has been changed";
	}
	
	private static void printArray(String[] a) {
		for(String s: a){
			System.out.println(s);
		}
		
		
	}
	private static void populateArray(String[] a) {
		for(int index = 0; index < a.length; index++){
			a[index] = "value " + (index + 1); 
		}
		
		
	}
	public static void arrayIntroMethod() {
		//construct 2 integer arrays
		// these two methods do the same thing
		// primitive type arrays are filled with zeroes 0 0.0 false
		int[] zeros1 = {0,0,0};
		int[] zeros2 = new int[3];

		boolean [] booleans = new boolean[3];
		//iterate (2 ways)
		//WHEN TO USE THIS FOR LOOP
		//  - when the index of the data is important to reference
		//  - you need to customize how you iterate ie by 2 or backwards
		for(int index = 0; index < booleans.length; index++){
			System.out.println(index + ") " + booleans[index]);
		}

		//SECOND METHOD: FOR EACH
		// always goes inorder, does not keep track of index
		// easier to type

		for(boolean b: booleans){
			System.out.println(""+b);
		}

		//these two arrays are different
		String[] strings1 = {"","",""};
		String[] strings2 = new String[3]; 
		
		
		
		// this loop instantiates the array
		for(int index = 0; index < strings2.length; index++){
			strings2[index] = "value " + (index + 1); 
		}
		
		
		
		// prints each array index
		for(String s: strings2){
			System.out.println(s);
		}
	}






















}
