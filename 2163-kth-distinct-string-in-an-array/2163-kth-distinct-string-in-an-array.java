class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map =  new HashMap<>();
        ArrayList<String> order = new ArrayList<>();
        for(String s : arr){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for(String s : arr){
            if(map.get(s) == 1){
                order.add(s);
            }
        }
        if(order.size() < k){
            return "";
        }
        return order.get(k-1);
    }
}