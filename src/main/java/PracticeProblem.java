import java.util.*;

public class PracticeProblem {

    public static void main(String args[]) {
        // Test Fibonacci
        System.out.println("Fibonacci:");
        for (int i = 0; i <= 10; i++) {
            System.out.println("F(" + i + ") = " + fib(i));
        }
        
        // Test minCostClimbingStairs
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        
        System.out.println("\nMin cost [10,15,20]: " + minCostClimbingStairs(cost1));
        System.out.println("Min cost [1,100,1,1,1,100,1,1,100,1]: " + minCostClimbingStairs(cost2));
    }
    
    // 1. Fibonacci with memoization
    public static int fib(int num) {
        if (num < 0) return 0; // Handle negative input
        
        // Create memoization array
        int[] memo = new int[num + 2]; // +2 to handle num=0 case
        Arrays.fill(memo, -1); // Initialize with -1 (uncalculated)
        
        return fibHelper(num, memo);
    }
    
    private static int fibHelper(int n, int[] memo) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Check if already calculated
        if (memo[n] != -1) {
            return memo[n];
        }
        
        // Calculate and store in memo
        memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
        return memo[n];
    }
    
    // 2. Minimum cost climbing stairs with memoization
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        
        // Create memoization array
        int[] memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        
        // We can start from step 0 or step 1
        return Math.min(minCostHelper(cost, 0, memo), minCostHelper(cost, 1, memo));
    }
    
    private static int minCostHelper(int[] cost, int step, int[] memo) {
        // Base case: if we're beyond or at the top
        if (step >= cost.length) {
            return 0;
        }
        
        // Check if already calculated
        if (memo[step] != -1) {
            return memo[step];
        }
        
        // Calculate cost for current step + minimum of next steps
        int currentCost = cost[step];
        
        // We can take 1 or 2 steps from current position
        int costWithOneStep = currentCost + minCostHelper(cost, step + 1, memo);
        int costWithTwoSteps = currentCost + minCostHelper(cost, step + 2, memo);
        
        // Store the minimum in memo
        memo[step] = Math.min(costWithOneStep, costWithTwoSteps);
        return memo[step];
    }
}