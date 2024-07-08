class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i + 1);
        }
        int start = 0;

        while (arr.size() != 1) {
            System.out.println(arr.get((start + k - 1) % arr.size()));

            int tmp = arr.indexOf(arr.get((start + k - 1) % arr.size()));
            arr.remove(arr.indexOf(arr.get((start + k - 1) % arr.size())));
            start = (tmp) % arr.size();
        }

        return arr.get(0);
    }
}