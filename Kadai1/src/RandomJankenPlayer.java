import java.util.Random;

public class RandomJankenPlayer {
	private String name;
	private Random random;
	private int winCnt;
	private int loseCnt;
	private int drawCnt;

	public RandomJankenPlayer(String name) {
		this.name = name;
		this.winCnt = winCnt;
		this.loseCnt = loseCnt;
		this.drawCnt = drawCnt;
		random = new Random();
	}

	public RandomJankenPlayer(String name, long seed) { 		
		this.name = name;
		random = new Random(seed);
	}

	public void init(){
			this.winCnt = 0;
			this.loseCnt = 0;
			this.drawCnt = 0;
	}

	public int getWinCnt(){
		return this.winCnt;
	}

	public int getLoseCnt(){
		return this.loseCnt;
	}

	public int getDrawCnt(){
		return this.drawCnt;
	}

	public void report(){
		System.out.println(this.getName()+" "+this.getWinCnt()+" win, "+this.getLoseCnt()+" lose, "+this.getDrawCnt()+" draw\n");
	}

	public void receiveResult(Result result){
		if(result==Result.WIN) this.winCnt++;
		if(result==Result.LOSE) this.loseCnt++;
		if(result==Result.DRAW) this.drawCnt++;
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
		return play;
	}

	public String getName(){
		return name;
	}

	// main
	public static void main(String[] args) {
		RandomJankenPlayer player1 = new RandomJankenPlayer("Yamada");
		RandomJankenPlayer player2 = new RandomJankenPlayer("Suzuki");
		RandomJankenPlayer player3 = new RandomJankenPlayer("Tanaka");
		System.out.println(player1.getName()); 
		for (int i = 0; i < 10; i++) {
			Hand hand1 = player1.showHand();
			Hand hand2 = player2.showHand();
			System.out.printf("%d) [%s] %s vs [%s] %s\n", i, player1.name, hand1, player2.name, hand2);
		}
	}
}
