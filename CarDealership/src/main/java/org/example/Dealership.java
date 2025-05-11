package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    String name;
    String address;
    String phone;

    ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    List<Vehicle> getVehiclesByPrice(double min, double max){

        return null ;
    }
    List<Vehicle> getVehiclesByMakeModel(String makeModel) {
        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle: inventory) {
            if (vehicle.make.equalsIgnoreCase(makeModel.trim()) || vehicle.model.equalsIgnoreCase(makeModel.trim())) {
                filteredVehicles.add(vehicle);
            }
        }
        for (Vehicle filteredVehicle: filteredVehicles) {
            System.out.println(filteredVehicle.vin + "|" + filteredVehicle.year + "|" + filteredVehicle.make + "|" + filteredVehicle.model + "|" + filteredVehicle.vehicleType + "|" + filteredVehicle.color + "|"  + filteredVehicle.odometer + "|" + filteredVehicle.price);
        }
        return null;
    }
    List<Vehicle> getVehicleYear(int min, int max){

        ArrayList<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle vehicle: inventory) {
            if (vehicle.year >= min && vehicle.year <= max ){
                filteredVehicles.add(vehicle);
            }
        }
        for (Vehicle filteredVehicle: filteredVehicles) {
            System.out.println(filteredVehicle.vin + "|" + filteredVehicle.year + "|" + filteredVehicle.make + "|" + filteredVehicle.model + "|" + filteredVehicle.vehicleType + "|" + filteredVehicle.color + "|"  + filteredVehicle.odometer + "|" + filteredVehicle.price);
        }
        return null;
    }
    List<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> filteredByColor = new ArrayList<>();

        for (Vehicle vehicle: inventory) {
            if (vehicle.color.equalsIgnoreCase(color)){
                filteredByColor.add(vehicle);
            }

        }
        for (Vehicle filteredVehicle: filteredByColor) {
            System.out.println(filteredVehicle.vin + "|" + filteredVehicle.year + "|" + filteredVehicle.make + "|" + filteredVehicle.model + "|" + filteredVehicle.vehicleType + "|" + filteredVehicle.color + "|"  + filteredVehicle.odometer + "|" + filteredVehicle.price);
        }
        return null;

    }
    List<Vehicle> getVehiclesByMileage(int min, int max){

        ArrayList<Vehicle> filteredByMilage = new ArrayList<>();

        for (Vehicle vehicle: inventory) {
            if (vehicle.odometer >= min && vehicle.odometer <= max){
                filteredByMilage.add(vehicle);
            }

        }
        for (Vehicle filteredVehicle: filteredByMilage) {
            System.out.println(filteredVehicle.vin + "|" + filteredVehicle.year + "|" + filteredVehicle.make + "|" + filteredVehicle.model + "|" + filteredVehicle.vehicleType + "|" + filteredVehicle.color + "|"  + filteredVehicle.odometer + "|" + filteredVehicle.price);
        }
        return null;

    }
    List<Vehicle> getVehiclesType(String vehicleType){
        ArrayList<Vehicle> filteredByType = new ArrayList<>();

        for (Vehicle vehicle: inventory) {
            if (vehicle.vehicleType.equalsIgnoreCase(vehicleType)){
                filteredByType.add(vehicle);
            }

        }
        for (Vehicle filteredVehicle: filteredByType) {
            System.out.println(filteredVehicle.vin + "|" + filteredVehicle.year + "|" + filteredVehicle.make + "|" + filteredVehicle.model + "|" + filteredVehicle.vehicleType + "|" + filteredVehicle.color + "|"  + filteredVehicle.odometer + "|" + filteredVehicle.price);
        }


        return null;
    }

    List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);

    }
    public void removeVehicle(Vehicle vehicle){

        inventory.remove(vehicle);
    }

    @Override
    public String toString() {
        for (Vehicle vehicle:inventory) {

            System.out.println(vehicle.vin + "|" + vehicle.year + "|" + vehicle.make + "|" + vehicle.model + "|" + vehicle.vehicleType + "|" + vehicle.color + "|" + vehicle.odometer + "|" + vehicle.price);
        }
        return " ";
    }
}
