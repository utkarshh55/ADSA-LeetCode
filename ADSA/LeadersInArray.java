package ADSA;

public class LeadersInArray {
    public static void printLeaders(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n]; // to store leaders temporarily
        int index = 0;

        // Rightmost element is always a leader
        int maxFromRight = nums[n - 1];
        temp[index++] = maxFromRight;

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > maxFromRight) {
                maxFromRight = nums[i];
                temp[index++] = maxFromRight;
            }
        }

        // Leaders were stored in reverse order, print them in correct order
        for (int i = index - 1; i >= 0; i--) {
            System.out.print(temp[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        printLeaders(arr); // Output: 17 5 2
    }
}

