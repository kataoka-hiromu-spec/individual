public class Judge {
	private JankenPlayer player1, player2;

	public Judge(JankenPlayer player1, JankenPlayer player2){
		this.player1 = player1;
		this.player2 = player2;
	}

	private void simulate(int n) {
		int win1 = 0, win2 = 0;
		int lose1 = 0, lose2 = 0;
		int draw1 = 0, draw2 = 0;

		for(int i=0; i<n; i++){
			Hand hand1 = this.player1.showHand();
        	Hand hand2 = this.player2.showHand();
			if(hand1.defeating()==hand2) {
				win1++;
				lose2++;
				this.player1.setWDL(0);
				this.player2.setWDL(2);
			}
			else if(hand1.defeatedBy()==hand2) {
				win2++;
				lose1++;
				this.player1.setWDL(2);
				this.player2.setWDL(0);
			}
			else{
				draw1++;
				draw2++;
				this.player1.setWDL(1);
				this.player2.setWDL(1);
			}
		}

		System.out.println("Player1 : " + player1.getName());
		System.out.println("Player2 : " + player2.getName());
		System.out.println();
		System.out.printf("Results: %d games\n", n);
		System.out.printf("%s %d win, %d lose, %d draw\n", player1.getName(), win1, lose1, draw1);
		System.out.printf("%s %d win, %d lose, %d draw\n", player2.getName(), win2, lose2, draw2);
	}

	private void play(int n) {

		System.out.println("Player1 : " + player1.getName());
		System.out.println("Player2 : " + player2.getName());
		
        player1.init();
        player2.init();
        int win1 = 0, win2 = 0;
        int lose1 = 0, lose2 = 0;
        int draw1 = 0, draw2 = 0;

		for(int i=0; i<n; i++){
			Hand hand1 = player1.showHand();
			Hand hand2 = player2.showHand();
			if(hand1==Hand.ROCK) player1.setTend(0);
			if(hand1==Hand.SCISSORS) player1.setTend(1);
			if(hand1==Hand.PAPER) player1.setTend(2);

			if(hand1.defeating() == hand2) {
				win1++; lose2++;
				player1.receiveResult(Result.WIN, hand2);
				player2.receiveResult(Result.LOSE, hand1);
				this.player1.setWDL(0);
				this.player2.setWDL(2);
				if(hand1==Hand.ROCK) player1.setWinRock();
				if(hand1==Hand.SCISSORS) player1.setWinScissors();
				if(hand1==Hand.PAPER) player1.setWinPaper();

			}
			else if(hand1.defeatedBy() == hand2) {
				lose1++; win2++;
				player1.receiveResult(Result.LOSE, hand2);
				player2.receiveResult(Result.WIN, hand1);
				this.player1.setWDL(2);
				this.player2.setWDL(0);
				if(hand1==Hand.ROCK) player2.setWinRock();
				if(hand1==Hand.SCISSORS) player2.setWinScissors();
				if(hand1==Hand.PAPER) player2.setWinPaper();
			}
			else{
				draw1++; draw2++;
				player1.receiveResult(Result.DRAW, hand2);
				player2.receiveResult(Result.DRAW, hand1);
				this.player1.setWDL(1);
				this.player2.setWDL(1);
			}
		}
		System.out.println();
		System.out.printf("Player1: %s %d win, %d lose, %d draw\n", player1.getName(), win1, lose1, draw1);
		System.out.printf("Player2: %s %d win, %d lose, %d draw\n", player2.getName(), win2, lose2, draw2);
		System.out.println();
    }

	public static void main(String[] args) {
		try {
			int num = Integer.parseInt(args[0]); // ラウンド数
			JankenPlayer player1 = new ConcreteMyJankenPlayer("Yamada");
			JankenPlayer player2 = new ConcreteStrategyLearningPlayer("Suzuki");
			Judge judge = new Judge(player1, player2);
			judge.play(num);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
