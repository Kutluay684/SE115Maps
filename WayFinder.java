public class WayFinder {
private CountryMap map;
    public WayFinder(CountryMap map) {
       this.map=map;
    }
    public void findFastestWay(String startCity,String endCity)
    {
        int startIndex=-1;
        int endIndex=-1;
        int neighborIndex;
        try {
             startIndex=map.findCityIndex(startCity);
             endIndex=map.findCityIndex(endCity);
            if (startIndex==-1||endIndex==-1)
            {
                System.out.println("Error: One or both cities not found in the map.");
                return;
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while finding the fastest way.");
            return;
        }
         boolean[] visited = new boolean[map.cities.length];
           int[] distance=new int[map.cities.length];
           for (int i=0; i<distance.length; i++)
           {
               distance[i]=Integer.MAX_VALUE;
               visited[i]=false;

           }
        distance[startIndex]=0;
        int minDistance = Integer.MAX_VALUE;
        int minIndex=-1;
     for(int i=0; i<distance.length;   i++) {
            if (!visited[i]&&distance[i]<minDistance)
            {
                minDistance=distance[i];
                minIndex =i;
            }



     }

        visited[minIndex]=true;
        if (routes[minIndex][neighborIndex]!=Integer.MAX_VALUE||!visited[neighborIndex])
        {
            
            distance[neighborIndex]=Math.min(distance[neighborIndex],distance[minIndex]+routes[minIndex][neighborIndex]);
        }





    }



}
