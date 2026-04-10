public class Judge2 {
	private RandomJankenPlayer player1, player2;

	// ここを埋める
	// Judge2クラスのフィールドplayer1とplayer2に
	// 引数のプレイヤーを設定するコンストラクタ

	public Judge2(RandomJankenPlayer player1, RandomJankenPlayer player2){
		this.player1 = player1;
		this.player2 = player2;
	}

	private int[] simulate(int n) {
		int win1 = 0;
		int lose1 = 0;
		int draw1 = 0;

		for(int i=0; i<n; i++){
			Hand hand1 = this.player1.showHand();
        	Hand hand2 = this.player2.showHand();
			if(hand1.defeating()==hand2) {
				win1++;
			}
			else if(hand1.defeatedBy()==hand2) {
				lose1++;
			}
			else{
				draw1++;
			}
		}

        return new int[]{win1, lose1, draw1};

		/*System.out.println("Player1 : " + player1.getName());
		System.out.println("Player2 : " + player2.getName());
		System.out.println();
		System.out.printf("Results: %d games\n", n);
		System.out.printf("%s %d win, %d lose, %d draw\n", player1.getName(), win1, lose1, draw1);
		System.out.printf("%s %d win, %d lose, %d draw\n", player2.getName(), win2, lose2, draw2);*/
	}
	public static void main(String[] args) {
        int win1=0;
        int lose1=0;
        int draw1=0;
        int setNum = Integer.parseInt(args[0]);
        int num = 10;
        for(int i=0; i<setNum; i++){
                RandomJankenPlayer player1 = new RandomJankenPlayer("Yamada");
                RandomJankenPlayer player2 = new RandomJankenPlayer("Suzuki");
                Judge2 judge2 = new Judge2(player1, player2);
                int[] result = judge2.simulate(num);
            win1+=result[0];
            lose1+=result[1];
            draw1+=result[2];
        }
        System.out.println("winProb: "+(double)win1/(setNum*num)+"\nloseProb: "+(double)lose1/(setNum*num)+"\ndrawProb: "+(double)draw1/(setNum*num)+"\n");
	}
}
