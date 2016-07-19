public class Solution {
    /** The idea is similar to unique BST: the operator will divide the input to 2 parts and compute those seperately.
     */
    private Map<String, List<Integer>> map = new HashMap();
    
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '+' && c != '-' && c != '*')
                continue;
            List<Integer> n1 = diffWaysToCompute(input.substring(0, i));
            List<Integer> n2 = diffWaysToCompute(input.substring(i + 1));
            for (Integer c1 : n1) {
                for (Integer c2 : n2) {
                    switch(c) {
                        case '+': 
                            list.add(c1 + c2);
                            break;
                        case '-': 
                            list.add(c1 - c2);
                            break;
                        case '*': 
                            list.add(c1 * c2);
                            break;
                    }
                }
            }
        }
        //If input has not operator
        if (list.isEmpty()) {
            list.add(Integer.valueOf(input));
        }
        
        return list;
    }
}