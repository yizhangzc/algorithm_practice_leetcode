//leetcode/algorithms/13
//author	: yizhangzc
//mail		: yizhangzc@gmail.com
//data		: 2018/5/5


import java.util.Map;
import java.util.HashMap;

class roman_to_int{
    public int romanToInt(String s) {
    	
    	Map<Character, Integer> map = new HashMap<Character, Integer >();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	int int_num = 0;
    	char cur_char;
    	
    	for( int i = 0; i < s.length(); i++ ) {
    		
    		cur_char = s.charAt(i);
    		if( i + 1 < s.length() && 
    			map.get(cur_char) < map.get(s.charAt(i+1)) ){
    			int_num -= map.get(cur_char);
    		}else {
				int_num += map.get(cur_char);
			}
    	}
    	
    	return int_num;
    }
}