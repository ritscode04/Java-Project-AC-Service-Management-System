import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
            Date serviceDate, String serviceType, String technicianName, String status, String remarks,
            double totalBill) {
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

public class dd {
    public static void main(String[] args) {
        ACServiceManager serviceManager = new ACServiceManager();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "service_records.txt";
        File file = new File(fileName);

        // If the file doesn't exist, create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        boolean quit = false;

        while (!quit) {
            System.out.println(" ---------- ");
            // Display menu options
            System.out.println("AC Service Management System");
            System.out.println("1. Add Service");
            System.out.println("2. Update Service");
            System.out.println("3. Delete Service");
            System.out.println("4. View Service List");
            System.out.println("5. Search Service");
            System.out.println("6. Total Earnings");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            // Get user input
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 1:
                    // Add a new service record
                    System.out.print("Enter customer name: ");
                    String customerName = "";
                    try {
                        customerName = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter customer address: ");
                    String customerAddress = "";
                    try {
                        customerAddress = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter customer phone ");
                    String customerPhone = "";
                    try {
                        customerPhone = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.print("Enter AC model: ");
                    String acModel = "";
                    try {
                        acModel = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter Service Type: ");
                    String serviceType = "";
                    try {
                        serviceType = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                    System.out.print("Enter technicianName: ");
                    String technicianName = "";
                    try {
                        technicianName = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter remarks: ");
                    String remarks = "";
                    try {
                        remarks = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter Service Status: ");
                    String status = "";
                    try {
                        status = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.print("Enter service date (dd/mm/yyyy): ");
                    // String serviceDate = "";
                    // try {
                    //     serviceDate = reader.readLine();
                    // } catch (IOException e) {
                    //     e.printStackTrace();
                    // }
                    Date serviceDate = null;
                    try {
                        serviceDate = dateFormat.parse(scanner.nextLine());
                        // serviceDate = reader.readLine();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    System.out.print("Enter service cost: ");
                    double serviceCost = 0.0;
                    try {
                        serviceCost = Double.parseDouble(reader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                    System.out.print("Enter service cost: ");
                    double totalBill = 0.0;
                    try {
                        totalBill = Double.parseDouble(reader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ACService service = new ACService(serviceManager.getServiceList().size() + 1, customerName,
                    customerAddress, customerPhone, serviceDate, serviceType, technicianName, status,remarks,  totalBill);
            serviceManager.addService(service);
                    
            


                    // Write the new record to the file
                    try {
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                       
                         bw.write("-------------------------------------------------------------\n");
                        while(choice==1){
                        bw.write(
                                         "\nName: " + customerName
                                        + "\nAddress: " + customerAddress
                                        + "\nPhone: " + customerPhone
                                        + "\nModel : " + acModel
                                        + "\nserviceDate : " + serviceDate
                                        + "\nserviceType : " + serviceType
                                        + "\nStatus : " + status
                                        + "\nserviceCost : " + serviceCost);
                        
                        bw.newLine();
                        bw.close();
                        fw.close();
                        System.out.println("Service record added successfully.");
                        }
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                
                
                    break;
                case 2:
                    // Update Service
                    System.out.print("Enter service ID to update: ");
                    String serviceId = "";
                    try {
                        serviceId = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter new status: ");
                    String newStatus = "";
                    try {
                        newStatus = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Enter new remarks: ");
                    String newRemarks = "";
                    try {
                        newRemarks = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(serviceId + "," + newStatus + "," + newRemarks);
                        bw.newLine();
                        bw.close();
                        fw.close();
                        System.out.println("Service updated.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
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
                    try {
                        FileInputStream fileInputStream = new FileInputStream("service_records.txt");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println(line);
                        }
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading the file.");
                        e.printStackTrace();
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
                    System.out.println("Exiting AC Service Management System...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
