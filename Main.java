import java.util.Scanner;
import java.util.ArrayList;
public class Main {

  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    StopWatch stopwatch = new StopWatch();
    Vehicle vehicle = new Vehicle();
    boolean condition = true;
    String[][] parkingSlot = { { "A1", "A2", "A3", "A4", "A5", "A6" },
        { "B1", "B2", "B3", "B4", "B5", "B6" },
        { "C1", "C2", "C3", "C4", "C5", "C6" },
        { "D1", "D2", "D3", "D4", "D5", "D6" },
        { "E1", "E2", "E3", "E4", "E5", "E6" },
        { "F1", "F2", "F3", "F4", "F5", "F6" }
    };
   ArrayList<String> occupiedSpots = new ArrayList<String>();
    while (condition == true){
    System.out.println("Welcome to the ParkNPay Parking System. Please choose one of the following options: ");
    System.out.println("1. Park a vehicle");
    System.out.println("2. Pay your bill / Checkout");
    int choice = scanner.nextInt();
    switch (choice) {
      case 1:
        System.out.print("Enter the vehicle's licence plate: ");
        String licencePlate = scanner.nextLine();
      vehicle.setLicencePlate(licencePlate);
        
        scanner.nextLine();
        System.out.print("Enter the vehicle's model: ");
        String model = scanner.nextLine();
        vehicle.setModel(model);
        
        System.out.print("Enter the vehicle's colour: ");
        String color = scanner.nextLine();
        vehicle.setColor(color);
        
        String parkingSpace;
        boolean validInput = false;
        do {
          System.out.println("Choose your car's parking space: ");
          for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
              System.out.print(parkingSlot[i][j] + " ");
            }
            System.out.println();
          }

          parkingSpace = scanner.nextLine();
          //hi

              // Check if the parking space is occupied
              if (occupiedSpots.contains(parkingSpace)) {
                  System.out.println("This spot is occupied. Please choose another one.");
                  validInput = false;
              } else {
                  // Check if the parking space is valid
                  boolean spaceExists = false;
                  for (int i = 0; i < 6; i++) {
                      for (int j = 0; j < 6; j++) {
                          if (parkingSlot[i][j].equals(parkingSpace)) {
                              spaceExists = true;
                              break;
                          }
                      }
                      if (spaceExists) {
                          break;
                      }
                  }

                  if (spaceExists) {
                      validInput = true;
                  } else {
                      System.out.println("Invalid entry. Please choose a valid parking space.");
                      validInput = false;
                  }
              }

          } while (!validInput);

          System.out.println("You have chosen parking space: " + parkingSpace);
          System.out.println("Parking space is now occupied.");
          stopwatch.startTime();
          occupiedSpots.add(parkingSpace);
          break;

      case 2:
        System.out.print("Please provide the parking spot of the vehicle you want to pay for: ");
        parkingSpace = scanner.nextLine();
        if (occupiedSpots.contains(parkingSpace)) {
          stopwatch.stopTime();
          System.out.println("Please follow the onscreen instructions to pay your bill.");
          occupiedSpots.remove(parkingSpace); // Free up the parking space
        } else {
          System.out.println("No vehicle found in the specified parking spot.");
        }
        break;
    }
    }
    
  }
}