class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int i = 0;
        int count = 0;

        while (i < arr.length) {
            int j = i + 1;
            while (j < arr.length) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    int k = j + 1;
                    while (k < arr.length) {
                        if (Math.abs(arr[j] - arr[k]) <= b &&
                            Math.abs(arr[i] - arr[k]) <= c) {
                            count++;
                        }
                        k++;
                    }
                }
                j++;
            }
            i++; 
        }

        return count;
    }
}