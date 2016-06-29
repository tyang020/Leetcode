public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        //div is used for getting the 1st digit.
        int div = 1;
        while(x/div/10 != 0) {
            div *= 10;
        }
        while (x != 0) {
            int fir = x / div; //get the first digit
            int las = x % 10; // get the last digit
            if (fir != las) 
                return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}