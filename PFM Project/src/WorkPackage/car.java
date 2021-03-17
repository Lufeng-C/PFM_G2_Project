package WorkPackage;

import java.io.Serializable;

public class car implements Serializable {
	private string carID;
	private String carName;
    private String carType;
    private double basePrice;
    private String size;
    private String sport;
    private String fuelType;

    public car (String carID, String carName, String carType, double basePrice, 
    		String size, String sport, String fuelType) { 
    	this.carID = carID; // Might need to use setter methods here
    	this.carName = carName;
    	this.carType = carType;
        this.basePrice = basePrice;
        this.size = size;
        this.sport = sport;
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

    public double getBasePrice() {
        return basePrice;
    }

    public String getSize() {
        return size;
    }

    public String isSport() {
        return sport;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setCarID(String carID) {
    	this.carID = carID;
    }
    public void setCarName(String carName) {
    	this.carName = carName;
    }
    public void setCarType(String carType) {
        this.carType = carType;
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
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    @Override
    public String toString() {
        return  "Car ID= " + carID +
        		", Car Name= " + carName +
        		", Car Type= " + carType +
                ", basePrice= " + basePrice +
                ", size= " + size +
                ", sport= " + sport +
                ", fuelType= " + fuelType ;

    }
}
}
