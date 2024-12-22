class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int queryCount = queries.length;
        int[][] processedQueries = processQueries(queries, heights);
        int[] results = new int[queryCount];
        int queryIndex = 0;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> searchLimitMap = new HashMap<>();
        HashMap<Integer, Integer> cachedResultsMap = new HashMap<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
                stack.pop();
            }

            Stack<Integer> tempStack = new Stack<>();
            while (queryIndex < queryCount && processedQueries[queryIndex][1] == i) {
                int startHeight = heights[processedQueries[queryIndex][0]];

                if (processedQueries[queryIndex][0] == processedQueries[queryIndex][1]) {
                    results[processedQueries[queryIndex][3]] = processedQueries[queryIndex][0];
                } else if (startHeight < heights[processedQueries[queryIndex][1]]) {
                    results[processedQueries[queryIndex][3]] = processedQueries[queryIndex][1];
                } else {
                    int limit = searchLimitMap.getOrDefault(processedQueries[queryIndex][0], heights.length);
                    int cachedResult = cachedResultsMap.getOrDefault(processedQueries[queryIndex][0], -1);

                    while (!stack.isEmpty() && heights[stack.peek()] <= startHeight && stack.peek() < limit) {
                        tempStack.push(stack.pop());
                    }

                    if (!stack.isEmpty() && heights[stack.peek()] > startHeight) {
                        results[processedQueries[queryIndex][3]] = stack.peek();
                    } else {
                        results[processedQueries[queryIndex][3]] = cachedResult;
                    }
                    cachedResultsMap.put(processedQueries[queryIndex][0], results[processedQueries[queryIndex][3]]);
                }
                searchLimitMap.put(processedQueries[queryIndex][0], processedQueries[queryIndex][1]);
                queryIndex++;
            }

            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }

            if (queryIndex == queryCount) {
                return results;
            }

            stack.push(i);
        }
        return results;
    }

    int[][] processQueries(int[][] queries, int[] heights) {
        int queryCount = queries.length;
        int[][] processedQueries = new int[queryCount][4];
        for (int i = 0; i < queryCount; i++) {
            processedQueries[i][0] = Math.min(queries[i][0], queries[i][1]);
            processedQueries[i][1] = Math.max(queries[i][0], queries[i][1]);
            processedQueries[i][2] = heights[processedQueries[i][0]];
            processedQueries[i][3] = i;
        }
        Arrays.sort(processedQueries, (a, b) -> (a[1] != b[1]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[2], b[2]));
        return processedQueries;
    }
}
