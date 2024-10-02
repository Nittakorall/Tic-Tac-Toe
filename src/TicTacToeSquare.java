public class TicTacToeSquare {
    String value;
    String place;

    public String getPlace() {
        return place;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TicTacToeSquare(String value, String place) {
        this.value = value;
        this.place = place;
    }
}
