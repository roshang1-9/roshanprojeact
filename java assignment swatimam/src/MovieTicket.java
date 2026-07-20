/**
 * MovieTicket models a simple ticket inventory for a movie/show.
 * It keeps track of seat price and available seats and provides
 * methods to buy and refund tickets.
 */
public class MovieTicket {
    private double seatPrice;
    private int availableSeats;

    public MovieTicket() {
        this.seatPrice = 0.0;
        this.availableSeats = 0;
    }

    public MovieTicket(double seatPrice, int availableSeats) {
        if (seatPrice < 0) throw new IllegalArgumentException("seatPrice cannot be negative");
        if (availableSeats < 0) throw new IllegalArgumentException("availableSeats cannot be negative");
        this.seatPrice = seatPrice;
        this.availableSeats = availableSeats;
    }

    public synchronized double buyTickets(int quantity) throws InsufficientSeatsException {
        if (quantity <= 0) throw new IllegalArgumentException("quantity must be positive");
        if (quantity > availableSeats) {
            throw new InsufficientSeatsException("Requested " + quantity + " but only " + availableSeats + " available");
        }
        availableSeats -= quantity;
        return quantity * seatPrice;
    }

    public synchronized double refundTickets(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("quantity must be positive");
        availableSeats += quantity;
        return quantity * seatPrice;
    }

    public synchronized int getAvailableSeats() {
        return availableSeats;
    }

    public synchronized double getSeatPrice() {
        return seatPrice;
    }

    public synchronized void setSeatPrice(double seatPrice) {
        if (seatPrice < 0) throw new IllegalArgumentException("seatPrice cannot be negative");
        this.seatPrice = seatPrice;
    }

    public synchronized void setAvailableSeats(int seats) {
        if (seats < 0) throw new IllegalArgumentException("availableSeats cannot be negative");
        this.availableSeats = seats;
    }

    public synchronized void displayStatus() {
        System.out.printf("MovieTicket: seatPrice=%.2f, availableSeats=%d%n", seatPrice, availableSeats);
    }

    @Override
    public synchronized String toString() {
        return String.format("MovieTicket[seatPrice=%.2f, availableSeats=%d]", seatPrice, availableSeats);
    }

    public static class InsufficientSeatsException extends Exception {
        public InsufficientSeatsException(String message) { super(message); }
    }
}
