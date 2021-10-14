import java.util.Arrays;

public class Games {
    static Games[] gameCollection = new Games[10];

    public String name;
    public int releaseYear;
    public double price;

    public Games(String name, int releaseYear, double price) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.price = price;

    }

    public String toString() {
        return this.name + ", was released in " + this.releaseYear + " and it costs " + this.price;
    }
    public static Games searchGame(String gameTitle) {
        for (int i = 0; i < 3; i++) {
            if (gameCollection[i].name.equals(gameTitle)) {
                return gameCollection[i];
            }
        }
        return null;
    }

    public static Games updateGame(String gameTitle, double price){
        Games updatedPrice = searchGame(gameTitle);
        if (updatedPrice != null) {
            updatedPrice.price = price;
       }
        return updatedPrice;
    }

    public static Games[] deleteGame(String gameTitle) {
        Games[] newGameCollection = new Games[10];
        int j = 0;
        for (int i =0; i < 3; i++) {
            if (gameCollection[i].name.equals(gameTitle)){
                j = i + 1;
            }
            newGameCollection[i] = gameCollection[j++];
            }
        return newGameCollection;
        }



    public static void main(String[] args) {

        Games Cod = new Games("Call of Duty", 2010, 59.99);
        Games Nba = new Games("NBA LIVE", 2006, 50.99);
        Games Boxing = new Games("Fight Night", 2008, 55.99);

        gameCollection[0] = Cod;
        gameCollection[1] = Nba;
        gameCollection[2] = Boxing;

        System.out.println(gameCollection[0]);
        Games searchgame = searchGame("NBA LIVE");
        String result = searchgame == null ? "Game does not exist" : searchgame.toString();
        System.out.println(result);
        System.out.println(gameCollection[2]);
        gameCollection[2] = updateGame("Fight Night", 25);
        System.out.println(gameCollection[2]);
        gameCollection = deleteGame("Fight Night");
        System.out.println(Arrays.toString(gameCollection));








    }

}