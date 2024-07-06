class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int rect1 = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
        int rect2 = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
        int loo = Math.max(ax1, bx1);
        int roo = Math.min(ax2, bx2);
        int boo = Math.max(ay1, by1);
        int too = Math.min(ay2, by2);
        int area = 0;
        if (roo > loo && too > boo) {
            area = (roo - loo) * (too - boo);
        
        }
        return rect1  + rect2 - area;
    }
}