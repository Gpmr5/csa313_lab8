package edu.sc.csce747.MeetingPlanner;


import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class CalendarTest {
	// Add test methods here. 
	// You are not required to write tests for all classes.
	private Calendar calendar;
	@Before
	public void setUp() {
    	calendar = new Calendar();
	}
	@Test
	public void testAddMeeting_holiday() {
		// Create Midsommar holiday
		// Add to calendar object.
		try {
			Meeting midsommar = new Meeting(6, 26, "Midsommar");
			calendar.addMeeting(midsommar);
			// Verify that it was added.
			Boolean added = calendar.isBusy(6, 26, 0, 23);
			assertTrue("Midsommar should be marked as busy on the calendar",added);
		} catch(TimeConflictException e) {
			fail("Should not throw exception: " + e.getMessage());
		}
	}
	public testAddMeeting_conflict(){
		try {
			Meeting meeting1 = new Meeting(5,10,10,12, "Team Sync");
			Meeting meeting2 = new Meeting(5,10,11,13, "Client call");
			calendar.addMeeting(meeting1);
			calendar.addMeeting(meeting2);
			fail("Should throw TimeConflictException due to overlap");

		} catch (TimeConflictException e) {
			assertTrue(e.getMessage().contains("Overlap with another item"));
		}
	}


	
}
