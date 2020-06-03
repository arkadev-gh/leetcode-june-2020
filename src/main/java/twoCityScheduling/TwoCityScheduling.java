package twoCityScheduling;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        // Total number of people
        int numPeople = costs.length;

        // Sort the array based on the difference of cost(city_1), cost(city_2)
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] costA, int[] costB) {
                return (costA[0] - costA[1]) - (costB[0] - costB[1]);
            }
        });

        int totalCost = 0;
        // The first half belongs to city A
        for(int i = 0; i < numPeople / 2; i++) totalCost += costs[i][0];

        // The second half belongs to city B
        for(int i = numPeople / 2; i < numPeople; i++) totalCost += costs[i][1];

        return totalCost;
    }
}
