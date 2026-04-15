import java.util.Random;

public class ConcreteJankenPlayerTypeA extends JankenPlayer{
    public ConcreteJankenPlayerTypeA(String name) {
        super(name);
    } 
    public Hand showHand() {
        if(super.getWDL() == 2) {
            Hand opponentLast = super.getOpponentBeforeHand();
            if(opponentLast != null) {
                return opponentLast;
            }
        }
        return randomhand();
    }

    public Hand randomhand() {
		Hand play;
        Random random = new Random();
		int num = random.nextInt(3); // 0 ~ 2の間の整数をランダムに生成
		if (num == 0) {
			play = Hand.ROCK;
		} else if (num == 1) {
			play = Hand.PAPER;
		} else {
			play = Hand.SCISSORS;
		}
		return play;
	}

    public static void main ( String [] args ) {
        JankenPlayer player1 = new ConcreteRandomJankenPlayer (" Suzuki ");
        JankenPlayer player2 = new ConcreteJankenPlayerTypeA (" Yamamoto ");
        for ( int i = 0; i < 10; i ++) {
            Hand hand1 = player1.showHand();
            Hand hand2 = player2.showHand();
            System.out.printf ("%d) [%s] %s vs [%s] %s\n", i, player1.getName(), hand1,
            player2.getName(), hand2);
        }
    }
}