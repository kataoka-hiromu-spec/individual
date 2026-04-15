
import java.util.ArrayList;
import java.util.Random;

public class ConcreteRandomJankenPlayer extends JankenPlayer {

    private String name;
    private Random random;
    private int winCnt;
    private int loseCnt;
    private int drawCnt;
    private ArrayList<Hand> myHands;
    private ArrayList<Hand> opponentHands;
    private int WDL;
    private int numROCK, numSCISSORS, numPAPER;
    private int winRock, winScissors, winPaper;

    public ConcreteRandomJankenPlayer(String name) {
        super(name);
    }

    public Hand showHand() {
        Hand play;
        int num = random.nextInt(3); // 0 ~ 2の間の整数をランダムに生成
        if (num == 0) {
            play = Hand.ROCK;
        } else if (num == 1) {
            play = Hand.PAPER;
        } else {
            play = Hand.SCISSORS;
        }
        myHands.add(play);
        return play;
	}

    // main
    public static void main(String[] args) {
        ConcreteRandomJankenPlayer player1 = new ConcreteRandomJankenPlayer("Yamada");
        ConcreteRandomJankenPlayer player2 = new ConcreteRandomJankenPlayer("Suzuki");
        ConcreteRandomJankenPlayer player3 = new ConcreteRandomJankenPlayer("Tanaka");
        System.out.println(player1.getName());
        for (int i = 0; i < 10; i++) {
            Hand hand1 = player1.showHand();
            Hand hand2 = player2.showHand();
            System.out.printf("%d) [%s] %s vs [%s] %s\n", i, player1.name, hand1, player2.name, hand2);
        }
    }
}
