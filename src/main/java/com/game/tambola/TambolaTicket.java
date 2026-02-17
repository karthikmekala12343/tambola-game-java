package com.game.tambola;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The Class TambolaTicket.
 */
public class TambolaTicket {

	/** The rows. */
	private final List<Set<Integer>> rows;
	
	/** The all numbers. */
	private final Set<Integer> allNumbers;

	/**
	 * Instantiates a new tambola ticket.
	 *
	 * @param rows the rows
	 */
	public TambolaTicket(List<Set<Integer>> rows) {
		this.rows = rows;
		this.allNumbers = rows.stream().flatMap(Set::stream).collect(Collectors.toSet());
	}

	/**
	 * Gets the row number.
	 *
	 * @param index the index
	 * @return the row number
	 */
	public Set<Integer> getRowNumber(int index) {
		return Collections.unmodifiableSet(rows.get(index));
	}

	/**
	 * Gets the all numbers.
	 *
	 * @return the all numbers
	 */
	public Set<Integer> getAllNumbers() {
		return Collections.unmodifiableSet(allNumbers);
	}

	
	/**
	 * Parses the ticket rows.
	 *
	 * @param ticketRows the ticket rows
	 * @return the tambola ticket
	 */
	public static TambolaTicket parseTicketRows(List<String> ticketRows) {
		List<Set<Integer>> rows = ticketRows.stream()
				.map(rowStr -> Arrays.stream(rowStr.split(","))
						.map(s -> s.equals("_") ? null : Integer.parseInt(s.trim())).filter(Objects::nonNull)
						.collect(Collectors.toSet()))
				.collect(Collectors.toList());
		return new TambolaTicket(rows);
	}
}
