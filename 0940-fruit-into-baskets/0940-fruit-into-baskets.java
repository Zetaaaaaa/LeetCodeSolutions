class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        while(right < fruits.length) {
            int fruit = fruits[right];
            map.put(fruit, right);
            if(map.size() > 2) {
                int index = Integer.MAX_VALUE;
                int type = -1;
                for(int fruitType : map.keySet()) {
                    int curIndex = map.get(fruitType);
                    if(curIndex < index) {
                        index = curIndex;
                        type = fruitType;
                    }
                }
                map.remove(type);
                left = index + 1;
            }
            total = Math.max(total, right - left + 1);
            right++;
        }
        return total;
    }
}