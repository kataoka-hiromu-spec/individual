public class JudgeEX2 {
    private RandomJankenPlayer[] players;

    public JudgeEX2(RandomJankenPlayer[] players){
    	this.players = players;
	}

    private void play(int n, int members) {

        for(int i = 0; i < members; i++){
			players[i].init();
		}
        int[] wins = new int[members];
		int[] loses = new int[members];
		int[] draws = new int[members];

        for(int i=0; i<members; i++){
			for(int j=i+1; j<members; j++){
				for(int k=0; k<n; k++){
					Hand tmpHand1 = players[i].showHand();
					Hand tmpHand2 = players[j].showHand();
					if(tmpHand1.defeating()==tmpHand2){
						wins[i]++;
						loses[j]++;
					}
					else if(tmpHand1.defeatedBy()==tmpHand2){
						loses[i]++;
						wins[j]++;
					}
					else{
						draws[i]++;
						draws[j]++;
					}
				}
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
