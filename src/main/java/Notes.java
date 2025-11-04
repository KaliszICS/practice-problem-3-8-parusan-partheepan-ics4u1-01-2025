import java.util.*;

class Notes {
	public static void main(String[] args) {

	}

	public static int fib(int num) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		return fibHelper(num, map);
	}

	public static int fibHelper(int num, HashMap<Integer, Integer> map) {

		//base cases

		//check the map - does the value already with a solution

		//recursive call

		//add to map - add that solution to the map

		//return
		return 0;
	}

	public static int dfsStack(String[][] arr) {

		Stack<int[]> stack = new Stack<int[]>();

		stack.push(new int[]{arr.length - 1, 0, 0}); //push adds a value to the stack at the top

		int smallest = Integer.MAX_VALUE; //setting this to the highest value

		while(!(stack.empty())) {
			int[] top = stack.pop(); //take the top value of the stack, remove it and return it.

			if (arr[top[0]][top[1]].equals("F")) {
				if (top[2] < smallest) {
					smallest = top[2];
				}
			}

			//Try to go right, and try to go up

			//Up - decrease the value of the row by 1 - the row is the first index of our array
			if (top[0] > 0) {
				stack.push(new int[]{top[0] - 1, top[1], top[2] + 1});
			}

			//Right - incrase the value of the column by 1 - the col is the second index of our array

			if (top[1] < arr.length - 1) {
				stack.push(new int[]{top[0], top[1] + 1, top[2] + 1});
			}
			
		}
		return smallest;
	}

	public static int bfsQueue(String[][] arr) {

		//Change to a queue
		Stack<int[]> stack = new Stack<int[]>();
		Queue<int[]> queue = new LinkedList<int[]>();

		//Use queue version of push - queue.add()
		stack.push(new int[]{arr.length - 1, 0, 0}); 

		int smallest = Integer.MAX_VALUE; 

		while(!(stack.empty())) { //check the size queue.size() > 0
			int[] top = stack.pop(); //Use queue version of pop - queue.remove()

			if (arr[top[0]][top[1]].equals("F")) {
				if (top[2] < smallest) {
					smallest = top[2];
				}
			}

			//visited elements in the 2d array - change to wall

			
			if (top[0] > 0) {
				stack.push(new int[]{top[0] - 1, top[1], top[2] + 1}); //change to add
			}

			if (top[1] < arr.length - 1) {
				stack.push(new int[]{top[0], top[1] + 1, top[2] + 1}); //change to add
			}
			
		}
		return smallest;
	}

}
