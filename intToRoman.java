//leetcode/algorithms/12
//author	: yizhangzc
//mail		: yizhangzc@gmail.com
//data		: 2018/5/5

class int_to_roman {
    public String intToRoman(int num) {
        
    	int cur_num = num;
    	int pos 	= 0;
    	int tail	= 0;
    	StringBuffer roman_num = new StringBuffer(); 
    	
    	while( cur_num > 0 ) {
    		
    		tail = cur_num % 10;
    		
    		if ( tail <= 3 ) {
				for(int i = 0; i < tail; i++) roman_num.insert(0, alphabet[pos][0]);
			}else if (tail <= 5) {
				roman_num.insert(0, alphabet[pos][1]);
				if (tail == 4) {
					roman_num.insert(0, alphabet[pos][0]);
				}
			}else if (tail <= 8) {
				for( int i = 0; i < ( tail - 5 ); i++ ) roman_num.insert(0, alphabet[pos][0]);
				roman_num.insert(0, alphabet[pos][1]);
			}else {
				roman_num.insert(0, alphabet[pos][2]);
				if (tail == 9) {
					roman_num.insert(0, alphabet[pos][0]);
				}
			}
    		
    		pos ++;
    		cur_num /= 10;
    	}
    	
    	return roman_num.toString();
    }
    
    char[][] alphabet = {
    		{'I','V','X'},
    		{'X','L','C'},
    		{'C','D','M'},
    		{'M','M','M'}
    };
}