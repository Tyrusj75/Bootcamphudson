package org.example;

import java.util.Scanner;



public class UserInterface {
    Dealership dealership;
    Scanner scanner = new Scanner(System.in);

    int choseOption;


    private void init (){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership1 = new Dealership("Ty's Car Dealership" , "add", "123");


        dealershipFileManager.getDealerShip(dealership1);
        dealership = dealership1;

    }


    public void display(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership1 = new Dealership("Ty's Car Dealership" , "add", "123");
        dealershipFileManager.getDealerShip(dealership1);
        dealership = dealership1;
        dealership.getAllVehicles();



        do {
            System.out.println("Welcome to Ty's Car Dealership");
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
            System.out.println("99)-  Quit");
            choseOption = scanner.nextInt();


            switch (choseOption){
                case 1:{
                    processGetByPriceRequest();
                    break;
                }
                case 2:{
                    String chosenMakeModel;
                    System.out.println("What is the make/model?");
                    chosenMakeModel = scanner.next();
                    scanner.nextLine();
                    dealership.getVehiclesByMakeModel(chosenMakeModel);
                    break;

                }
                case 3:{
                    int minYear;
                    int maxYear;
                    System.out.println("What is the minimum year?");
                    minYear = scanner.nextInt();

                    System.out.println("What is the maximum year?");
                    maxYear = scanner.nextInt();

                    dealership.getVehicleYear(minYear,minYear);
                    break;

                }
                case 4:{
                    String chosenColor;
                    System.out.println("What color to filter by?");
                    chosenColor = scanner.next();

                    dealership.getVehiclesByColor(chosenColor);
                    break;
                }
                case 5:{
                    int chosenMin;
                    int chosenMax;
                    System.out.println("What's the minimum amount of mileage?");
                    chosenMin = scanner.nextInt();

                    System.out.println("What's the maximum amount of mileage?");
                    chosenMax = scanner.nextInt();


                    dealership.getVehiclesByMileage(chosenMin,chosenMax);
                    break;
                }
                case 6:{
                    String chosenVehicleType;
                    System.out.println("Whats your chosen vehicle type?");
                    chosenVehicleType = scanner.next();
                    dealership.getVehiclesType(chosenVehicleType);
                    break;

                }
                case 7:{
                    processGetAllVehicles();
                    break;

                }
                case 8:{
                    int vin;
                    int year;
                    String make;
                    String model;
                    String vehicleType;
                    String color;
                    int odometer;
                    double price;

                    System.out.println("What is the vin");
                    vin = scanner.nextInt();

                    System.out.println("What is the year of the vehicle?");
                    year = scanner.nextInt();

                    System.out.println("Whats is the make?");
                    make = scanner.next();

                    System.out.println("What is the model?");
                    model = scanner.next();

                    System.out.println("What is the vehicle type?");
                    vehicleType = scanner.next();

                    System.out.println("What is the color?");
                    color = scanner.next();

                    System.out.println("What is the current milage?");
                    odometer = scanner.nextInt();

                    System.out.println("Whats is the price?");
                    price = scanner.nextInt();


                    Vehicle newVehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                    dealership.addVehicle(newVehicle);
                    dealership.toString();
                }
                case 9:{
                    int chosenVinRemoval;
                    System.out.println("What is the VIN of the vehicle?");
                    chosenVinRemoval = scanner.nextInt();


                    for (Vehicle vehicle: dealership.inventory) {
                        if (vehicle.vin == chosenVinRemoval){
                            dealership.inventory.remove(vehicle);
                            break;

                        }

                    }
                    break;
                }
                case 99:{
                }

            }

        } while (choseOption != 99);
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
