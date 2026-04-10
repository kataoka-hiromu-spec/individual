import java.util.Random;

public class PrimeStatistics {

    public static int isPrime(int n){
        if(n%2==0) return 0;
        for(int i=1; i<Math.sqrt(n); i++){
            if(n%(2*i+1)==0) return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        int N = 100000;
        int n = (int)Math.pow(2, 30);
        int num = 0;
        Random rand = new Random();
		for(int i=0; i<N; i++) {
            num += isPrime(rand.nextInt(n));
        }
        double p = (double)N / (double)num;
        double q = Math.log(n);

        System.out.println("p: "+p+"q: "+q);
	}
}
