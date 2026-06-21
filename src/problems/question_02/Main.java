package question_02;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static class Solution {

        public boolean containsDuplicate(int[] nums) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (map.containsKey(nums[i])) {
                    return true;
                }

                map.put(nums[i], i);
            }

            return false;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 1};

        boolean result = solution.containsDuplicate(nums);

        System.out.println(result);
    }
}