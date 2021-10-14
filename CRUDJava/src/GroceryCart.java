public class GroceryCart {
    int capacity;
    GroceryItem[] cart;
    int size;

    public GroceryCart(int capacity) {
        this.capacity = capacity;
        this.cart = new GroceryItem[capacity];
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //TODO -CREATE
    public boolean addItem(GroceryItem newItem) {
        boolean added = false;
        if(!isFull()) {
            cart[size] = newItem;
            size++;
            added = true;
        }
        return added;
    }


    //TODO -READ
    public GroceryItem searchItem(String itemName) {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (cart[i].getItemName().equalsIgnoreCase(itemName)) {
                    return cart[i];
                }
            }
        }
        return null;
    }

        //TODO -UPDATE
    public GroceryItem updateQuantity(String itemName, int quantity) {
        GroceryItem updatedQuantity = searchItem(itemName);
        if(updatedQuantity != null) {
            updatedQuantity.setQuantity(quantity);
        }
        return updatedQuantity;
    }

    public GroceryItem updateItem(String itemName, double price) {
        GroceryItem updatedPrice = searchItem(itemName);
        if(updatedPrice != null) {
            updatedPrice.setItemPrice(price);
        }
        return updatedPrice;
    }

        //TODO -DELETE
    public boolean deleteItem(String itemName) {
        boolean deleted = false;
        if(!isEmpty()) {
            GroceryItem[] newCart = new GroceryItem[capacity];
            int j = 0;
            for(int i = 0; i < size - 1; i++) {
                if(cart[i].getItemName().equalsIgnoreCase(itemName)) {
                    j = i + 1;
                    deleted = true;
                }
                newCart[i] = cart[j++];
            }
            size--;
            cart = newCart;

        }
        return deleted;
    }

    public void printItems() {
        if(!isEmpty()) {
            for(int i = 0; i < size; i++) {
                System.out.println(cart[i]);
            }
        }
    }

    public static void main(String[] args) {
        GroceryCart itemCart = new GroceryCart(4);

        itemCart.addItem(new GroceryItem("Juice", "liquid", 3.99, 1));
        GroceryItem Tissue = new GroceryItem("Tissue", "toiletry", 1.99, 1);
        itemCart.addItem(Tissue);
        itemCart.addItem(new GroceryItem("Cereal", "solid", 5.99, 1));
        itemCart.addItem(new GroceryItem("Milk", "liquid", 2.99, 1));
        //itemCart.printItems();

        GroceryItem searchedItem = itemCart.searchItem("Cereal");
       //System.out.println(searchedItem.toString());
        if(searchedItem != null) {
            System.out.println(searchedItem);
        }else{
            System.out.println("Item does not exist");
        }

        System.out.println(itemCart.searchItem("Juice").getItemPrice());

        System.out.println();
        System.out.println(itemCart.searchItem("Juice"));
        System.out.println(itemCart.updateItem("Juice", 10.50));

        System.out.println();
        itemCart.printItems();
        System.out.println();
        itemCart.deleteItem("Juice");
        itemCart.printItems();

        System.out.println();

        System.out.println(itemCart.searchItem("Milk"));
        System.out.println(itemCart.updateQuantity("Milk", 2));


    }

}
