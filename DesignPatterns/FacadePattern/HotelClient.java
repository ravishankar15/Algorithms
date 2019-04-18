interface Menu {
  public String foodItems();
}

class VegMenu implements Menu {

  public String foodItems() {
    return "This is a VegMenu";
  }
}

class NonVegMenu implements Menu {

  public String foodItems(){
    return "This is a NonVegMenu";
  }
}

class VegNonVegMenu implements Menu {

  public String foodItems() {
    return "This is a VegNonVegMenu";
  }
}

interface Hotel {
  public Menu getMenus();
}

class VegRestaurant implements Hotel {

  public Menu getMenus() {
    Menu m = new VegMenu();
    return m;
  }
}

class NonVegRestaurant implements Hotel {
  
  public Menu getMenus() {
    Menu m = new NonVegMenu();
    return m;
  }
}

class VegNonVegRestaurant implements Hotel {

  public Menu getMenus() {
    Menu m = new VegNonVegMenu();
    return m;
  }
}

class HotelKeeper {

  public Menu getVegMenu() {
    Hotel h = new VegRestaurant();
    Menu m =  h.getMenus();
    return m; 
  }

  public Menu getNonVegMenu() {
    Hotel h = new NonVegRestaurant();
    Menu m = h.getMenus();
    return m;
  }

  public Menu getVegNonVegMenu() {
    Hotel h = new VegNonVegRestaurant();;
    Menu m = h.getMenus();
    return m;
  }
}


public class HotelClient {
  public static void main(String[] args) {
    HotelKeeper hk = new HotelKeeper();
    System.out.println(hk.getVegMenu().foodItems());
    System.out.println(hk.getNonVegMenu().foodItems());
    System.out.println(hk.getVegNonVegMenu().foodItems());
  }
}