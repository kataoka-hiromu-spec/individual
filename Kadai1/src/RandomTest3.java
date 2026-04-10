import java.util.Random;

public class RandomTest3 {
	public static int makeRand(){
        Random random = new Random();
		int num = random.nextInt(1001);
		if(num%2==1) num = -1*(num+1);

        return num;
	}

    public static void main(String[] args) {
		int x = makeRand();
		System.out.println("Random even integer: "+x);
	}
}
