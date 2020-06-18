package hIndex2;

public class HIndex2 {
    int[] citations;

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0 || citations[citations.length - 1] == 0) return 0;
        if (citations[0] >= citations.length) return citations.length;
        this.citations = citations;
        return citations.length - binSearch();
    }

    public int binSearch() {
        int lo = 0, hi = citations.length - 1;
        int index = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] >= citations.length - mid && citations[mid - 1] <= citations.length - mid) {
                index = mid;
                break;
            }

            if (citations[mid] < citations.length - mid) lo = mid + 1;
            else if (citations[mid - 1] > citations.length - mid) hi = mid - 1;
        }

        return index;
    }
}
