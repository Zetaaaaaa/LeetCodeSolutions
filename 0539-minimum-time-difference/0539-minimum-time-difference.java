class Solution {
    public int findMinDifference(List<String> t) {
        int[] arr = new int[t.size()];
        
        for (int i = 0; i < t.size(); i++) {
            String time = t.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3, 5));
            arr[i] = h * 60 + m;
        }
        
        Arrays.sort(arr);
        
        int min = arr[arr.length-1];
        
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        
        min = Math.min(min, (1440 - arr[arr.length - 1] + arr[0]));
        
        return min;
    }
}