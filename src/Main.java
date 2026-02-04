public static void main(String[] args) {

    Flight f = new Flight(
            "TK101",
            "Ankara",
            "Istanbul",
            LocalDateTime.of(2026, 3, 1, 14, 30),
            5,
            6
    );
    System.out.println();
    System.out.println();

    System.out.println(f);



    System.out.println();
    System.out.println();


    f.getSeatMap().bookSeat(0, 0);
    f.getSeatMap().bookSeat(1, 2);

    f.getSeatMap().printSeatMap();



    System.out.println();
    System.out.println();



    // --- Passenger oluştur ---
    Passenger passenger = new Passenger("P001", "Ahmet", "Yılmaz");

    // --- Flight oluştur ---
    Flight flight = new Flight(
            "TK101",
            "Ankara",
            "Istanbul",
            LocalDateTime.of(2026, 3, 1, 14, 30),
            5,
            6
    );

    // --- Reservation oluştur ---
    Reservation r = new Reservation("AB123", passenger, flight, "3C");

    // --- Çıktı ---
    System.out.println(r);

    // Check-in yap
    r.checkIn();
    System.out.println(r);

    // İptal et
    r.cancel();
    System.out.println(r);
}