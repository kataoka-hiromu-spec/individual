public class JudgeEX {
    private RandomJankenPlayer player1, player2, player3;

    public JudgeEX(RandomJankenPlayer player1, RandomJankenPlayer player2, RandomJankenPlayer player3){
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
    }

    private void play(int n) {

        player1.init();
        player2.init();
        player3.init();
        int win1 = 0, win2 = 0, win3 = 0;
        int lose1 = 0, lose2 = 0, lose3 = 0;
        int draw1 = 0, draw2 = 0, draw3 = 0;

        for(int i=0; i<n; i++){

            Hand hand1 = player1.showHand();
            Hand hand2 = player2.showHand();

            if(hand1.defeating() == hand2){
                win1++; lose2++;
                player1.receiveResult(Result.WIN);
                player2.receiveResult(Result.LOSE);
            }
            else if(hand1.defeatedBy() == hand2){
                lose1++; win2++;
                player1.receiveResult(Result.LOSE);
                player2.receiveResult(Result.WIN);
            }
            else{
                draw1++; draw2++;
                player1.receiveResult(Result.DRAW);
                player2.receiveResult(Result.DRAW);
            }
		}

		for(int i=0; i<n; i++){

			Hand hand2 = player2.showHand();
            Hand hand3 = player3.showHand();

            if(hand2.defeating() == hand3){
                win2++; lose3++;
                player2.receiveResult(Result.WIN);
                player3.receiveResult(Result.LOSE);
            }
            else if(hand2.defeatedBy() == hand3){
                lose2++; win3++;
                player2.receiveResult(Result.LOSE);
                player3.receiveResult(Result.WIN);
            }
            else{
                draw2++; draw3++;
                player2.receiveResult(Result.DRAW);
                player3.receiveResult(Result.DRAW);
            }

		}

		for(int i=0; i<n; i++){

			Hand hand3 = player3.showHand();
            Hand hand1 = player1.showHand();

            if(hand3.defeating() == hand1){
                win3++; lose1++;
                player3.receiveResult(Result.WIN);
                player1.receiveResult(Result.LOSE);
            }
            else if(hand3.defeatedBy() == hand1){
                lose3++; win1++;
                player3.receiveResult(Result.LOSE);
                player1.receiveResult(Result.WIN);
            }
            else{
                draw3++; draw1++;
                player3.receiveResult(Result.DRAW);
                player1.receiveResult(Result.DRAW);
            }
        }
    }

    public static void main(String[] args) {
        try {
            int num = Integer.parseInt(args[0]);
            RandomJankenPlayer player1 = new RandomJankenPlayer("Yamada");
            RandomJankenPlayer player2 = new RandomJankenPlayer("Suzuki");
            RandomJankenPlayer player3 = new RandomJankenPlayer("Tanaka");
            JudgeEX judge = new JudgeEX(player1, player2, player3);
            judge.play(num);
            player1.report();
            player2.report();
            player3.report();
        } catch(Exception e) {
            System.out.println("this requires an integer argument.");
        }
    }
}