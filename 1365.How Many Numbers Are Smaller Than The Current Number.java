import java.util.Arrays;

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = firstIndex(sorted, nums[i]);
        }

        return result;
    }

    private int firstIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
