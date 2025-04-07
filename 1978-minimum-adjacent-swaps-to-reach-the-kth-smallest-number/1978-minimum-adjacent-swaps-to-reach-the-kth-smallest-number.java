class Solution {
    public int getMinSwaps(String num, int k) {
        int[] nums = new int[num.length()];
        int[] original = new int[num.length()];
        int index = 0;

        for (char ch : num.toCharArray()) {
            nums[index] = ch - '0';
            original[index++] = ch - '0';
        }

        while (k-- > 0) {
            nextPermutation(nums);
        }
        int ans = 0;

        for (int i = 0; i < num.length(); i++) {
            // Meaning swap happened    
            if (nums[i] != original[i]) {
                int anchor = i;
                
                while (nums[anchor] != original[i]) {
                    anchor++;
                }
                while (anchor > i) {
                    swap(nums, anchor, anchor - 1);
                    ans++;
                    anchor--;
                }       
            }
        }
        return ans;
    }
    private void nextPermutation(int[] arr) {
        int index = arr.length - 2;

        while (index >= 0 && arr[index] >= arr[index + 1]) {
            index--;
        }
        int justGreaterThanEqualToIndex = binarySearchJustGreaterThanEqualTo(arr, index + 1, arr[index]);
        swap(arr, index, justGreaterThanEqualToIndex);
        reverse(arr, index + 1);
    }

    private int binarySearchJustGreaterThanEqualTo(int[] arr, int index, int target) {
        int lo = index;
        int hi = arr.length - 1;
        int ans = index;

        while (lo <= hi) {
            int pivot = lo + (hi - lo) / 2;

            if(arr[pivot] > target) {
                ans = pivot;
                lo = pivot + 1;
            } else {
                hi = pivot - 1;
            }
        }
        return ans;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void reverse(int[] arr, int index) {
        int eIndex = arr.length - 1;

        while (index < eIndex) {
            swap(arr, index++, eIndex--);
        }
    }
}