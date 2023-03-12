import java.util.ArrayList;
import java.util.Scanner;

public class ACServiceManagementSystem {

    public static void main(String[] args) {
        ArrayList<ACUnit> acUnits = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("==== AC Servicing Management System ====");
            System.out.println("1. Add AC Unit");
            System.out.println("2. View AC Units");
            System.out.println("3. Add Service History");
            System.out.println("4. View Service History");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("==== Add AC Unit ====");
                    System.out.print("Brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    ACUnit acUnit = new ACUnit(brand, model, age, true);
                    acUnits.add(acUnit);
                    System.out.println("AC unit added successfully.");
                    break;

                case 2:
                    System.out.println("==== View AC Units ====");
                    for (int i = 0; i < acUnits.size(); i++) {
                        System.out.println((i + 1) + ". " + acUnits.get(i));
                    }
                    break;

                case 3:
                    System.out.println("==== Add Service History ====");
                    System.out.print("Enter AC Unit index: ");
                    int acUnitIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (acUnitIndex > acUnits.size() || acUnitIndex <= 0) {
                        System.out.println("Invalid AC unit index.");
                        break;
                    }
                    System.out.print("Service type: ");
                    String serviceType = scanner.nextLine();
                    System.out.print("Service date (YYYY-MM-DD): ");
                    String serviceDate = scanner.nextLine();
                    ServiceHistory serviceHistory = new ServiceHistory(serviceType, serviceDate);
                    ACUnit unit = acUnits.get(acUnitIndex - 1);
                    unit.addServiceHistory(serviceHistory);
                    System.out.println("Service history added successfully.");
                    break;

                case 4:
                    System.out.println("==== View Service History ====");
                    System.out.print("Enter AC Unit index: ");
                    acUnitIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (acUnitIndex > acUnits.size() || acUnitIndex <= 0) {
                        System.out.println("Invalid AC unit index.");
                        break;
                    }
                    unit = acUnits.get(acUnitIndex - 1);
                    ArrayList<ServiceHistory> history = unit.getServiceHistory();
                    for (int i = 0; i < history.size(); i++) {
                        System.out.println((i + 1) + ". " + history.get(i));
                    }
                    break;

                case 5:
                    System.out.println("==== Schedule Appointment ====");
                    System.out.print("Enter AC Unit index: ");
                    acUnitIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (acUnitIndex > acUnits.size() || acUnitIndex <= 0) {
                        System.out.println("Invalid AC unit index.");
                        break;
                    }
                    unit = acUnits.get(acUnitIndex - 1);
                    System.out.print("Appointment date (YYYY-MM-DD): ");
                    String appointmentDate = scanner.nextLine();
                    Appointment appointment = new

