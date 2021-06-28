import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {

        LocalTime timeNow = getCurrentTime();
        boolean isRestauarntOpen= false;
        if(timeNow.isBefore(openingTime) || timeNow.isAfter(closingTime)) isRestauarntOpen=false;
        else if(timeNow.isBefore(closingTime) || timeNow.isAfter(openingTime )) isRestauarntOpen=true;
            return isRestauarntOpen;

    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {

        List<Item> items = new ArrayList<Item>();

            items.add( new Item("Sweet Corn Soup",119) );
            items.add( new Item("Nachos",6 ));
            items.add( new Item("Mud Pie",50) );
            items.add( new Item("Jerk Chicken",249) );

        return items;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }


    public int calculateTotalPrice(List<String> selectedItems) {
        List<Item> items=getMenu();
        int totalAmount = 0;
        for(String sItem:selectedItems){
            for(Item item:items){
             if(sItem.equalsIgnoreCase(item.getName())){
                 totalAmount=totalAmount+item.getPrice();
             }
         }
        }
        return totalAmount;
    }
}
