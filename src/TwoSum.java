package src;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        int[] nums = {2,4,3};
        int target = 6;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.approach_1(nums, target)));
        System.out.println(Arrays.toString(sol.approach_2(nums, target)));
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target){
        return approach_1(nums, target);
    }

    // brute force
    public int[] approach_1(int[] nums, int target) {
        int[] ret = new int[2];
        for(int i=0; i<nums.length; ++i){
            for(int j=i+1; j<nums.length; ++j){
                if(nums[i]+nums[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                }
            }
        }
        return ret;
    }

    // binary search
    public static int binarySearch(int[] a, int key){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi-lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    // This is not working because nums changed.
    public int[] bad_approach(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        int[] ret = new int[2];
        for(int i=0; i<nums.length; ++i){
            int key = target - nums[i];
            int idx = binarySearch(nums, key);
            if (idx != -1){
                System.out.println(nums[i] + " " +nums[idx]);
                System.out.println(i + " " + idx);
                ret[0] = i;
                ret[1] = idx;
                break;
            }
        }
        return ret;
    }

    // hash map
    public int[] approach_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
