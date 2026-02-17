package com.game.tambola;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.game.tambola.enums.ClaimType;
import com.game.tambola.models.ClaimResult;

/**
 * The Class TambolaGameTest.
 */
public class TambolaGameTest {

	/**
	 * Test top line claim.
	 */
	@Test
	public void testTopLineClaim() {

		List<Integer> inputAnnouncedNumbers = List.of(90, 4, 46, 63, 89, 16, 76, 48);
		
		List<String> inputTicketLines = new ArrayList<>(List.of(
			    "4,16,_,_,48,_,63,76,_",
			    "7,_,23,38,_,52,_,_,80",
			    "9,_,25,_,_,56,64,_,83"
			));
		
			TambolaTicket tambolaTicket = TambolaTicket.parseTicketRows(inputTicketLines);
			TambolaGame tambolaGame = new TambolaGame(tambolaTicket);
			ClaimResult claimResult = tambolaGame.validateClaim(ClaimType.TOP_LINE, inputAnnouncedNumbers);
			
			assertTrue(claimResult.isAccepted());
			assertEquals("Top Line completed", claimResult.getReason());
	}
	
	/**
	 * Test top line claim denied.
	 */
	@Test
	public void testTopLineClaimDenied() {

		List<Integer> inputAnnouncedNumbers = List.of(90, 4, 46, 63, 89, 16, 76, 48, 12);
		
		List<String> inputTicketLines = new ArrayList<>(List.of(
			    "4,16,_,_,48,_,63,76,_",
			    "7,_,23,38,_,52,_,_,80",
			    "9,_,25,_,_,56,64,_,83"
			));
		
			TambolaTicket tambolaTicket = TambolaTicket.parseTicketRows(inputTicketLines);
			TambolaGame tambolaGame = new TambolaGame(tambolaTicket);
			ClaimResult claimResult = tambolaGame.validateClaim(ClaimType.TOP_LINE, inputAnnouncedNumbers);
			
			assertTrue(claimResult.isAccepted());
			assertEquals("Top Line completed", claimResult.getReason());
	}
	
	/**
	 * Test full house claim.
	 */
	@Test
	public void testFullHouseClaim() {

		List<Integer> inputAnnouncedNumbers = List.of(4, 16, 48, 63, 76, 7, 23, 38, 52, 80, 9, 25, 56, 64, 83);
		
		List<String> inputTicketLines = new ArrayList<>(List.of(
			    "4,16,_,_,48,_,63,76,_",
			    "7,_,23,38,_,52,_,_,80",
			    "9,_,25,_,_,56,64,_,83"
			));
		
			TambolaTicket tambolaTicket = TambolaTicket.parseTicketRows(inputTicketLines);
			TambolaGame tambolaGame = new TambolaGame(tambolaTicket);
			ClaimResult claimResult = tambolaGame.validateClaim(ClaimType.FULL_HOUSE, inputAnnouncedNumbers);
			
			assertTrue(claimResult.isAccepted());
			assertEquals("Full House completed", claimResult.getReason());
	}
	
	/**
	 * Test early five claim.
	 */
	@Test
	public void testEarlyFiveClaim() {

		List<Integer> inputAnnouncedNumbers = List.of(4, 16, 48, 63, 76);
		
		List<String> inputTicketLines = new ArrayList<>(List.of(
			    "4,16,_,_,48,_,63,76,_",
			    "7,_,23,38,_,52,_,_,80",
			    "9,_,25,_,_,56,64,_,83"
			));
		
			TambolaTicket tambolaTicket = TambolaTicket.parseTicketRows(inputTicketLines);
			TambolaGame tambolaGame = new TambolaGame(tambolaTicket);
			ClaimResult claimResult = tambolaGame.validateClaim(ClaimType.EARLY_FIVE, inputAnnouncedNumbers);
			
			assertTrue(claimResult.isAccepted());
			assertEquals("Early five completed", claimResult.getReason());
	}
}
