class Solution 
{
    public int subarrayBitwiseORs(int[] arr) 
    {
        ArrayList<Integer> s = new ArrayList<>();
        int l = 0;
        for (int a : arr) 
        {
            int r = s.size();
            s.add(a);
            for (int i = l; i < r; ++i) 
            {
                int v = s.get(i) | a; 
                if (v != s.get(s.size() - 1)) 
                { 
                    s.add(v);
                }
            }
            l = r;
        }
        return new HashSet<>(s).size();
    }
}