class Solution {
    public boolean isAnagram(String s, String t) {
        char a1[] = s.toCharArray();
        char a2[] = t.toCharArray();
        //return (new String(Arrays.sort(a1)).equals(new String(Arrays.sort(a2))));
        Arrays.sort(a1);
        Arrays.sort(a2);
        s = new String(a1);
        t = new String(a2);
        return (s.equals(t));
    }
}