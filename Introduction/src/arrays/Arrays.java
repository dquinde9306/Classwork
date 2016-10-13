package arrays;

public class Arrays {
		  
		  public static void main(String[] args){
		    // this is how you time how quickly a computer processes
		    long startTime = System.currentTimeMillis();
		    arrayIntroMethod();
		    long endTime = System.currentTimeMillis();
		    System.out.println("Completed method in" + (endTime-startTime) + "milliseconds");
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

		    for(String s: strings1){
		      System.out.println(s);
		    }
		  }
		   





















		}
