import java.util.ArrayList;
import java.util.Random;

public class RandomJankenPlayer {
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

	public RandomJankenPlayer(String name) {
		this.name = name;
		this.winCnt = winCnt;
		this.loseCnt = loseCnt;
		this.drawCnt = drawCnt;
		random = new Random();
		myHands = new ArrayList<>(); // 空の ArrayList で初期化
		opponentHands = new ArrayList<>();
	}

	public RandomJankenPlayer(String name, long seed) { 		
		this.name = name;
		random = new Random(seed);
	}

	public void init(){
			this.winCnt = 0;
			this.loseCnt = 0;
			this.drawCnt = 0;
			myHands.clear(); // メソッドの意味は API リファレンスで確認せよ
			opponentHands.clear(); 
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

	public void setWDL(int n){
		this.WDL = n;
	}

	public int getWDL(){
		return this.WDL;
	}

	public void setTend(int n){
		if(n==0) numROCK++;
		if(n==1) numSCISSORS++;
		if(n==2) numPAPER++;
	}

	public int getTend(){
		if(numROCK>numSCISSORS){
			if(numROCK>numPAPER) return 0;
			if(numROCK<numPAPER) return 2;
		}
		if(numSCISSORS>numPAPER) return 1;
		if(numSCISSORS<numPAPER) return 2;
		Random rand = new Random();
		return rand.nextInt(3);
	}

	public void setWinRock(){
		this.winRock++;
	}

	public void setWinScissors(){
		this.winScissors++;
	}

	public void setWinPaper(){
		this.winPaper++;
	}

	public int getBestChoice(){
		if(winRock>winScissors){
			if(winRock>winPaper) return 0;
			if(winRock<winPaper) return 2;
		}
		if(winScissors>winPaper) return 1;
		if(winScissors<winPaper) return 2;
		Random rand = new Random();
		return rand.nextInt(3);
	}

	public void report(){
		System.out.println(this.getName()+" "+this.getWinCnt()+" win, "+this.getLoseCnt()+" lose, "+this.getDrawCnt()+" draw\n");
	}

	public void receiveResult(Result result, Hand opponentHand){
		if(result == Result.WIN) this.winCnt++;
		if(result == Result.LOSE) this.loseCnt++;
		if(result == Result.DRAW) this.drawCnt++;
		opponentHands.add(opponentHand);

		if(opponentHand == Hand.ROCK) setTend(0);
		if(opponentHand == Hand.SCISSORS) setTend(1);
		if(opponentHand == Hand.PAPER) setTend(2);
	}

	public Hand getOpponentBeforeHand(){
		if(opponentHands.isEmpty()) return null;
		return opponentHands.get(opponentHands.size()-1);
	}

	protected void recordHand(Hand hand) {
		myHands.add(hand);
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

	public void showHistory() {
		System.out.println("history:");
		for(int i = 0; i < myHands.size(); i++){
			System.out.println((i+1) + ": " + myHands.get(i) + " vs " + opponentHands.get(i));
		}
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
