/**
 * 
 */
package com.game.tambola.validators;

import java.util.List;
import java.util.Set;

import com.game.tambola.TambolaTicket;
import com.game.tambola.models.ClaimResult;

/**
 * The Class FullHouseValidator.
 */
public class FullHouseValidator implements ClaimValidator {


	/**
	 * Validate Full House.
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
		boolean isValid = announcedNumbers.containsAll(allNumbers);
		return new ClaimResult(isValid, isValid ? "Full House completed" : "Full House rejected");
	}

}
