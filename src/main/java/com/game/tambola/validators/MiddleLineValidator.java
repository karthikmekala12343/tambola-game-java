/**
 * 
 */
package com.game.tambola.validators;

import java.util.List;
import java.util.Set;

import com.game.tambola.TambolaTicket;
import com.game.tambola.models.ClaimResult;

/**
 * The Class MiddleLineValidator.
 */
public class MiddleLineValidator implements ClaimValidator {


	/**
	 * Validate Middle Line.
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

		Set<Integer> rowNumbers = tambolaTicket.getRowNumber(1);
		boolean isValid = announcedNumbers.containsAll(rowNumbers);
		return new ClaimResult(isValid, isValid ? "Middle Line completed" : "Middle Line rejected");
	}

}
