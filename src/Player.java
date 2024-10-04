abstract public class Player {
    protected String name;
    protected String symbol;
    protected boolean isTurn;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean getIsTurn() {
        return isTurn;
    }

    public void setIsTurn(boolean turn) {
        this.isTurn = turn;
    }

    public Player(String name, String symbol, boolean isTurn) {
        this.name = name;
        this.symbol = symbol;
        this.isTurn = isTurn;
    }
}
