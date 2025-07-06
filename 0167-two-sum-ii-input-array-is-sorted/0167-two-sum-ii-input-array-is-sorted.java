class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0, end = numbers.length - 1;

        while(first < end){
            if(numbers[first] + numbers[end] == target) return new int[]{first + 1, end + 1};

            else if(numbers[first] + numbers[end] < target) first++;
            else if(numbers[first] + numbers[end] > target) end--;
        }
        return new int[]{};
    }
}