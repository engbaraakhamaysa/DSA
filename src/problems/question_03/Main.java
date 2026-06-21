package question_03;

import java.util.HashMap;

    class Solution {

        boolean containsNearbyDuplicate(int[] nums, int k) {

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int prevIndex = map.get(nums[i]);

                    if (i - prevIndex <= k) {
                        return true;
                    }

                }
                //HashMap.put(key, value) inserts a new entry if the key is absent, or updates the existing value if the key already exists.
                map.put(nums[i], i);
            }

            return false;
        }
    }

public class Main {


    public static void main(String[] args) {

        Solution solution = new Solution();

        boolean result = solution.containsNearbyDuplicate(new int[] { 1, 2, 3,1,0,0,1,1 }, 1);

        System.err.println(result);
        
    }
    
}
