class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
    HashSet<String> hs = new HashSet<>();
    int max = 0;
    for (int num : arr1) {
        String str = String.valueOf(num);
        for (int i = 1; i <= str.length(); i++) {
            hs.add(str.substring(0, i));
        }
    }
    for (int num : arr2) {
        String str = String.valueOf(num);
        for (int i = 1; i <= str.length(); i++) {
            if (hs.contains(str.substring(0, i))) {
                max = Math.max(max, i);
            }
        }
    }

    return max;
}
}