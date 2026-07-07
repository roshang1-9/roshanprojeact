package classobjectassignment;

import java.util.Scanner;

public class movieticketbook {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			MovieTicket ticket = new MovieTicket();

			System.out.print("Enter movie name: ");
			String movieName = sc.nextLine().trim();
			ticket.setMovieName(movieName);

			double price = -1.0;
			while (price < 0) {
				System.out.print("Enter ticket price (non-negative number): ");
				if (sc.hasNextDouble()) {
					price = sc.nextDouble();
					if (price < 0) {
						System.out.println("Ticket price cannot be negative. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter a numeric value.");
					sc.next();
				}
			}
			ticket.setTicketPrice(price);

			int count = -1;
			while (count < 0) {
				System.out.print("Enter number of tickets (non-negative integer): ");
				if (sc.hasNextInt()) {
					count = sc.nextInt();
					if (count < 0) {
						System.out.println("Number of tickets cannot be negative. Please try again.");
					}
				} else {
					System.out.println("Invalid input. Please enter an integer value.");
					sc.next();
				}
			}
			ticket.setNumberOfTickets(count);

			System.out.println();
			System.out.println("Movie Name: " + ticket.getMovieName());
			System.out.printf("Ticket Price: %.2f%n", ticket.getTicketPrice());
			System.out.println("Number of Tickets: " + ticket.getNumberOfTickets());
			System.out.printf("Total Cost: %.2f%n", ticket.getTotalCost());
		}
	}
}

class MovieTicket {
	private String movieName;
	private double ticketPrice;
	private int numberOfTickets;

	// Setters
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	// Getters
	public String getMovieName() {
		return movieName;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	// Calculate total cost; if tickets >= 5 give 5% discount
	public double getTotalCost() {
		double total = ticketPrice * numberOfTickets;
		if (numberOfTickets >= 5) {
			total = total - (total * 5.0 / 100.0);
		}
		return total;
	}
}
