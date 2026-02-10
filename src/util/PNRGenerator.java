package util;

public class PNRGenerator {
    private int counter = 0;

    public String nextPNR(){
        return String.format("PNR%06d",counter++);
    }
}
