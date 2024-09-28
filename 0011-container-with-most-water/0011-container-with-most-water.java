class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while(left < right){
            int width = right - left;
            int curr = Math.min(height[left], height[right]);
            int ar = curr * width;
            area = Math.max(area,ar);
            if(height[left] < height[right])    left++;
            else    right--;
        }
        return area;
    }
}