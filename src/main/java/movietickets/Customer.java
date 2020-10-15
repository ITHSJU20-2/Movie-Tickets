package movietickets;

import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private int numberOfTickets;
    private List<String> seats;

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
        Main.getInstance().getConfirmation().getCustomerName().setText(name);
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
        Main.getInstance().getConfirmation().getCustomerEmail().setText(email);
    }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        Main.getInstance().getConfirmation().getCustomerNumber().setText(phoneNumber);
    }

    public int getNumberOfTickets() { return numberOfTickets; }
    public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
