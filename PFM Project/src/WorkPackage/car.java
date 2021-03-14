package Benz;

import java.io.Serializable;

public class carClass implements Serializable {
	private string carID;
	private String carName;
    private String carType;
    private String carModel;
    private String electricEquivalent;
    private double basePrice;
    private String size;
    private String sport;
    private String bodyType;
    private String fuelType;

    public carClass (String carName, String carType, String carModel, String electricEquivalent, double basePrice, String size, String sport, String bodyType, String fuelType) {
    	this.carName = carName;
    	this.carType = carType;
        this.carModel = carModel;
        this.electricEquivalent = electricEquivalent;
        this.basePrice = basePrice;
        this.size = size;
        this.sport = sport;
        this.bodyType = bodyType;
        this.fuelType = fuelType;
    }
    public String getCarID() {
        return carID;
    }
    public String getCarName() {
        return carName;
    }
    public String getCarType() {
        return carType;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getElectricEquivalent() {
        return electricEquivalent;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getSize() {
        return size;
    }

    public String isSport() {
        return sport;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getFuelType() {
        return fuelType;
    }
    public String setCarID(String carID) {
    	this.carID = carID;
    }
    public String setCarName(String carName) {
    	this.carName = carName;
    }
    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setElectricEquivalent(String electricEquivalent) {
        this.electricEquivalent = electricEquivalent;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    @Override
    public String toString() {
        return " Car ID= " + carID +
        		" Car Name= " + carName +
        		"Car Type= " + carType +
                ", Car Model= " + carModel +
                ", Electric Equivalent= " + electricEquivalent +
                ", basePrice= " + basePrice +
                ", size= " + size +
                ", sport= " + sport +
                ", bodyType= " + bodyType +
                ", fuelType= " + fuelType ;

    }
}


	

}
