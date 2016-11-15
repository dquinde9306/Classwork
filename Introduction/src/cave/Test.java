package cave;

public class Test {
	public static String[][]arr2d;
	public static void main(String args[]){
		arr2d = new String[4][4];
		String[] symbol = {"x","v","c"};
		
		
		for(int row= 0; row < arr2d.length;row++){
			
			//in each row, go col by col
			for(int col = 0; col < arr2d[row].length;col++){
				double rand = Math.random();
				int roll = (int) (symbol.length * rand);
				arr2d[row][col] = symbol[roll];
			}
		}
		printPic(arr2d);
	}
	public static void printPic(String[][] pic){
		for(int row = 0; row< pic.length; row++){
			for(int col = 0; col < pic[row].length; col++){
				System.out.print(pic[row][col]);
			}
			System.out.println();
		}
	}
	
	public String[][] swap(int r, int c, String d){
		String temp = null;

		if(d=="w"){
			arr2d[r+1][c] = temp;
			arr2d[r+1][c] = arr2d[r][c];
			arr2d[r][c] = temp;
		}
		if(d=="a"){
			arr2d[r][c-1] = temp;
			arr2d[r][c-1] = arr2d[r][c];
			arr2d[r][c] = temp;
		}
		if(d=="s"){
			arr2d[r-1][c] = temp;
			arr2d[r-1][c] = arr2d[r][c];
			arr2d[r][c] = temp;
		}
		if(d=="d"){
			arr2d[r][c+1] = temp;
			arr2d[r][c+1] = arr2d[r][c];
			arr2d[r][c] = temp;
		}
		
		return arr2d;
		
	}
}
