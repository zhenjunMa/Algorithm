import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author 凌风郎少
 * @email mzj911101@yahoo.com
 * @since 2017/9/24
 */
public class MaxSlidingWindow {

    /**
     * 题目链接：https://leetcode.com/problems/sliding-window-maximum/description/
     *
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0){
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        int maxIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){

            //装载元素，把下标小于当前滑动窗口最小下标的元素移除
            if (i > k - 1){
                if (deque.peek() < i - k + 1){
                    deque.poll();
                }
            }

            //每当滑动窗口向右移动一位，即有新元素加入，就把队列中小于该元素的值全部移除
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }

            deque.offer(i);

            //从初始滑动窗口的最后一个元素开始产生计算结果
            if (i >= k - 1){
                result[maxIndex++] = nums[deque.peek()];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,1,2,0,5};
        int k = 3;
        int[] result = MaxSlidingWindow.maxSlidingWindow(array, k);
        System.out.println(Arrays.toString(result));
    }

}