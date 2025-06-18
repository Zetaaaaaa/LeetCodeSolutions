class RandomizedSet {
    HashMap<Integer, Integer> indexes;
    ArrayList<Integer> values;
    Random rnd;

    public RandomizedSet() {
        indexes = new HashMap<>();
        values = new ArrayList<>();
        rnd = new Random();
    }
    
    public boolean insert(int val) {
        if(indexes.containsKey(val)) return false;
        indexes.put(val, values.size());
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        Integer pos = indexes.get(val);
        if(pos == null) return false;
        if(pos != values.size()-1){
            int lastValue = values.get(values.size()-1);
            values.set(pos, lastValue);
            indexes.put(lastValue, pos);
        }
        values.remove(values.size()-1);
        indexes.remove(val);
        return true;
    }
    
    public int getRandom() {
        int ind = rnd.nextInt(values.size());
        return values.get(ind);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */