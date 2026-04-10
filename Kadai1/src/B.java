public class B {
    boolean b;
    int i;
    Hand h;
    // 初期値を指定したコンストラクタ
    public B() {
        this.b = true;
        this.i = 10;
        this.h = Hand.SCISSORS;
    }
    // 引数で指定したコンストラクタ
    public B(boolean b, int i, Hand h) {
    	this.b = b;
    	this.i = i;
    	this.h = h;
    }
    
    public void print() {
        System.out.println(b);
        System.out.println(i);
        System.out.println(h);  
    }
}
