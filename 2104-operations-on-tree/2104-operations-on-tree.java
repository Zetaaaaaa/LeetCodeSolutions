class LockingTree {
    int data[];
    boolean check = false;
    HashMap<Integer,Integer> info = new HashMap<>();
    List<List<Integer>> op = new ArrayList<>();
    public LockingTree(int[] parent) {
        data = new int[parent.length];
        for(int i=0;i<parent.length;i++){
            op.add(new ArrayList<>());
            data[i] = parent[i];
        }
        for(int i=1;i<parent.length;i++) op.get(parent[i]).add(i);
    }
    
    public boolean lock(int num, int user) {
        if(info.containsKey(num)) return false;
        info.put(num,user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(!info.containsKey(num)) return false;
        if(info.get(num)!=user) return false;
        info.remove(num);
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        check = false;
        if(info.containsKey(num)) return false;
        dfs1(num);
        if(check) return false;
        dfs(num);
        if(check) info.put(num,user);
        return check;
    }
    public void dfs1(int num){
        if(num==-1) return;
        if(info.containsKey(num)) { check = true;return; }
        dfs1(data[num]);
    }
    public void dfs(int num){
        if(info.containsKey(num)) { check = true; info.remove(num);}
         for(int i:op.get(num)) dfs(i);
    }
}