/**
 * 
 */
package com.game.tambola.validators;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.game.tambola.TambolaTicket;
import com.game.tambola.models.ClaimResult;

/**
 * The Class EarlyFiveValidator.
 */
public class EarlyFiveValidator implements ClaimValidator {


	/**
	 * Validate Early five.
	 *
	 * @param tambolaTicket the tambola ticket
	 * @param announcedNumbers the announced numbers
	 * @return the claim result
	 */
	@Override
	public ClaimResult validate(TambolaTicket tambolaTicket, List<Integer> announcedNumbers) {

		if (tambolaTicket == null) {
			return new ClaimResult(false, "Ticket cannot be null");
		}

		if (announcedNumbers == null || announcedNumbers.isEmpty()) {
			return new ClaimResult(false, "No numbers announced");
		}

		Set<Integer> allNumbers = tambolaTicket.getAllNumbers();

		Set<Integer> crossedNumbers = announcedNumbers.stream().filter(allNumbers::contains)
				.collect(Collectors.toSet());

		boolean isValid = crossedNumbers.size() >= 5;
		return new ClaimResult(isValid, isValid ? "Early five completed" : "Early five rejected");
	}

}
