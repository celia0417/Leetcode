package Array;

public class PrimeCount {
	public int countPrimes(int n) {
        int cnt =0;
        for (int i = 2; i < n ; i++){
            if (isPrime(i))
                cnt ++;
        }
        return cnt;
    }
	
	private boolean isPrime(int n ){
		if (n == 2) return true;
		if (n % 2 ==0) return false;
		for (int i =3; i * i <= n; i++){
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public int countPrimes2(int n) {
		int res = 0;
		boolean isPrime [] = new boolean [n];
		for (int i =2; i < n; i++){
			isPrime[i] = true;
		}
		for (int i = 2; i* i < n ; i++){
			if (!isPrime[i]) continue;
			for (int j = i * i; j < n; j += i){
				isPrime[j] = false;
			}
		}
		for (boolean prime : isPrime){
			if (prime) res ++;
		}
		return res;
	}
	
	public static void main (String args[]){
		PrimeCount pc = new PrimeCount();
		System.out.println(pc.countPrimes(90));
		System.out.println(pc.countPrimes2(90));

	}
}
