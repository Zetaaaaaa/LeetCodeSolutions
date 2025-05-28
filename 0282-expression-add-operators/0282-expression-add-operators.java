class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> targetExpressions = new ArrayList<>();
        findAllSplits(num, target, 0, new ArrayList<>(), targetExpressions);
        return targetExpressions;
    }

    private void findAllSplits(String num, int target, int i, List<Long> currSplit, List<String> targetExpressions) {
        if (i == num.length()) {
            generateExpressions(num, target, currSplit, 0, new ArrayList<>(), 0, 0, targetExpressions);
            return;
        }

        for (int j = i; j < num.length(); j++) {
            if (j > i && num.charAt(i) == '0') break;
            long value = Long.parseLong(num.substring(i, j + 1));
            currSplit.add(value);
            findAllSplits(num, target, j + 1, currSplit, targetExpressions);
            currSplit.remove(currSplit.size() - 1);
        }
    }

    private void generateExpressions(String num, int target, List<Long> nums, int i, List<Object> currExpr,
                                     long result, long prev, List<String> targetExpressions) {
        char prevOp = '+';
        if (!currExpr.isEmpty()) {
            Object last = currExpr.get(currExpr.size() - 1);
            if (last instanceof Character) {
                prevOp = (char) last;
            }
        }

        if (prevOp == '+') {
            result += prev;
            prev = nums.get(i);
        } else if (prevOp == '-') {
            result += prev;
            prev = -nums.get(i);
        } else {
            prev *= nums.get(i);
        }

        if (i == nums.size() - 1) {
            if (result + prev == target) {
                List<Object> finalExpr = new ArrayList<>(currExpr);
                finalExpr.add(nums.get(i));
                StringBuilder sb = new StringBuilder();
                for (Object obj : finalExpr) {
                    sb.append(obj.toString());
                }
                targetExpressions.add(sb.toString());
            }
        } else {
            List<Object> plusExpr = new ArrayList<>(currExpr);
            plusExpr.add(nums.get(i));
            plusExpr.add('+');
            generateExpressions(num, target, nums, i + 1, plusExpr, result, prev, targetExpressions);

            List<Object> minusExpr = new ArrayList<>(currExpr);
            minusExpr.add(nums.get(i));
            minusExpr.add('-');
            generateExpressions(num, target, nums, i + 1, minusExpr, result, prev, targetExpressions);

            List<Object> multExpr = new ArrayList<>(currExpr);
            multExpr.add(nums.get(i));
            multExpr.add('*');
            generateExpressions(num, target, nums, i + 1, multExpr, result, prev, targetExpressions);
        }
    }
}
