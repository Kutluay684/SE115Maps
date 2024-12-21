class WayFinder {
    private CountryMap map;

    public WayFinder(CountryMap map) {
        this.map = map;
    }

    public String findFastestWay(String startCity, String endCity) {
        int startIndex = map.findCityIndex(startCity);
        int endIndex = map.findCityIndex(endCity);

        if (startIndex == -1 || endIndex == -1)
        {
            return "Error: One or more cities not found in the map.";

        }

        boolean[] visited = new boolean[map.cities.length];
        int[] distance = new int[map.cities.length];
        int[] previous = new int[map.cities.length];

        for (int i = 0; i < distance.length; i++)
        {
            distance[i] = Integer.MAX_VALUE;
            visited[i] = false;
            previous[i] = -1;
        }

        distance[startIndex] = 0;

        for (int count = 0; count < map.cities.length - 1; count++) {
            int minIndex = -1;
            int minDistance = Integer.MAX_VALUE;

            for (int i = 0; i < distance.length; i++) {
                if (!visited[i] && distance[i] < minDistance) {
                    minDistance = distance[i];
                    minIndex = i;
                }
            }

            if (minIndex == -1) break;

            visited[minIndex] = true;

            for (int i = 0; i < map.cities.length; i++) {
                if (!visited[i] && map.routes[minIndex][i] != Integer.MAX_VALUE &&
                        distance[minIndex] + map.routes[minIndex][i] < distance[i]) {
                    distance[i] = distance[minIndex] + map.routes[minIndex][i];
                    previous[i] = minIndex;
                }
            }
        }

        if (distance[endIndex] == Integer.MAX_VALUE) {
            return "No path exists between " + startCity + " and " + endCity + ".";
        }

        StringBuilder path = new StringBuilder();
        int current = endIndex;

        while (current != -1) {
            path.insert(0, map.cities[current] + " ");
            current = previous[current];
        }

        return "Fastest Way: " + path.toString().trim() + "\nTotal Time: " + distance[endIndex] + " min";
    }
}
