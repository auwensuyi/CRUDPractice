public class Game {

    private String gameTitle;
    private int gameReleaseDate;
    private double gamePrice;

    public Game() {

    }

    public Game(String gameTitle, int gameReleaseDate, double gamePrice) {
        this.gameTitle = gameTitle;
        this.gameReleaseDate = gameReleaseDate;
        this.gamePrice = gamePrice;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public int getGameReleaseDate() {
        return gameReleaseDate;
    }

    public void setGameReleaseDate(int gameReleaseDate) {
        this.gameReleaseDate = gameReleaseDate;
    }

    public double getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(double gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String toString() {
        return "Title: " + gameTitle + "\n" +
                "Release Date: " + gameReleaseDate + "\n" +
                "Price: $" + gamePrice;
    }
}
