package com.game.tambola;

import java.util.List;

import com.game.tambola.enums.ClaimType;
import com.game.tambola.models.ClaimResult;
import com.game.tambola.validators.ClaimValidator;
import com.game.tambola.validators.ClaimValidatorFactory;

/**
 * The Class TambolaGame.
 */
public class TambolaGame {

	/** The tambola ticket. */
	private final TambolaTicket tambolaTicket;

	/**
	 * Instantiates a new tambola game.
	 *
	 * @param tambolaTicket the tambola ticket
	 */
	public TambolaGame(TambolaTicket tambolaTicket) {
		this.tambolaTicket = tambolaTicket;
	}

	/**
	 * Validate claim.
	 *
	 * @param claimType the claim type
	 * @param inputAnnouncedNumbers the input announced numbers
	 * @return the claim result
	 */
	public ClaimResult validateClaim(ClaimType claimType, List<Integer> inputAnnouncedNumbers) {
		try {
			ClaimValidator claimValidator = ClaimValidatorFactory.getValidator(claimType);
			return claimValidator.validate(tambolaTicket, inputAnnouncedNumbers);
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
			return new ClaimResult(false, "Invalid claim: " + iae.getMessage());
		}
	}

}
