public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (C <= E || G <= A || D <= F || H <= B) 
            return area;
        return area - (Math.min(C,G) - Math.max(A,E)) * (Math.min(D,H) - Math.max(B,F));
    }
}