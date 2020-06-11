package randomPickWeight;

import java.util.Random;

public class RandomPickWeight {
    int[] summedWt;
    int upBound;
    Random generator;

    public RandomPickWeight(int[] w) {
        summedWt = new int[w.length];
        summedWt[0] = w[0];

        for (int i = 0; i < w.length; i++) {
            this.upBound += w[i];
            if (i >= 1) summedWt[i] = w[i] + summedWt[i - 1];
        }

        generator = new Random();
    }

    public int pickIndex() {
        // Generate a random index between 1 and upBound (both inclusive)
        int key = generator.nextInt(upBound) + 1;

        // Search for the key in the sorted summedWt array
        return binSearch(key);
    }

    public int binSearch(int key) {
        int lo = 0;
        int hi = summedWt.length - 1;
        int mid = lo + (hi - lo) / 2;

        while (lo < hi) {
            // If the key belongs to the current bucket
            if (summedWt[mid] == key || (summedWt[mid] > key && mid - 1 >= 0 && summedWt[mid - 1] < key))
                break;

                // If the key belongs to the bucket on the right
            else if (summedWt[mid] < key && summedWt[mid + 1] >= key) {
                mid = mid + 1;
                break;
            }

            // Search in the right half by updating the lo index
            else if (summedWt[mid] < key) lo = mid + 1;

                // Search in the left half by updating the hi index
            else hi = mid - 1;

            // Compute the new mid
            mid = lo + (hi - lo) / 2;
        }

        return mid;
    }
}
