import java.util.ArrayList;

public class CollatzProblem {
    public static ArrayList<Integer> verify(int n){
        ArrayList<Integer> collatz = new ArrayList<Integer>();
        int num = 0;
        for(int i=0; i<Integer.MAX_VALUE; i++){
            if(n==1) break;
            collatz.add(n);
            if(n%2 == 0) {
                n = n/2;
            }else{
                n = 3*n + 1;
            }
            num++;
        }

        collatz.add(1);
        System.out.printf("ステップ数: %d\n", num);
        System.out.printf("実行結果:\n");
        return collatz;
    }
    
	public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        ArrayList<Integer> seq = verify(n);

        for (Integer i : seq) {
			System.out.println(i);
		}
    }
}