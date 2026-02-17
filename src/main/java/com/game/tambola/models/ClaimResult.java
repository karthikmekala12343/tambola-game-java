package com.game.tambola.models;

/**
 * The Class ClaimResult.
 */
public class ClaimResult {

	private final boolean accepted;
	private final String reason;

	/**
	 * Instantiates a new claim result.
	 *
	 * @param accepted the accepted
	 * @param reason the reason
	 */
	public ClaimResult(boolean accepted, String reason) {
		this.accepted = accepted;
		this.reason = reason;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public String getReason() {
		return reason;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return accepted ? "Accepted" : "Rejected";
	}

}
