package com.game.tambola.validators;

import java.util.Map;

import com.game.tambola.enums.ClaimType;

/**
 * A factory for creating ClaimValidator objects.
 */
public class ClaimValidatorFactory {

	/** The Constant claimValidators. */
	private static final Map<ClaimType, ClaimValidator> claimValidators = Map.of(
			ClaimType.TOP_LINE, new TopLineValidator(),
			ClaimType.MIDDLE_LINE, new MiddleLineValidator(),
			ClaimType.BOTTOM_LINE, new BottomLineValidator(),
			ClaimType.FULL_HOUSE, new FullHouseValidator(),
			ClaimType.EARLY_FIVE, new EarlyFiveValidator()
	);

	/**
	 * Gets the validator.
	 *
	 * @param claimType the claim type
	 * @return the validator
	 */
	public static ClaimValidator getValidator(ClaimType claimType) {
		ClaimValidator validator = claimValidators.get(claimType);
		if (validator == null) {
			throw new IllegalArgumentException("No validator found for claim type: " + claimType);
		}
		return validator;
	}
}
