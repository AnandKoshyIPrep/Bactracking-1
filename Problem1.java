// Time Complexity: O(N ^ (N / M)) M is the minimum value in numList
// Space Complexity:  O(N / K) K is the minimum value in the num_list
// Passed Leetcode
// Problems identifying space and time complexity

class Solution {
    List<List<Integer>> output;
    int[] array;
    public void helper(int target, int startIndex, List<Integer> numList) {
        if (target == 0) {
            // System.out.println(numList);
            
            output.add(new ArrayList<>(numList));
            // System.out.println(output);
            
            numList.remove(numList.size() - 1);
            
            return;
        }
        
        if (target < 0) {
            numList.remove(numList.size() - 1);
            
            return;
        }
        
        
        for(int i = startIndex; i < array.length; i++) {
            
            numList.add(array[i]);
            helper(target - array[i], i, numList);
            
        }
        
        if (numList.size() > 0) {
            numList.remove(numList.size() - 1);
            
        }
        
        
    }
    
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        output = new ArrayList<List<Integer>>();
        array = candidates;
        helper(target, 0, new ArrayList<>());
        
        return output;
    }
}