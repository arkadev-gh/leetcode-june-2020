package queueReconsHeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueReconsHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0] == null || people[0].length == 0)
            return people;

        int[][] queue = new int[people.length][people[0].length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((first, second) -> {
            if (first[0] < second[0]) return 1;
            else if (first[0] > second[0]) return -1;
            else return first[1] - second[1];
        });

        pq.addAll(Arrays.asList(people));

        while (!pq.isEmpty()) {
            int[] individual = pq.poll();
            insert(individual, queue);
        }

        return queue;
    }

    public void insert(int[] individual, int[][] queue) {
        int index = individual[1];
        if (queue[index][0] != 0 && queue.length - 1 - index >= 0)
            System.arraycopy(queue, index, queue, index + 1, queue.length - 1 - index);
        queue[index] = individual;
    }
}
