class Solution {
  public int minHeightShelves(int[][] books, int shelf_width) {
    int n = books.length;
    Integer[] dp = new Integer[n];
    return stack(books, shelf_width, 0, dp);
  }
  
  public int stack(int[][] books, int shelfWidth, int start, Integer[] dp) {
    if(start >= books.length) return 0;
    if(dp[start] != null) return dp[start];
    
    int cumulativeWidth = 0;
    int rowHeight = 0;
    Integer totalHeight = Integer.MAX_VALUE;
    
    for(int i = start; i < books.length; i++) {
      int[] book = books[i];
      int w = book[0];
      int h = book[1];
      cumulativeWidth += w;
      if(cumulativeWidth > shelfWidth) break;
      
      int res = stack(books, shelfWidth, i+1, dp);
      rowHeight = Math.max(rowHeight, h);
	  
      if(res + rowHeight < totalHeight) {
        totalHeight = res + rowHeight;
      }
    }
    
    dp[start] = totalHeight;
    return totalHeight;
  }
}