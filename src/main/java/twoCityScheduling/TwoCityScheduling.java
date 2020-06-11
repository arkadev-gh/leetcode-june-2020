package twoCityScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        // Total number of people
        int numPeople = costs.length;

        // Sort the array based on the difference of cost(city A), cost(city B)
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] costThis, int[] costOther) {
                return (costThis[0] - costThis[1]) - (costOther[0] - costOther[1]);
            }
        });

        int totalCost = 0;
        // The first half belongs to city A
        for (int i = 0; i < numPeople / 2; i++) totalCost += costs[i][0];

        // The second half belongs to city B
        for (int i = numPeople / 2; i < numPeople; i++) totalCost += costs[i][1];

        return totalCost;
    }
}
