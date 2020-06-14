package insDelGetRandConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    HashMap<Integer, Integer> mainLst;
    List<Integer> randLst;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        mainLst = new HashMap<>();
        randLst = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (mainLst.containsKey(val))
            return false;

        int index = randLst.size();
        randLst.add(val);
        mainLst.put(val, index);

        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!mainLst.containsKey(val))
            return false;

        // Get the index of the current element
        int index = mainLst.get(val);
        int size = randLst.size();

        // Swap the current element with the last element
        int tmp = randLst.get(size - 1);
        randLst.set(size - 1, val);
        randLst.set(index, tmp);

        mainLst.put(tmp, index);

        // Remove the current element
        mainLst.remove(val);
        randLst.remove(size - 1);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(randLst.size());
        return randLst.get(index);
    }
}
