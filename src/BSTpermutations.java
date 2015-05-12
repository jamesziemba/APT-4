import java.util.HashMap;

public class BSTpermutations {
	public long howMany(int[] values) {
		long n = values.length;
		return count(n); //since only n matters
	}
	
	long[] memo = new long[22];
	public long count(long n){ // recursive method
		int help = (int) n;
		if(n<2){
			return 1;
		}
		if(n==3){
			return 5;
		}
		if(n==4){
			return 14;
		}
		long ret = 0;
		for(long i =1;i<=n;i++){
			ret+= count(i-1)*count(n-i);
		}
		memo[help] = ret;
		return ret;
		
	}
	public static void main(String[] args){
		int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,20,21};
		BSTpermutations myTest = new BSTpermutations();
		System.out.println(myTest.howMany(values));
	}
}

