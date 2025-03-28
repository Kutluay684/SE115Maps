import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      if (args.length != 1) {
         System.out.println("Error: Please provide the input file name as a command line argument.");
      } else {
         String filePath = args[0];

          try {
              File file = new File(filePath);
              Scanner scanner = new Scanner(file);
              System.out.println("File read successful!");


              int numberOfCities = Integer.parseInt(scanner.nextLine());


              CountryMap map = new CountryMap(numberOfCities);


              String[] cityLabels = scanner.nextLine().split(" ");

              int numberOfRoutes;
              for (numberOfRoutes = 0; numberOfRoutes < cityLabels.length; ++numberOfRoutes) {
                  map.addCity(numberOfRoutes, cityLabels[numberOfRoutes]);
              }

              numberOfRoutes = Integer.parseInt(scanner.nextLine());

              for (int i = 0; i < numberOfRoutes; ++i) {
                  String[] routeData = scanner.nextLine().split(" ");
                  map.addRoute(routeData[0], routeData[1], Integer.parseInt(routeData[2]));
              }

              String[] citiesToFind = scanner.nextLine().split(" ");
              String startCity = citiesToFind[0];
              String endCity = citiesToFind[1];
              WayFinder finder = new WayFinder(map);
              String result = finder.findFastestWay(startCity, endCity);

              try {
                  PrintWriter writer = new PrintWriter("output.txt");
                  writer.println(result);
              } catch (FileNotFoundException e) {
                  System.out.println("Error: File not found.");
              } catch (Exception e) {
                  System.out.println("Error: Could not write to the file.");
              }


          } catch (FileNotFoundException e) {
              throw new RuntimeException(e);
          } finally {

          }
      }
   }
}
