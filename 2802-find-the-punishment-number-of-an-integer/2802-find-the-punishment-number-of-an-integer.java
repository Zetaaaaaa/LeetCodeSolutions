class Solution {
    public int punishmentNumber(int n) {

        int totalSum = 0;

        for(int i=0; i<=n; i++) {

            int square = (i * i);
            String squareStr = String.valueOf(square);

            if(canPartition(squareStr, i, 0, 0)) {
                totalSum = totalSum + square;
            }
        }

        return totalSum;
    }

    private boolean canPartition(String numStr, int target, int index, int currentSum) {

        if(index == numStr.length()) {
            return currentSum == target;
        }

        int sum = 0;
        for(int i=index; i<numStr.length(); i++) {
            sum = sum * 10 + (numStr.charAt(i) - '0');

            if(sum + currentSum > target)break;

            if(canPartition(numStr, target, i+1, currentSum+sum)) {
                return true;
            }
        }
        return false;
        
    }
}