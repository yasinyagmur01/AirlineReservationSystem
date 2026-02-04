public static void main(String[] args) {

    SeatMap map = new SeatMap(5, 6);

    map.bookSeat(0, 0); // 1A
    map.bookSeat(1, 2); // 2C
    map.bookSeat(4, 5); // 5F

    map.printSeatMap();
}