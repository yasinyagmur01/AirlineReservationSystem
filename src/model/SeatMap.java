package model;

import java.util.HashSet;
import java.util.Set;

public class SeatMap {

    //fields
    private final Set<String> bookedSeats;
    private int rows;
    private int cols;

    //const
    public SeatMap(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive.");
        }
        if (cols > 26) {
            throw new IllegalArgumentException("Max columns 26 (A-Z)");
        }


        this.cols = cols;
        this.rows = rows;
        this.bookedSeats = new HashSet<>();
    }

    //---SEAT BOOKING---
    public void bookSeat(int row, int col) {
        validate(row, col);
        String key = key(row, col);
        if (!bookedSeats.add(key)) {
            throw new IllegalStateException("Seat already booked: " + toSeatLabel(row, col));
        }
    }

    //---CANCEL SEAT---
    public void cancelSeat(int row, int col) {
        validate(row, col);
        bookedSeats.remove(key(row, col));
    }

    //---SEAT STATUS---
    public SeatStatus getSeatStatus(int row, int col) {
        validate(row, col);
        return bookedSeats.contains(key(row, col))
                ? SeatStatus.BOOKED
                : SeatStatus.AVAILABLE;
    }

    public void printSeatMap() {

        //header
        System.out.print("        ");
        for (int c = 0; c < cols; c++) {
            System.out.print((char) ('A' + c) + " ");
        }
        System.out.println();


        //row
        for (int r = 0; r < rows; r++) {
            System.out.printf("Row %-2d; ", r + 1);


            for (int c = 0; c < cols; c++) {
                char symbol = bookedSeats.contains(key(r, c)) ? 'X' : 'O';
                System.out.print(symbol + " ");
            }

            System.out.println();

        }

    }


    //---HELPERS---
    private void validate(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid seat position.");
        }
    }

    private String key(int row, int col) {
        return row + ":" + col;
    }

    private String toSeatLabel(int row, int col) {
        return (row + 1) + String.valueOf((char) ('A' + col));
    }

    // --- SeatLabel-based overloads (for contact with reservation)---

   private int[] parseSeatLabel(String seatLabel){
        if(seatLabel==null) {
            throw new IllegalArgumentException("Seat label cannot be null");
        }

        String s = seatLabel.trim().toUpperCase();
        if(s.length()<2){
            throw new IllegalArgumentException("Invalid seat label: "+seatLabel);
        }

        //to convert
        char colChar = s.charAt(s.length()-1);
        int col = colChar - 'A';

        String rowPart = s.substring(0,s.length()-1);

        int rowNumber;
        try{
            rowNumber =Integer.parseInt(rowPart);
        } catch (NumberFormatException e){
            throw  new IllegalArgumentException("Invalid seat label: "+seatLabel);
        }

        int row = rowNumber-1; //1-based to 0-based
        validate(row,col);

        return new int[]{row,col};
   }

   public void bookSeat(String seatLabel){
        int[] rc = parseSeatLabel(seatLabel);
        bookSeat(rc[0],rc[1]);
   }

   public void cancelSeat(String seatLabel){
        int[] rc = parseSeatLabel(seatLabel);
        cancelSeat(rc[0],rc[1]);
   }

   public SeatStatus getSeatStatus(String seatLabel){
        int[] rc = parseSeatLabel(seatLabel);
        return getSeatStatus(rc[0],rc[1]);
   }

   public boolean isAvailable(String seatLabel){
        return getSeatStatus(seatLabel) == SeatStatus.AVAILABLE;
   }




}



