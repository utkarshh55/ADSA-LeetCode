package ADSA;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int lastNonZero = 0; // position to place next non-zero element

        // Move all non-zero elements forward
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[lastNonZero] = nums[i];
                lastNonZero++;
            }
        }

        // Fill remaining places with zero
        for (int i = lastNonZero; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0
    }
}

