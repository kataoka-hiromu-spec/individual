public class Test1 {
    public static void main(String[] s) {
        B x = new B();

        B y = new B();
        y.i = 20;
        
        B z = new B(true, 1, Hand.PAPER);
        
        x.print();
        y.print();
        z.print();
    }
}
