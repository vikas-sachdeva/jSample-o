package jsample;

/**
 * <pre>
 * 
 * 
 * An activist, of a banned organization, plans to escape from Bhopal jail. 
 * The activist is basically a monkey man and is able to jump across the wall. He practices to cross a wall. 
 * He is able to jump 'X' meters, but because of the slippery wall he falls 'Y' meters after each jump. 
 * To escape from jail, he has to cross 'N' number of walls, where height of each wall is given in an array. 
 * 
 * Write a program to find out the total number of jumps he has make, to escape from the Bhopal jail.
 * 
 * Input Format
 * 		Your function will take three arguments,  where: 
 * 		Argument 1: An integer depicting X
 * 		Argument 2:  An integer depicting Y
 * 		Argument 3: An array of N integers having  the height of each wall
 * 
 * Constraints
 * 		1<= X <=109
 * 		1<= Y <=105
 * 
 * Output Format
 * 		Your program should return total number of jumps required to escape.
 * 
 * Sample Test Cases
 * 
 * Test case 1
 * 	Sample Input
 * 		10
 * 		1
 * 		1
 * 		10  
 * 	Sample Output
 * 		1  
 * 	Explanation
 * 		Here, the activist can jump 10 meters high, but slides down by 1 meter. 
 * 		He has 1 wall to jump and the height of the wall is 10 meters. 
 * 		Since he jumps 10 meters in the first attempt he cross the wall easily in the first attempt only. 
 * 
 * Test case 2
 * 	Sample Input
 * 		5
 * 		1
 * 		2	
 * 		9
 * 		10
 * 	Sample Output
 * 		5
 * 	Explanation
 * 		Here, the activist can jump 5 meters high, but slides down by 1 meters. 
 * 		He has 2 walls to jump and the walls are 9 and 10 meters high respectively. 
 * 		While crossing the first wall, the activist takes 2 attempts because during the first attempt he jumps 5 meters but slides down by 1 meters since he didn't cross the wall. 
 *		In the next attempt he jumps 5 more meters from that position and this time he doesn't slide because he crossed the wall in this attempt because 4+5=9 and 9 meters is the actual height of the wall. 
 *		Similarly, while crossing the second wall, the activist takes 3 attempts because during his second attempt on this wall, he slides down by 1 meters since 4+5=9 and the height of the wall is 10 meters. During his third attempt, Activist was able to escape from Bhopal Jail.
 * 
 * </pre>
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println(GetJumpCount(5, 1, new int[] { 9, 10 }));
	}

	public static int GetJumpCount(int input1, int input2, int[] input3) {
		int totalJumps = 0;
		for (int i = 0; i < input3.length; i++) {
			int temp = input3[i];
			if (temp <= input1) {
				totalJumps += 1;
			} else {
				while (true) {
					temp = temp - input1;
					totalJumps += 1;
					if (temp <= 0) {
						break;
					}
					temp = temp + input2;
				}
			}
		}
		return totalJumps;
	}
}
