public class Solution {
    /** The idea is similar to unique BST: the operator will divide the input to 2 parts and compute those seperately.
     *  Without map: 9ms; with map 11ms;
     */
    private Map<String, List<Integer>> map = new HashMap();
    
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input))
            return map.get(input);
            
        List<Integer> list = new ArrayList();
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '+' && c != '-' && c != '*')
                continue;
            String s1 = input.substring(0, i);
            String s2 = input.substring(i + 1);
            // Without map:
            List<Integer> n1 = diffWaysToCompute(s1);
            List<Integer> n2 = diffWaysToCompute(s2);
            
            //List<Integer> n1 = map.getOrDefault(s1, diffWaysToCompute(s1));
            //List<Integer> n2 = map.getOrDefault(s2, diffWaysToCompute(s2));
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
        
        map.put(input, list);
        
        return list;
    }
}