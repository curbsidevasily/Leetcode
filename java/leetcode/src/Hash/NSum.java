package Hash;

import java.util.*;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) return new int[]{-1, -1};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];

            if (map.containsKey(res)) return new int[]{map.get(res), i};
            else map.put(nums[i], i);
        }

    }
}

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        HashSet<Integer> map = new HashSet<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        for (int k: nums) {
            map.add(k);
        }

        for (int i=0; i < nums.length - 3; i++) {
            int a = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int b = nums[start];
                int c = nums[end];

                int sum = a + b + c;
                if (sum == 0) {
                    res.add(Arrays.asList(a, b, c));
                    end -= 1;
                    while (start < end && nums[end-1] == nums[end]) end -= 1;
                } else if (sum > 0) {
                    end -= 1;
                    while (start < end && nums[end-1] == nums[end]) end -= 1;
                }
                else {
                    start += 1;
                    while (start < end && nums[start] == nums[start+1]) start += 1;
                }
            }
        }
        return res;
    }
}


public class NSum {

}
