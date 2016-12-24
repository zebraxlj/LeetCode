package src;

public class ReverseInteger {
	public int reverse(int x) {
        int tail = 0;
        int ret = 0;
        while(x != 0){
            tail = x % 10;
            int old = ret;
            ret = ret * 10 + tail;
            if ((ret - tail)/10 != old){return 0;}
//            System.out.println(ret);
            x /= 10;
        }
        return ret;
    }
	public static void main(String[] args){
		ReverseInteger sol = new ReverseInteger();
		System.out.println("-123 " + sol.reverse(-123));
		System.out.println("1534236469 " + sol.reverse(1534236469));
	}
}
