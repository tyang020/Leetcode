public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 1. If A cannot reach B(B is the first station A cannot reach), any station between A and B cannot reach B.
        //    Then get a new travel starting from B+1;
        // 2. After traveling all the stations, if total sum >= 0, we can find the start station s which can reach the last station.
        //    Else we cannot find a starting station, return -1
        int start = 0, cur_sum = 0, total_sum = 0;
        for (int i = 0; i < gas.length; i++) {
            total_sum += gas[i] - cost[i];
            cur_sum += gas[i] - cost[i];
            
            if (cur_sum < 0) {
                cur_sum = 0;
                start = i+1;
            }
        }
        return total_sum >= 0 ? start : -1;
    }
}