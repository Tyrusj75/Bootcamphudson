package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;



public class UserInterface {
    Dealership dealership;
    Scanner scanner = new Scanner(System.in);

    int choseOption;


    private void init (){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership1 = new Dealership("Tooka's" , "add", "123");


        dealershipFileManager.getDealerShip(dealership1);
        dealership = dealership1;

    }


    public void display() throws SQLException {
        // Initialize the dealership object
        init();

        Scanner scanner = new Scanner(System.in);
        String user = "root";
        String myPassword = System.getenv("Realman12");

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/CarDealership");
        dataSource.setUsername(user);
        dataSource.setPassword(myPassword);
        Connection conn = dataSource.getConnection();

        DatabaseModel databaseModel = new DatabaseModel(conn, scanner);
        VehicleDataModel vehicleDataModel = new VehicleDataModel(conn, scanner);
        SalesContractDataModel salesContractDataModel = new SalesContractDataModel(conn, scanner);
        LeaseContractDataModel leaseContractDataModel = new LeaseContractDataModel(conn, scanner);

        do {
            System.out.println("Welcome to D & D dealership");
            System.out.println("Which option would you like to choose?");
            System.out.println("1)- Find vehicles within price range ");
            System.out.println("2)- Find vehicles by make / model ");
            System.out.println("3)- Find vehicles by year range ");
            System.out.println("4)- Find vehicles by color ");
            System.out.println("5)- Find vehicles mileage range ");
            System.out.println("6)- Find vehicles by type (car, truck, SUV, van ");
            System.out.println("7)- Find ALL vehicles");
            System.out.println("8)- Add a vehicle");
            System.out.println("9)- Remove a vehicle");
            System.out.println("10)- Purchase (sale contract)");
            System.out.println("11)- Lease (lease contract)");
            System.out.println("99)- Quit");
            choseOption = scanner.nextInt();

            switch (choseOption) {
                case 1: {
                    vehicleDataModel.getByPriceRange();
                    break;
                }
                case 2: {
                    vehicleDataModel.getByMakeOrModel();
                    break;
                }
                case 3: {
                    vehicleDataModel.getByYearRange();
                    break;
                }
                case 4: {
                    vehicleDataModel.getByColor();
                    break;
                }
                case 5: {
                    vehicleDataModel.getByMileageRange();
                    break;
                }
                case 6: {
                    vehicleDataModel.getByCarType();
                    break;
                }
                case 7: {
                    processGetAllVehicles();
                    break;
                }
                case 8: {
                    databaseModel.addVehicle();
                    break;
                }
                case 9: {
                    databaseModel.removeVehicle();
                    break;
                }
                case 10: {
                    salesContractDataModel.addSale();
                    break;
                }
                case 11: {
                    leaseContractDataModel.addLease();
                    break;
                }
                case 99: {
                    System.exit(0);
                    break;
                }
            }
        } while (choseOption != 99);
    }
    public  Vehicle readCSV(String readVehicle) {
        String[] info = readVehicle.split("\\|");

        if (info.length != 8) {
            System.out.println("Incomplete Vehicle: " + readVehicle);
            return null;
        }

        int vin = Integer.parseInt(info[0]);
        int year = Integer.parseInt(info[1]);
        String make  = info[2];
        String model  = info[3];
        String vehicleType = info[4];
        String color = info[5];
        int odometer = Integer.parseInt(info[6]);
        double price = Double.parseDouble(info[7]);




        Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
        return vehicle;
    }

    private void processGetAllVehicles() {
        System.out.println(dealership.toString());
    }

    public void processGetByPriceRequest(){

        double maxPrice;
        System.out.println("Enter the maximum amount");
        maxPrice = scanner.nextDouble();

        for (Vehicle vehicle: dealership.inventory) {
            if (vehicle.price < maxPrice){
                System.out.println(vehicle.make);
            }
        }

    }
    public void processGetByMakeModelRequest(String requestedMakeModel){

    }
    public void processGetByYearRequest(int reqYear){

    }
    public void processGetByColorRequest(String color){

    }
    public void processGetByMileage(int reqMileage){

    }

    public void processGetByVehicleTypeRequest(String reqType){

    }
    public void processAddVehicleRequest(Vehicle addedVehicle){

    }
    public void processRemoveVehicleRequest(Vehicle addedVehicle){

    }

}

