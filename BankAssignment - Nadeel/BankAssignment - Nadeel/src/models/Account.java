package models;

public abstract class Account {

    private String id;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String phoneNumber;
    private double balance;
    private final double INTEREST_RATE = 0;
    private final int TIMES_PER_YEAR = 0;

    public Account(String id, String firstName, String lastName, String dob, String address, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }

    public int getTimesPerYear() {
        return TIMES_PER_YEAR;
    }
}
