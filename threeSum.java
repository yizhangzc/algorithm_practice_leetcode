//leetcode/algorithms/15
//author	: yizhangzc
//mail		: yizhangzc@gmail.com
//data		: 2018/5/6

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	List<Integer> nums_list = new LinkedList<Integer>();
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int cur_num;
    	
    	Arrays.sort(nums);
    	
    	for( int i = 0; i < nums.length; i++ ) {
    		cur_num = nums[i];
    		if( map.containsKey(cur_num) ) {
    			map.put(cur_num, map.get(cur_num) + 1 );
    		}
    		else {
    			map.put(cur_num, 1);
    		}
    		
    		if( map.get(cur_num) < 3 ) {
    			nums_list.add(cur_num);
    		}
    	}
    	
    	int target = 0;
    	int target_num = 0;
    	int[] nums_array = nums_list.stream().mapToInt(i->i).toArray();
    	List< Integer > triplet = new ArrayList<Integer>();
    	
    	for( int i = 0; i < nums_array.length && nums_array[i] <= 0 ; i++ ) {
    		if( i >= 1 && nums_array[i] == nums_array[i-1] ) continue;
    		for (int j = i + 1; j < nums_array.length; j++) {
    			if( j > i + 1 && nums_array[j] == nums_array[j-1] ) continue;
    			target = -1 * ( nums_array[i] + nums_array[j] );
    			target_num = 1;
    			if( nums_array[i] == target ) target_num++;
    			if( nums_array[j] == target ) target_num++;
    			
    			if( target >= nums_array[j]
    				&& map.containsKey(target) 
    				&& map.get(target) >= target_num  ) 
    			{
					triplet.clear();
    				triplet.add(nums_array[i]);
    				triplet.add(nums_array[j]);
    				triplet.add(target);
    				list.add( new ArrayList<Integer>( triplet) );
    			}
			}
    	}
    	
    	return list;
    }
}