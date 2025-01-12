class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList();
        for(int s:students){
            q.add(s);
        }
        for(int i = 0; i < sandwiches.length; i++){
            int left = q.size();
            boolean found = false;
            for(int j = 0; j < left; j++){
                int current = q.remove();
                if(sandwiches[i] == current){
                    found = true;
                    break;
                }
                else{
                    q.add(current);
                }
            }
            if(!found)  return q.size();
        }
        return 0;
    }
}