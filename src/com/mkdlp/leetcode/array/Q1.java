package com.mkdlp.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description<>
 * @Author mkdlp
 * @Date 2020/3/3 3:44 下午
 **/
public class Q1 {

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        System.out.println(twoSum(nums,target)[0]+"----"+twoSum(nums,target)[1]);
        System.out.println(hashSum(nums,target)[0]+"----"+hashSum(nums,target)[1]);
        System.out.println(singleHash(nums,target)[0]+"----"+singleHash(nums,target)[1]);

    }

    /**
     * 功能描述 <两边hash表>
     * @author mkdlp
     * @date 2020/3/3
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] hashSum(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int complete=target-nums[i];
            if(map.containsKey(complete) ){
                if(i!=map.get(complete)){
                    return new int[]{i,map.get(complete)};
                }
            }
        }

        return new int[]{};
    }

    /**
     * 功能描述 <一遍hash>
     * @author mkdlp
     * @date 2020/3/3
     * @param
     * @return int[]
     */
    public static int[] singleHash(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer complete=map.get(nums[i]);
            if(complete !=null && complete!=i){
                return new int[]{complete,i};
            }
            map.put(target-nums[i],i);
        }
        return new int[]{};
    }


    /**
     * 功能描述 <暴力解法>
     *     时间复杂度：O(n2)
     *     空间复杂度：O(1)
     * @author mkdlp
     * @date 2020/3/3
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int k=i+1;k<nums.length;k++){
                if((nums[i]+nums[k])==target){
                    result[0]=i;
                    result[1]=k;
                }
            }
        }
        return result;
    }
}
