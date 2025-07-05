class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int element = arr[i];
            if(map.containsKey(element)==true){
                map.put(element,map.get(element)+1);
            }else{
                map.put(element, 1);
            }
        }
        int result = -1;
        for(int key : map.keySet()){
            if(map.get(key)==key){
                result= Math.max(result,key);
            }
        }

        return result;

    }
}