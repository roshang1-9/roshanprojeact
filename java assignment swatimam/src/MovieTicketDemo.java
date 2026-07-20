public class MovieTicketDemo {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket(150.0, 50);
        mt.displayStatus();

        try {
            double cost = mt.buyTickets(3);
            System.out.println("Bought 3 tickets, cost=" + cost);
        } catch (MovieTicket.InsufficientSeatsException e) {
            System.out.println("Could not buy tickets: " + e.getMessage());
        }

        mt.displayStatus();

        double refund = mt.refundTickets(2);
        System.out.println("Refunded 2 tickets, amount=" + refund);

        mt.displayStatus();
    }
}
