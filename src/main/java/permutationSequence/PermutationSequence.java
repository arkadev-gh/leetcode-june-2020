package permutationSequence;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    List<Integer> perm;
    List<Integer> result;

    public String getPermutation(int n, int k) {
        k = k - 1;
        perm = new ArrayList<>();
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) perm.add(i);
        generate(k, n);

        StringBuilder sb = new StringBuilder();
        for (Integer i : result) sb.append(i);

        return sb.toString();
    }

    public void generate(int k, int n) {
        if (n == 0) return;

        int factorial = findFactorial(n - 1);
        int index = k / factorial;
        result.add(perm.get(index));
        perm.remove(index);

        generate(k - (index * factorial), n - 1);
    }

    public int findFactorial(int n) {
        if (n == 0) return 1;
        int prod = 1;
        for (int i = 1; i <= n; i++) prod = prod * i;
        return prod;
    }
}
