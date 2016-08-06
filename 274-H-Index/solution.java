public class Solution {
    public int hIndex(int[] citations) {
        // The largest h-index would be no more than the length of citations.
        // Build an arry to save the number of each citation number; if the citation number is larger than the length, save it to the last position.
        int length = citations.length;
        int[] sortedCit = new int[length+1]; // The index is citation number and the value is the number of citation number.
        for (int n : citations) {
            if (n >= length)
                sortedCit[length]++;
            sortedCit[n]++;
        }
        
        // From the end to the start, add these values, the sum would be the number of papers which have more than i(index) citations.
        
        int hIndex = 0;
        for (int i = length; i > 0; i--) {
            hIndex += sortedCit[i];
            if (hIndex >= i)
                return i;
        }
        return 0;
    }
}