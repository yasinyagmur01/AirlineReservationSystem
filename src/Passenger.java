public class Passenger {

    private String id;
    private String firstName;
    private String lastName;

    public Passenger(String id, String firstName, String lastName) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Passenger ID cannot be empty");
        }

        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    //---GETTERS---
    public String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return id + " - " + getFullName();
    }


}


