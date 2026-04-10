public class Judge {
	private RandomJankenPlayer player1, player2;

	// ここを埋める
	// Judgeクラスのフィールドplayer1とplayer2に
	// 引数のプレイヤーを設定するコンストラクタ

	public Judge(RandomJankenPlayer player1, RandomJankenPlayer player2){
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
			}
			else if(hand1.defeatedBy()==hand2) {
				win2++;
				lose1++;
			}
			else{
				draw1++;
				draw2++;
			}
		}

		System.out.println("Player1 : " + player1.getName());
		System.out.println("Player2 : " + player2.getName());
		System.out.println();
		System.out.printf("Results: %d games\n", n);
		System.out.printf("%s %d win, %d lose, %d draw\n", player1.getName(), win1, lose1, draw1);
		System.out.printf("%s %d win, %d lose, %d draw\n", player2.getName(), win2, lose2, draw2);
	}
	public static void main(String[] args) {
		try {
			int num = Integer.parseInt(args[0]); // ラウンド数
			RandomJankenPlayer player1 = new RandomJankenPlayer("Yamada");
			RandomJankenPlayer player2 = new RandomJankenPlayer("Suzuki");
			Judge judge = new Judge(player1, player2);
			judge.simulate(num);
		} catch(Exception e) {
			System.out.println("this requires an integer argument.");
		}
	}
}
