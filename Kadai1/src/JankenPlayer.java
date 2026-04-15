import java.util.ArrayList;
import java.util.Random;

public abstract class JankenPlayer {

    protected String name;
    protected int winCnt;
    protected int loseCnt;
    protected int drawCnt;
    private Random random;
    private ArrayList<Hand> opponentHands;
    private int WDL;
    private int numROCK, numSCISSORS, numPAPER;
    private int winRock, winScissors, winPaper;
    
    public abstract Hand showHand();

    protected JankenPlayer(String name) {
        this.name = name;
		this.winCnt = winCnt;
		this.loseCnt = loseCnt;
		this.drawCnt = drawCnt;
        random = new Random();
        opponentHands = new ArrayList<>();
    }

    public String getName () {
        return name ;
    }

    public void init() {
        this.winCnt = 0;
        this.loseCnt = 0;
        this.drawCnt = 0;
        opponentHands.clear();
    }

    public int getWinCnt() {
        return this.winCnt;
    }

    public int getLoseCnt() {
        return this.loseCnt;
    }

    public int getDrawCnt() {
        return this.drawCnt;
    }

    public void setWDL(int n) {
        this.WDL = n;
    }

    public int getWDL() {
        return this.WDL;
    }

    public void setTend(int n) {
        if (n == 0) {
            numROCK++;
        }
        if (n == 1) {
            numSCISSORS++;
        }
        if (n == 2) {
            numPAPER++;
        }
    }

    public int getTend() {
        if (numROCK > numSCISSORS) {
            if (numROCK > numPAPER) {
                return 0;
            }
            if (numROCK < numPAPER) {
                return 2;
            }
        }
        if (numSCISSORS > numPAPER) {
            return 1;
        }
        if (numSCISSORS < numPAPER) {
            return 2;
        }
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public void setWinRock() {
        this.winRock++;
    }

    public void setWinScissors() {
        this.winScissors++;
    }

    public void setWinPaper() {
        this.winPaper++;
    }

    public int getBestChoice() {
        if (winRock > winScissors) {
            if (winRock > winPaper) {
                return 0;
            }
            if (winRock < winPaper) {
                return 2;
            }
        }
        if (winScissors > winPaper) {
            return 1;
        }
        if (winScissors < winPaper) {
            return 2;
        }
        Random rand = new Random();
        return rand.nextInt(3);
    }

    public void report() {
        System.out.println(this.getName() + " " + this.getWinCnt() + " win, " + this.getLoseCnt() + " lose, " + this.getDrawCnt() + " draw\n");
    }

    public void receiveResult(Result result, Hand opponentHand) {
        if (result == Result.WIN) {
            this.winCnt++;
        }
        if (result == Result.LOSE) {
            this.loseCnt++;
        }
        if (result == Result.DRAW) {
            this.drawCnt++;
        }
        opponentHands.add(opponentHand);

        if (opponentHand == Hand.ROCK) {
            setTend(0);
        }
        if (opponentHand == Hand.SCISSORS) {
            setTend(1);
        }
        if (opponentHand == Hand.PAPER) {
            setTend(2);
        }
    }

    public Hand getOpponentBeforeHand() {
        if (opponentHands.isEmpty()) {
            return null;
        }
        return opponentHands.get(opponentHands.size() - 1);
    }
}