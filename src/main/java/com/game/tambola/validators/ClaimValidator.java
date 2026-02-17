/**
 * 
 */
package com.game.tambola.validators;

import java.util.List;

import com.game.tambola.TambolaTicket;
import com.game.tambola.models.ClaimResult;

/**
 * 
 */
public interface ClaimValidator {

	/**
	 * Validate.
	 *
	 * @param tambolaTicket the tambola ticket
	 * @param announcedNumbers the announced numbers
	 * @return the claim result
	 */
	ClaimResult validate(TambolaTicket tambolaTicket, List<Integer> announcedNumbers);
}
