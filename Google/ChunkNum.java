package Google;

public class ChunkNum {
	public static int chunkNum(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int i = 0, j = s.length() - 1;
		int num = 0;
		while (i <= j) {
			int k = 1;
			while (k <= (j - i + 2) / 2 ) {
				if (s.substring(i, i + k).equals(s.substring(j - k + 1, j + 1))) {
					num++;
					break;
				}
				k++;
			}
			i += k;
			j -= k;
		}
		return num;
	}
	
	public static void main (String args[]){
		ChunkNum cn = new ChunkNum();
		System.out.println(cn.chunkNum("ccabcccccabc"));
	}
}
