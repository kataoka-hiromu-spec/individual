public class MyJankenPlayer extends RandomJankenPlayer{
    public MyJankenPlayer(String name) {
        super(name);
    } 
    public Hand showHand() {
        if(super.getTend()==0) {
            super.recordHand(Hand.PAPER);
            return Hand.PAPER;
        }
        if(super.getTend()==1) {
            super.recordHand(Hand.ROCK);
            return Hand.ROCK;
        }
        if(super.getTend()==2) {
            super.recordHand(Hand.SCISSORS);
            return Hand.SCISSORS;
        }
        return super.showHand();
    }
    public static void main ( String [] args ) {
        RandomJankenPlayer player1 = new RandomJankenPlayer (" Suzuki ");
        RandomJankenPlayer player2 = new JankenPlayerTypeA (" Yamamoto ");
        for ( int i = 0; i < 10; i ++) {
            Hand hand1 = player1.showHand();
            Hand hand2 = player2.showHand();
            System.out.printf ("%d) [%s] %s vs [%s] %s\n", i, player1.getName(), hand1,
            player2.getName(), hand2);
        }
    }
}