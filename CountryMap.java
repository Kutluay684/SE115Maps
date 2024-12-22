class CountryMap {
   City[] cities;
   int[][] routes;

   public CountryMap(int numberOfCities) {
      this.cities = new City[numberOfCities];
      this.routes = new int[numberOfCities][numberOfCities];

      for (int i = 0; i < numberOfCities; ++i) {
         for (int j = 0; j < numberOfCities; ++j) {
            this.routes[i][j] = Integer.MAX_VALUE;
         }
      }
   }

   public void addCity(int index, String label) {
      this.cities[index] = new City(label);
   }

   public void addRoute(String city1, String city2, int time) {
      int index1 = this.findCityIndex(city1);
      int index2 = this.findCityIndex(city2);
      if (index1 != -1 && index2 != -1) {
         this.routes[index1][index2] = time;
         this.routes[index2][index1] = time;
      }
   }

   public int findCityIndex(String city) {
      for (int i = 0; i < this.cities.length; ++i) {
         if (this.cities[i].getName().equals(city)) {
            return i;
         }
      }
      return -1;
   }
}
