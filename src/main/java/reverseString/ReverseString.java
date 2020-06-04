package reverseString;

public class ReverseString {
    public void reverseString(char[] s) {
        if(s == null || s.length <= 1)
            return;

        for(int lo = 0, hi = s.length - 1; lo < hi; ++lo, --hi) {
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
        }
    }
}
