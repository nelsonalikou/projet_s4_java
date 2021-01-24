package chess.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

	private Position[] positions = new Position[5] ;

	@Before
	public void setUp() throws IllegalArgumentException {

		positions[0] = new Position("E5");
		positions[1] = new Position(5,6);
		positions[2] = new Position(4,5);
		positions[3] = new Position(6,7);
		positions[4] = new Position(5,5);

	}

	@Test
	public void isOnSameLineAs_verification() {
		try {
			assertTrue(positions[0].isOnSameLineAs(positions[2]));
			//fail("IllegalArgumentException n'a pas été lancée");
			}
		catch (IllegalArgumentException e) {}
	}

	@Test
	public void isOnSameColumnAs_verification() {
		try {
			assertTrue(positions[0].isOnSameColumnAs(positions[1]));

			}
		catch (IllegalArgumentException e) {}
	}

	@Test
	public void isOnSameDiagonalAs_verification() {
		try {
			assertTrue(positions[2].isOnSameDiagonalAs(positions[3]));
			}
		catch (IllegalArgumentException e) {}
	}

	@Test
	public void getManhattanDistance_verification() {
		try {
			assertEquals(0, positions[0].getManhattanDistance(positions[4]));
			}
		catch (IllegalArgumentException e) {}
	}

	@Test
	public void toAlgebraicNotation_conversion() {
		try {
			assertEquals("E5", positions[4].toAlgebraicNotation());
			}
		catch (IllegalArgumentException e) {}
	}

}
