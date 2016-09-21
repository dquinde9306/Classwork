package introUnit;

import java.util.Random;
public class MathRandom {

	public static void main(String[] args) {
		int[] results = new int[6];
		
		int totalRolls = 10000;
		for(int index = 0; index < totalRolls; index++){
			int roll = rollFairDie();
			System.out.println("Roll#" + (index + 1)+ " Die is " + rollUnfairDie());
			results[roll-1]++;
		}
		for(int i = 0; i < 6; i++){
			System.out.println( (i+1) + " was rolled " + (int) (100 * (double)results[i]/totalRolls) + "% times");

		}
	
	}
	
	public static int rollFairDie(){
//		Random gen = new Random();
//		return gen.nextInt(6)+1;
		
		double rand = Math.random();// it creates a random double between zero and one exclusive
		int roll = (int) (6 * rand);// max value is 0 to 5 inclusive
		return roll + 1;// 0 becomes 1, 5 becomes 6
	}
	
	public static int rollUnfairDie(){
		double rand = Math.random();
		int roll = (int) (100 * rand) +1;
		
		if ( roll<= 20 && 0 < roll){
			return 1;
		}
		
		else if ( roll<= 35 && 21 < roll){
			return 2;
		}
		
		else if ( roll<= 50 && 36 < roll){
			return 3;
		}
		
		else if ( roll<=75 && 51 < roll){

			return 4;
		}
		else if ( roll<= 80 && 76 < roll){
			return 5;
		}
		else if ( roll<= 100 && 81 < roll){
			return 6;
		}
		return 10;
	
	}
	
	
	
}
