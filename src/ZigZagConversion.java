package src;
import java.util.ArrayList;
import java.util.Arrays;

public class ZigZagConversion {
	public String convert1(String s, int numRows) {
		StringBuilder temp = new StringBuilder();
		int idx;
		for(int i=0; i<numRows; ++i){
			idx = i;
			while(idx < s.length()){
				temp.append(s.charAt(idx));
				System.out.println(s.charAt(idx));
				idx += 2 * numRows - 2*(i+1);
				temp.append(s.charAt(idx));
				System.out.println(s.charAt(idx));
				idx += numRows % (i+1);
			}
		}
		return temp.toString();
	}
	public String convert2(String s, int numRows) {
		String ret;
		ArrayList<StringBuilder> temp = new ArrayList<StringBuilder>();
		for(int i=0; i<numRows; ++i){

		}
		return "";
	}
	// Memory space : O(n), no extra space used besides the return 
	// However it's too slow to compute and check the index
	public String convert(String s, int numRows){
		if(numRows == 1)
			return s;
		StringBuilder temp = new StringBuilder();
		int[] rowOneIdxes = new int[1 + (int) Math.ceil(1.0 * s.length() / 2 / (numRows-1))];
		for(int i=0; i<rowOneIdxes.length; ++i){
			rowOneIdxes[i] = i * 2 * (numRows - 1);
		}
		System.out.println(Arrays.toString(rowOneIdxes));
		int idx;
		for(int j=0; j<rowOneIdxes.length; ++j){
			if(rowOneIdxes[j] >= s.length())
				break;
			temp.append(s.charAt(rowOneIdxes[j]));
		}
		for(int i=1; i<numRows-1; ++i){
			idx = rowOneIdxes[0];
			for(int j=0; j<rowOneIdxes.length; ++j){
				if((rowOneIdxes[j]-i) > 0 && (rowOneIdxes[j]-i) < s.length())
					temp.append(s.charAt(rowOneIdxes[j] - i));
				if((rowOneIdxes[j]+i) < s.length()){
					temp.append(s.charAt(rowOneIdxes[j] + i));
					System.out.println(s.charAt(rowOneIdxes[j] + i));
				}
			}
		}
		for(int j=0; j<rowOneIdxes.length; ++j){
			if((rowOneIdxes[j] + numRows - 1) < s.length())
				temp.append(s.charAt(rowOneIdxes[j] + numRows - 1));
		}
		return temp.toString();
	}
    public String topSolusion(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

	public static void main(String[] args){
		ZigZagConversion sol = new ZigZagConversion();
//		System.out.println(sol.convert("abcdefghijklmnopqrstuvwxyz", 5));
		System.out.println(sol.convert("", 1));
		System.out.println(sol.convert("AB", 2));
		System.out.println(sol.convert("ABCDE", 4));

	}
}
