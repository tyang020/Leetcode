public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x_left = Math.max(A,E);
        int x_right = Math.min(C,G);
        int y_lower = Math.max(B,F);
        int y_upper = Math.min(D,H);
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (x_left >= x_right || y_lower >= y_upper) 
            return area;
        return area - (x_right - x_left) * (y_upper - y_lower);
    }
}