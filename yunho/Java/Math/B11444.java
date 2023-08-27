package Practice;

public class B11444 { //피보나치 수 6
	static final int MOD = 1000000007;
	static long[][] X = {{1, 1}, {1, 0}};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		long[][] A = {{1, 1}, {1, 0}};
		long N = read();
		
		if(N == 1) System.out.println(1);
		else System.out.println(pow(A, N - 1)[0][0]);
	}
	
	static long[][] pow(long[][] A, long exp) {
		if(exp == 1) return A;
		
		A = pow(A, exp / 2);
		A = mul(A, A);
		if(exp % 2 == 1) A = mul(A, X);
		
		return A;
	}
	
	static long[][] mul(long[][] o1, long[][] o2) {
		long[][] res = new long[2][2];
		
		res[0][0] = (o1[0][0] * o2[0][0] + o1[0][1] * o2[1][0]) % MOD;
		res[0][1] = (o1[0][0] * o2[0][1] + o1[0][1] * o2[1][1]) % MOD;
		res[1][0] = (o1[1][0] * o2[0][0] + o1[1][1] * o2[1][0]) % MOD;
		res[1][1] = (o1[1][0] * o2[0][1] + o1[1][1] * o2[1][1]) % MOD;
		
		return res;
	}
	
	static long read() throws Exception {
		long n = System.in.read();
		int c;
		boolean minus = false;
		
		if(n == 45) {
			minus = true;
			n = System.in.read();
		}
		else if(n == 10) n = System.in.read();
		
		n &= 15;
		
		while((c = System.in.read()) >= 48) {
			n = (n << 3) + (n << 1) + (c & 15);
		}
		
		return n;
	}
}