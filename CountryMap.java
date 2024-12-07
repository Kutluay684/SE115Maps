import java.util.*;

public class CountryMap {
    private Map<String, City> cities = new HashMap<>();
    private Map<String, List<Route>> routes = new HashMap<>();

    public void addCity(String cityName) {
        cities.put(cityName, new City(cityName));
    }

    public void addRoute(String city1, String city2, int time) {
        routes.computeIfAbsent(city1, k -> new ArrayList<>()).add(new Route(city1, city2, time));
        routes.computeIfAbsent(city2, k -> new ArrayList<>()).add(new Route(city2, city1, time));
    }

    public List<Route> getRoutes(String city) {
        return routes.getOrDefault(city, new ArrayList<>());
    }

    public boolean cityExists(String city) {
        return cities.containsKey(city);
    }
}
