import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
class ACService {
    private int serviceId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private Date serviceDate;
    private String serviceType;
    private String technicianName;
    private String status;
    private String remarks;
    private double totalBill;
    
    public ACService(int serviceId, String customerName, String customerAddress, String customerPhone,
            Date serviceDate, String serviceType, String technicianName, String status, String remarks, double totalBill) {
        this.serviceId = serviceId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.technicianName = technicianName;
        this.status = status;
        this.remarks = remarks;
        this.totalBill = totalBill;
    }
    
    public int getServiceId() {
        return serviceId;
    }
    
    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerAddress() {
        return customerAddress;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    
    public String getCustomerPhone() {
        return customerPhone;
    }
    
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    public Date getServiceDate() {
        return serviceDate;
    }
    
    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
    
    public String getServiceType() {
        return serviceType;
    }
    
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    public String getTechnicianName() {
        return technicianName;
    }
    
    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getRemarks() {
        return remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public double getTotalBill() {
        return totalBill;
    }
    
    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
    }

    
    class ACServiceManager {
        private ArrayList<ACService> serviceList;
    
        public ACServiceManager() {
            serviceList = new ArrayList<>();
        }
    
        public void addService(ACService service) {
            serviceList.add(service);
        }
    
        public void updateService(int serviceId, String status, String remarks) {
            for (ACService service : serviceList) {
                if (service.getServiceId() == serviceId) {
                    service.setStatus(status);
                    service.setRemarks(remarks);
                    break;
                }
            }
        }
    
        public void deleteService(int serviceId) {
            for (int i = 0; i < serviceList.size(); i++) {
                if (serviceList.get(i).getServiceId() == serviceId) {
                    serviceList.remove(i);
                    break;
                }
            }
        }
    
        public ArrayList<ACService> getServiceList() {
            return serviceList;
        }
    
        public ACService searchService(int serviceId) {
            for (ACService service : serviceList) {
                if (service.getServiceId() == serviceId) {
                    return service;
                }
            }
            return null;
        }
    
        public double getTotalEarnings() {
            double total = 0;
            for (ACService service : serviceList) {
                total += service.getTotalBill();
            }
            return total;
        }
    
        public ACService createService(int serviceId, String customerName, String customerAddress, String customerPhone,
                                       Date serviceDate, String serviceType, String technicianName, String status,
                                       String remarks, double totalBill) {
            return new ACService(serviceId, customerName, customerAddress, customerPhone, serviceDate, serviceType,
                                 technicianName, status, remarks, totalBill);
        }
    
        public ACService addService(String customerName, String customerAddress, String customerPhone,
                                    Date serviceDate, String serviceType, String technicianName, String status,
                                    String remarks, double totalBill) {
            ACService service = createService(serviceList.size() + 1, customerName, customerAddress, customerPhone,
                                               serviceDate, serviceType, technicianName, status, remarks, totalBill);
            addService(service);
            return service;
        }
    }
    


public class myACService {
    public static void main(String[] args) {
        ACServiceManager serviceManager = new ACServiceManager();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        // Display the menu
        boolean quit = false;
        while (!quit) {
            System.out.println("AC Service Management System");
            System.out.println("1. Add Service");
            System.out.println("2. Update Service");
            System.out.println("3. Delete Service");
            System.out.println("4. View Service List");
            System.out.println("5. Search Service");
            System.out.println("6. View Total Earnings");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer address: ");
                    String customerAddress = scanner.nextLine();
                    System.out.print("Enter customer phone: ");
                    String customerPhone = scanner.nextLine();
                    System.out.print("Enter service date (MM/dd/yyyy): ");
                    Date serviceDate = null;
                    try {
                        serviceDate = dateFormat.parse(scanner.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter service type: ");
                    String serviceType = scanner.nextLine();
                    System.out.print("Enter technician name: ");
                    String technicianName = scanner.nextLine();
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    System.out.print("Enter remarks: ");
                    String remarks = scanner.nextLine();
                    System.out.print("Enter total bill: ");
                    double totalBill = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    ACService service = new ACService(serviceManager.getServiceList().size() + 1, customerName,
                            customerAddress, customerPhone, serviceDate, serviceType, technicianName, status, remarks, totalBill);
                    serviceManager.addService(service);
                            // int serviceId, String customerName, String customerAddress, String customerPhone,
            // Date serviceDate, String serviceType, String technicianName, String status, String remarks, double totalBill
                    serviceManager.addService(service);
                    System.out.println("Service added.");
                    break;
                case 2:
                    System.out.print("Enter service ID to update: ");
                    int serviceId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    System.out.print("Enter new remarks: ");
                    String newRemarks = scanner.nextLine();
                    serviceManager.updateService(serviceId, newStatus, newRemarks);
                    System.out.println("Service updated.");
                    break;
                case 3:
                    System.out.print("Enter service ID to delete: ");
                    int serviceIdToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    serviceManager.deleteService(serviceIdToDelete);
                    System.out.println("Service deleted.");
                    break;
                case 4:
                    // Display the service list
                    ArrayList<ACService> services = serviceManager.getServiceList();
                    if (services.isEmpty()) {
                        System.out.println("No services found.");
                    } else {
                        System.out.println("Service ID\tCustomer Name\tService Type\tService Date\tTotal Bill");
                        for (ACService s : services) {
                            System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%.2f\n", s.getServiceId(),
                                    s.getCustomerName(), s.getServiceType(), dateFormat.format(s.getServiceDate()),
                                    s.getTotalBill());
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter service ID to search: ");
                    int serviceIdToSearch = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    ACService searchedService = serviceManager.searchService(serviceIdToSearch);
                    if (searchedService == null) {
                        System.out.println("Service not found.");
                    } else {
                        System.out.println("Service ID\tCustomer Name\tService Type\tService Date\tTotal Bill");
                        System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%.2f\n", searchedService.getServiceId(),
                                searchedService.getCustomerName(), searchedService.getServiceType(),
                                dateFormat.format(searchedService.getServiceDate()), searchedService.getTotalBill());
                    }
                    break;
                case 6:
                    System.out.printf("Total earnings: %.2f\n", serviceManager.getTotalEarnings());
                    break;
                case 7:
                    quit = true;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
