public class StrategyLearningPlayer extends RandomJankenPlayer{
    public StrategyLearningPlayer(String name) {
        super(name);
    } 
    @Override
    public Hand showHand() {
        if(super.getBestChoice()==0) {
            super.recordHand(Hand.ROCK);
            return Hand.ROCK;
        }
        if(super.getBestChoice()==1) {
            super.recordHand(Hand.SCISSORS);
            return Hand.SCISSORS;
        }
        if(super.getBestChoice()==2) {
            super.recordHand(Hand.PAPER);
            return Hand.PAPER;
        }
        return super.showHand();
    }
    public static void main ( String [] args ) {
        RandomJankenPlayer player1 = new MyJankenPlayer (" Suzuki ");
        RandomJankenPlayer player2 = new StrategyLearningPlayer (" Yamamoto ");
        for ( int i = 0; i < 10; i ++) {
            Hand hand1 = player1.showHand();
            Hand hand2 = player2.showHand();
            System.out.printf ("%d) [%s] %s vs [%s] %s\n", i, player1.getName(), hand1, player2.getName(), hand2);
        }
    }
}
