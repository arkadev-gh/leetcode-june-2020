package isSubSequence;

public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        if (s == t || s == null || s.isEmpty()) return true;
        if (t == null || t.length() < s.length()) return false;

        int i = 0, j = 0;

        while (j < s.length() && i < t.length()) {
            if (s.charAt(j) == t.charAt(i++)) j++;
        }

        return (j == s.length());
    }
}
