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
        return new int[]{-1, -1};
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

class ThreeSumClosest {
        static int abs(int n) {
            if (n < 0) n = -n;
            return n;
        }

        static public int threeSumClosest(int[] nums, int target) {
            int diff = Integer.MAX_VALUE;

            int start, a, b, c, tempDiff, s;
            int end ;

            Arrays.sort(nums);
            int i = -1;
            while (i++ < nums.length - 2) {
                start = i + 1;
                end = nums.length - 1;
                a = nums[i];

                while (start < end) {
                    b = nums[start];
                    c = nums[end];

                    tempDiff = target - (a + b + c);

                    if (tempDiff == 0) {
                        return target;
                    }

                    if (abs(tempDiff) < abs(diff)) diff = tempDiff;
                    if (tempDiff > 0) {
                        start += 1;
                    } else {
                        end -= 1;
                    }
                }
            }
            return target - diff;
        }
    }

public class NSum {
    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        int target = 82;

        int closest = ThreeSumClosest.threeSumClosest(nums, target);
        System.out.println(closest);
    }
 }
