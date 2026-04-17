package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class HotelStay extends Product {
    public double quote;
    
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        super(timePeriod);
    	this.quote = cost;
        
        this.hotel = hotel;
    }


    public double priceFactor() {
        return this.quote / this.price();
    }
    public double quote() {
    	return this.quote;
    }
    public double price() {
        return this.timePeriod().duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }
}
