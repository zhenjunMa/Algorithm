import java.util.HashSet;
import java.util.Set;

/**
 * @author 凌风郎少
 * @email mzj911101@yahoo.com
 * @since 2017/9/27
 */
public class LongestConsecutiveSequence {

    /**
     * 题目：
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     *
     * For example,
     * Given [100, 4, 200, 1, 3, 2],
     * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     *
     * Your algorithm should run in O(n) complexity.
     *
     * 链接：https://leetcode.com/problems/longest-consecutive-sequence/description/
     *
     *
     * 这个题目我一开始的思路是位运算，因为是个int数组，因此所有的数字也就是-21亿~21亿左右，
     * 想创建42亿/8个byte，然后遍历数组，把byte中对应位置变为1，遍历一遍数组以后再遍历一次
     * byte数组，找最长的连续1的子串求长度即可，但是这个思路在处理所有int值尤其是由负数的时候
     * 非常难实现，最终放弃这个思路。
     *
     * 看了leetCode上的别人的思路才意识到实现O(n)时间复杂度的一种思路就是hash
     *
     */

    public static int longestConsecutive(int[] nums) {
        int maxLength = 0;
        Set<Integer> uniqNumSet = new HashSet<Integer>();
        for(int num : nums){
            uniqNumSet.add(num);
        }
        for(int num : nums){
            int length = 1;
            int lower = num - 1;
            int bigger = num + 1;
            while(uniqNumSet.remove(lower)){
                lower--;
                length++;
            }
            while(uniqNumSet.remove(bigger)){
                bigger++;
                length++;
            }
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] a = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(a));
    }

}