
public class CountryMap {


    String[] cities ;
    int[][] routes;

     public CountryMap(int numberOfCities) {
         cities = new String[numberOfCities];
         routes = new int[numberOfCities][numberOfCities];

         for (int i = 0; i < numberOfCities; i++) {
             for (int j = 0; j < numberOfCities; j++) {


                   routes[j][i]=99999999;
             }

         }
     }
    public void addCity(int index, String label) {
        cities[index] = label;
    }
    public void addRoute(String city1, String city2,int time)
    {
int index1=findCityIndex(city1);
int index2=findCityIndex(city2);
if (index1!=-1 &&  index2!= -1)
{
  routes[index1][index2]=time;
  routes[index2][index1]=time;
}
    }
    public int findCityIndex(String city)
    {
         for(int i=0; i<cities.length;i++)
         {
             if (cities[i].equals(city))
             {
return i;
             }
            return -1;
         }
        return 0;
    }
}
