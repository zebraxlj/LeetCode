package src;

public class StringtoInteger {
	public int myAtoi2(String str) {
		int ret = 0;
		int start = 0;
		if(str.length() == 0){return 0;}
		while(str.charAt(start) == ' '){
			++start;
		}
		if(str.charAt(start)!='+' && str.charAt(start)!='-' && !Character.isDigit(str.charAt(start))){
			return 0;
		}
		int end = start + 1;
		while(end < str.length() && Character.isDigit(str.charAt(end))){
			++end;
		}
		String sub = str.substring(start, end);
		try{
			ret = Integer.parseInt(sub);
		}catch(NumberFormatException e){
			System.err.println(e + " " + sub);
			System.out.println("here" + sub.length());
			if(sub.length() <= 1){return 0;}
			if(sub.charAt(0) == '-'){
				return Integer.MIN_VALUE;
			}else{
				return Integer.MAX_VALUE;
			}
		}
		return ret;
	}
	public int myAtoi(String str){
		if(str.length() == 0) return 0;
		
		int l = 0;
		while(str.charAt(l) == ' '){
			++l;
		}
		
		int sign = 1;
		if (str.charAt(l) == '-'){
			sign = -1;
			++l;
		}else if(str.charAt(l) == '+'){
			sign = 1;
			++l;
		}
		int digit = 0, val = 0;
		while(l < str.length() && Character.isDigit(str.charAt(l))){
			digit = str.charAt(l) - '0';
			if(digit < 0 || digit > 9) break;
			if(val > (Integer.MAX_VALUE - digit) / 10){
				if(sign == 1) return Integer.MAX_VALUE;
				return Integer.MIN_VALUE;
			}
			val = 10 * val + digit;
			++l;
		}		
		return sign * val;
	}
    public int myAtoi1(String str) {
        long ret = 0;
        try{
        	int start;
        	for(start = 0; start < str.length(); ++start){
        		if(str.charAt(start) != ' ') break;
        	}
        	int end;
        	for(end = start+1; end < str.length(); ++end){
        		if(!Character.isDigit(str.charAt(end)))	break;
        	}
        	System.out.println(start + " " + end);
        	String tmp = str.substring(start, end);
        	System.out.println("|"+tmp+"|");
            ret = Long.parseLong(tmp);
            System.out.println(ret);
        }catch (Exception e){
            System.err.println(e);
            return 0;
        }
        if(ret > Integer.MAX_VALUE)
        	return Integer.MAX_VALUE;
        else if(ret < Integer.MIN_VALUE)
        	return Integer.MIN_VALUE;
        return (int) ret;
    }
    public static void main(String[] args){
    	StringtoInteger sol = new StringtoInteger();
    	System.out.println("" + sol.myAtoi(""));
    	System.out.println("\"   010\" " + sol.myAtoi("   010"));
    	System.out.println("\"010\" " + sol.myAtoi("010"));
    	System.out.println("\"2147483648\" " + sol.myAtoi("2147483648"));
    	System.out.println("\"9223372036854775809\" " + sol.myAtoi("9223372036854775809"));
    }
}
