public class ConcreteJankenPlayerTypeB extends JankenPlayer{
    public ConcreteJankenPlayerTypeB(String name) {
        super(name);
    } 
    @Override
    public Hand showHand () {
        return Hand.ROCK ;
    }
    public static void main ( String [] args ) {
        JankenPlayer player1 = new ConcreteRandomJankenPlayer (" Suzuki ");
        JankenPlayer player2 = new ConcreteJankenPlayerTypeB (" Yamamoto ");
        for ( int i = 0; i < 10; i ++) {
            Hand hand1 = player1.showHand();
            Hand hand2 = player2.showHand();
            System.out.printf ("%d) [%s] %s vs [%s] %s\n", i, player1.getName(), hand1,
            player2.getName(), hand2);
        }
    }
}