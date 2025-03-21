class Solution {

	HashMap<String, List<String>> recipeMap;
    HashSet<String> supp;
    
    HashMap<String, Boolean> possibleRecipes;
    List<String> ans;
    
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        recipeMap = new HashMap<>();
        supp = new HashSet<>(Arrays.asList(supplies));
        
        //Memoization to avoid solving same subproblem again
        possibleRecipes = new HashMap<>();
        ans = new LinkedList<>();
        
        //populate hashmap with recipe as key and list of ingredients as value.
        for(int i=0;i< recipes.length; i++){
            recipeMap.put(recipes[i], new LinkedList<>());
            
            for(String ing : ingredients.get(i)){
                //no need to add supplies to the list, because they don't cause loops while dfs
                if(supp.contains(ing))
                    continue;
                recipeMap.get(recipes[i]).add(ing);
            }
        }
        
        for(String recipe : recipes){
            dfs(recipe, new HashSet<String>());
        }
        
        return ans;
    }
    
    boolean dfs(String recipe, HashSet<String> seen){
        
        if(seen.contains(recipe))
            return false;
        
        if(!recipeMap.containsKey(recipe)){
            return false;
        }
        
        if(possibleRecipes.containsKey(recipe))
            return possibleRecipes.get(recipe);
        
        for(String ing : recipeMap.get(recipe)){
            seen.add(recipe);
            boolean resp = dfs(ing, seen);
            seen.remove(recipe);
            if(!resp){
                possibleRecipes.put(recipe, false);
                return false;
            }
        }
        possibleRecipes.put(recipe, true);
        ans.add(recipe);
        return true;
    }
}