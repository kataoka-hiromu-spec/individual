public class JudgeEX2 {
    private RandomJankenPlayer[] players;

    public JudgeEX2(RandomJankenPlayer[] players){
    	this.players = players;
	}

    private void play(int n, int members) {

    for(int i = 0; i < members; i++){
        players[i].init();
    }

    for(int i=0; i<members; i++){
        for(int j=i+1; j<members; j++){
            for(int k=0; k<n; k++){
					Hand h1 = players[i].showHand();
					Hand h2 = players[j].showHand();

					if(h1.defeating() == h2){
						players[i].receiveResult(Result.WIN);
						players[j].receiveResult(Result.LOSE);
					}
					else if(h1.defeatedBy() == h2){
						players[i].receiveResult(Result.LOSE);
						players[j].receiveResult(Result.WIN);
					}
					else{
						players[i].receiveResult(Result.DRAW);
						players[j].receiveResult(Result.DRAW);
					}
				}
				System.out.println(players[i].getName()+" vs "+players[j].getName()+": ");
				players[i].report();
				System.out.println(players[j].getName()+" vs "+players[i].getName()+": ");
				players[j].report();
			}
		}
	}

    public static void main(String[] args) {
        try {
            int num = Integer.parseInt(args[0]);
			int m = 5;

			RandomJankenPlayer[] players = new RandomJankenPlayer[m];
			players[0] = new RandomJankenPlayer("Yamada");
            players[1] = new RandomJankenPlayer("Suzuki");
            players[2] = new RandomJankenPlayer("Tanaka");
			players[3] = new RandomJankenPlayer("Yukoku");
            players[4] = new RandomJankenPlayer("Shirase");
			//追加...

            JudgeEX2 judge = new JudgeEX2(players);
            judge.play(num, m);
            for(int i = 0; i < m; i++){
                players[i].report();
            }
        } catch(Exception e) {
            System.out.println("this requires an integer argument.");
        }
    }
}