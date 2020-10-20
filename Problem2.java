// Time Complexity: O(N ^ 3)
// Space Complexity: O(N) For the recursion stack
// Did not pass leetcode 
// Did not handle the case where you have to first multiply before adding and subtracting

class Solution {
    List<String> output;
    
    public void helper(String num, int index, int res, List<String> outStr, int target) {
        
        if (index == num.length()) {
            if (res == target) {
                output.add(String.join("", outStr));
            }
            outStr.remove(outStr.size() - 1);
            outStr.remove(outStr.size() - 1);
            return;
        }
        int v1, v2;
        boolean isFirst = false;
        if (res == Integer.MAX_VALUE) {
            v1 = Character.getNumericValue(num.charAt(index));
            v2 = Character.getNumericValue(num.charAt(index + 1));
            index += 2;
            isFirst = true;
        } else {
            v1 = res;
            v2 = Character.getNumericValue(num.charAt(index));
            index++;
        }
        
        if (isFirst) {
            outStr.add(String.valueOf(v1));
        }
        for (int i = 0; i < 3; i++) {
            int temp;
            String opr;
            if (i == 0) {
                temp = v1 + v2;
                opr = "+";
            } else if(i == 1) {
                temp = v1 - v2;
                opr = "-";
                
            } else{
                temp = v1 * v2;
                opr = "*";
                
            }
            
            outStr.add(opr);
            outStr.add(String.valueOf(v2));
            helper(num, index, temp, outStr, target);
    
        }
 
        outStr.remove(outStr.size() - 1);
        
        if (outStr.size() > 0) {
            outStr.remove(outStr.size() - 1);    
        }
        
        
    }
    
    public List<String> addOperators(String num, int target) {
        target = target;
        output = new ArrayList<>();
        helper(num, 0, Integer.MAX_VALUE, new ArrayList<>(), target);
        return output;
    }
}