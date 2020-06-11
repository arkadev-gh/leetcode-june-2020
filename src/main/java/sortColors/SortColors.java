package sortColors;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int r = -1, w = -1, b = -1;
        for (int j = 0; j < nums.length; j++) {
            // If the current color is red
            if (nums[j] == 0) {
                r = swap(r + 1, j, nums);
                if (w > -1) w = swap(w + 1, j, nums);
                if (b > -1) b++;
            }

            // If the current color is white
            else if (nums[j] == 1) {
                if (w > -1) w = swap(w + 1, j, nums);
                else w = swap(r + 1, j, nums);
                if (b > -1) b++;
            }

            // If the current color is blue
            else if (nums[j] == 2) {
                if (b > -1) b++;
                else b = j;
            }
        }
    }

    public int swap(int index1, int index2, int[] nums) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
        return index1;
    }
}
