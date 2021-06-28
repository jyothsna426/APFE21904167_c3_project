import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();
    public RestaurantService(){
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurants.add(new Restaurant("Hard Rock Cafe","Bangalore",openingTime,closingTime));
    }

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        boolean resturantNotFound= false;
        for(Restaurant restaurant : restaurants){
            if(restaurant.getName().equalsIgnoreCase(restaurantName)){
                return restaurant;
            }
        }
        resturantNotFound= true;
        if(resturantNotFound==true){
            throw new restaurantNotFoundException(restaurantName +" does not exists");
        }
        return null;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
