//leetcode/algorithms/14
//author	: yizhangzc
//mail		: yizhangzc@gmail.com
//data		: 2018/5/5

class longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        
    	StringBuffer prefix = new StringBuffer();
    	
    	int min_len = Integer.MAX_VALUE;
    	if ( strs.length == 0) {
			min_len = 0;
		}
    	for( int j = 0; j < strs.length; j++ ) {
    		if( min_len > strs[j].length() ) {
    			min_len = strs[j].length();
    		}
    	}
    	 	
    	boolean dif_prefix = false;
    	char cur_char = ' ';
    	for( int i = 0; i < min_len && !dif_prefix; i++ ) {
    		
    		cur_char = strs[0].charAt(i);
    		for (int j = 1; j < strs.length; j++) {
				if( strs[j].charAt(i) != cur_char ) {
					dif_prefix = true;
					break;
				}
			}
    		if( !dif_prefix ) prefix.append(cur_char);
    	}

    	return prefix.toString();
    }
}