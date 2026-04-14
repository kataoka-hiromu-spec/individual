public class JankenPlayerTypeA extends RandomJankenPlayer{
    public JankenPlayerTypeA(String name) {
        super(name);
    } 
    public Hand showHand() {
        if(super.getWDL() == 2) {
            Hand opponentLast = super.getOpponentBeforeHand();
            if(opponentLast != null) {
                super.recordHand(opponentLast); // 記録する
                return opponentLast;
            }
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