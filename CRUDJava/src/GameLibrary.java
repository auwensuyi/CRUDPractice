public class GameLibrary {

    int capacity;  //Capacity of the Game Library
    Game[] gamesCollection;  //Array collection of Game Object
    private int size; //Current size of the elements in the array;


    //Constructor for Game Library. Takes initial capacity from User.
    public GameLibrary(int capacity) {
        this.capacity = capacity;
        this.gamesCollection = new Game[capacity];
        this.size = 0;
    }

    //Helper Method -- Check if the library is full
    public boolean isFull() {
        return size == capacity;
    }

    //Helper Method -- Check if the library is empty
    public boolean isEmpty() {
        return size == 0;
    }

    //Add new game object to the game collection library
    public boolean addGame(Game newGame) {
        if (!isFull()) {
            gamesCollection[size] = newGame;
            size++;
            return true;
        }
        return false;
    }

    //Searches the game collection library to see if a game object exist
    //Searches based on game title
    public Game searchGame(String gameTitle) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (gamesCollection[i].getGameTitle().equalsIgnoreCase(gameTitle))
                    return gamesCollection[i];
            }
        }
        return null;
    }

    //Finds and updates price of the game object
    public Game updateGame(String gameTitle, double price) {
        Game updatedPrice = searchGame(gameTitle);
        if (updatedPrice != null) {
            updatedPrice.setGamePrice(price);
        }
        return updatedPrice;
    }

    //Removes game object form the game collection library
    public boolean deleteGame(String gameTitle) {
        boolean deleted = false;
        if (!isEmpty()) {
            Game[] newLibrary = new Game[capacity];
            int j = 0;
            for (int i = 0; i < size; i++) {
                if (gamesCollection[i].getGameTitle().equalsIgnoreCase(gameTitle)) {
                    j = i + 1;
                    deleted = true;
                }
                newLibrary[i] = gamesCollection[j++]; // Copies elements from old game collection to new game collection
            }
            size--;
            gamesCollection = newLibrary; // Overwrites old array with new array
        }
        return deleted;
    }

    //Prints out content of game collection library array
    public void printLibrary() {
        System.out.println("*** Game Library ***");
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                System.out.println(gamesCollection[i] + "\n");
            }
            return;
        }
        System.out.println("Library Is Currently Empty");
    }

    public static void main(String[] args) {
        GameLibrary library = new GameLibrary(5);
        Game COD = new Game("Call Of Duty", 2010, 60);
        Game NBA = new Game("NBA Live", 2017, 20.99);
        Game Boxing = new Game("Fight Night", 2009, 59.99);

        //Adding Games
        library.addGame(COD);
        library.addGame(NBA);
        library.addGame(Boxing);
        library.printLibrary();

        //Search Games
        Game searchedGame = library.searchGame("NBA Live");
        String result = searchedGame == null ? "Game Does Not Exist" : searchedGame.toString();
        System.out.println(result);

        //Update Games
        System.out.println("\n*** Before Update ***");
        System.out.println(library.searchGame("Fight Night"));
        System.out.println("\n*** After Update ***");
        library.updateGame("Fight Night", 39.32);
        System.out.println(library.searchGame("Fight Night"));

        //Delete Games
        System.out.println("\n*** Before Deletion ***\n");
        library.printLibrary();
        library.deleteGame("NBA Live");
        library.printLibrary();

    }
}