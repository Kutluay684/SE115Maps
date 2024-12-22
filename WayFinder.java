class WayFinder {
   private CountryMap map;

   public WayFinder(CountryMap map) {
      this.map = map;
   }

   public String findFastestWay(String startCity, String endCity) {
      int startIndex = this.map.findCityIndex(startCity);
      int endIndex = this.map.findCityIndex(endCity);
      if (startIndex != -1 && endIndex != -1) {
         boolean[] visited = new boolean[this.map.cities.length];
         int[] distance = new int[this.map.cities.length];
         int[] previous = new int[this.map.cities.length];

         int count;
         for(count = 0; count < distance.length; ++count) {
            distance[count] = Integer.MAX_VALUE;
            visited[count] = false;
            previous[count] = -1;
         }

         distance[startIndex] = 0;

         int minIndex;
         for(count = 0; count < this.map.cities.length - 1; ++count) {
            minIndex = -1;
            int minDistance = Integer.MAX_VALUE;

            int i;
            for(i = 0; i < distance.length; ++i) {
               if (!visited[i] && distance[i] < minDistance) {
                  minDistance = distance[i];
                  minIndex = i;
               }
            }

            if (minIndex == -1) {
               break;
            }

            visited[minIndex] = true;

            for(i = 0; i < this.map.cities.length; ++i) {
               if (!visited[i] && this.map.routes[minIndex][i] != Integer.MAX_VALUE && distance[minIndex] + this.map.routes[minIndex][i] < distance[i]) {
                  distance[i] = distance[minIndex] + this.map.routes[minIndex][i];
                  previous[i] = minIndex;
               }
            }
         }

         if (distance[endIndex] == Integer.MAX_VALUE) {
            return "No path exists between " + startCity + " and " + endCity + ".";
         } else {
            StringBuilder path = new StringBuilder();

            for(minIndex = endIndex; minIndex != -1; minIndex = previous[minIndex]) {
               String var10002 = this.map.cities[minIndex].getName();
               path.insert(0, var10002 + " ");
            }

            String var10000 = path.toString().trim();
            return "Fastest Way: " + var10000 + "\nTotal Time: " + distance[endIndex] + " min";
         }
      } else {
         return "Error: One or more cities not found in the map.";
      }
   }
}
