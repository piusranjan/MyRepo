package com.airport.baggage;

public final class Baggage {

	private final Flight flight;

	public Flight getFlight() {
		return flight;
	}

	private Baggage(Flight flight) {
		super();

		this.flight = flight;

	}

	public static Baggage getInstance(Flight flight) {

		return new Baggage(flight);

	}

	@Override
	public String toString() {
		return "Baggage [flight=" + flight + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flight == null) ? 0 : flight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Baggage other = (Baggage) obj;
		if (flight == null) {
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		return true;
	}

}
