package service;

import model.Flight;
import model.Passenger;
import model.Reservation;

import java.util.HashMap;
import java.util.Map;

public class ReservationService {
    //pnr-->reservations
    private Map<String, Reservation> reservations;

    public ReservationService(){
        reservations = new HashMap<>();
    }

    public Reservation createReservations(Passenger p, Flight f, String seatLabel){
        String pnr = "PNR"+reservations.size()+1;
        Reservation reservation = new Reservation(pnr,p,f,seatLabel);
        reservations.put(pnr,reservation);

        return reservation;
    }

    public Reservation getReservation(String pnr){
        return reservations.get(pnr.trim());
    }

    public boolean cancelReservation(String pnr){
        Reservation r = getReservation(pnr);
        if(r==null)return false;

        r.cancel();
        return true;
    }

    public boolean checkInPNR(String pnr){
        Reservation r = getReservation(pnr);
        if(r==null)return false;

        r.checkIn();
        return true;
    }



}
