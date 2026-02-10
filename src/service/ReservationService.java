package service;

import model.Flight;
import model.Passenger;
import model.Reservation;
import util.PNRGenerator;

import java.util.HashMap;
import java.util.Map;

public class ReservationService {
    //pnr-->reservations
    private Map<String, Reservation> reservations;
    private final PNRGenerator pnrGenerator;

    public ReservationService(){
        reservations = new HashMap<>();
        pnrGenerator = new PNRGenerator();
    }

    public Reservation createReservations(Passenger p, Flight f, String seatLabel){
       String pnr = pnrGenerator.nextPNR();
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
