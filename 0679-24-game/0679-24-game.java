class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int c : cards) nums.add((double)c);
        return solve(nums);
    }

    private boolean solve(List<Double> nums) {
        int n = nums.size();
        if (n == 1) return Math.abs(nums.get(0) - 24.0) < 1e-6;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) next.add(nums.get(k));
                }

                double a = nums.get(i), b = nums.get(j);
                double[] candidates = {a+b, a-b, b-a, a*b};
                if (Math.abs(b) > 1e-6) candidates = append(candidates, a/b);
                if (Math.abs(a) > 1e-6) candidates = append(candidates, b/a);

                for (double val : candidates) {
                    next.add(val);
                    if (solve(next)) return true;
                    next.remove(next.size()-1);
                }
            }
        }
        return false;
    }

    private double[] append(double[] arr, double val) {
        double[] newArr = new double[arr.length+1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = val;
        return newArr;
    }
}