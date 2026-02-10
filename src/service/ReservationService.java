package service;

import model.Flight;
import model.Passenger;
import model.Reservation;
import model.SeatMap;
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
        SeatMap seatMap = f.getSeatMap();

        if(!seatMap.isAvailable(seatLabel)){
            throw new IllegalArgumentException("Seat not available: "+seatLabel);
        }
        seatMap.bookSeat(seatLabel);

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
        r.getFlight().getSeatMap().cancelSeat(r.getSeatLabel());
        return true;
    }

    public boolean checkInPNR(String pnr){
        Reservation r = getReservation(pnr);
        if(r==null)return false;

        r.checkIn();
        return true;
    }



}
