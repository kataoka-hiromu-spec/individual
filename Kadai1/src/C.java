public class C {
    // 変数を「カプセル化」
    private boolean flag;
    private int cnt1, cnt2;
    // コンストラクタ
    public C() {
        this.flag = true;
        this.cnt1 = 0;
        this.cnt2 = 0;
    }
    // メソッド
    public void call() {
        System.out.println("call");
        if (flag) cnt1++;
        else cnt2++;
    }
    public void lost(String msg) {
        System.out.println(msg);
        flag = false;
    }
    public void print() {
        System.out.println(cnt1);
        System.out.println(cnt2);
    }
    public void swap() {
    	int tmp = cnt1;
    	cnt1 = cnt2;
    	cnt2 = tmp;
    }
}
            
