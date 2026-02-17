/**
 * 
 */
package com.game.tambola.enums;

/**
 * The Enum ClaimType.
 */
public enum ClaimType {

	TOP_LINE("Top Line", "The ticket with all the numbers of the top row crossed fastest"),
	MIDDLE_LINE("Middle Line", "The ticket with all the numbers of the middle row crossed fastest"),
	BOTTOM_LINE("Bottom Line", "The ticket with the numbers of the bottom row crossed fastest"),
	FULL_HOUSE("Full House", "The ticket with all the 15 numbers crossed first"),
	EARLY_FIVE("Early Five", "The fastest ticket to have 5 numbers crossed");

	private final String name;
	private final String description;

	/**
	 * Instantiates a new claim type.
	 *
	 * @param name the name
	 * @param description the description
	 */
	ClaimType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
