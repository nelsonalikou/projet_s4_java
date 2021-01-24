package chess.util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class PositionTest {

	private Position[] positions = new Position[6] ;

	@Before
	public void setUp() throws IllegalArgumentException {

		positions[0] = new Position("E5");
		positions[1] = new Position(5,6);
		positions[2] = new Position(4,5);
		positions[3] = new Position(6,7);
		positions[4] = new Position(5,5);
		positions[5] = new Position(5,5);

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


	@Test
    public void should_be_equals() throws Exception {

        /* Reflexive */
		assertTrue(positions[0].equals(positions[0]));
		assertTrue(positions[4].equals(positions[4]));
		assertTrue(positions[5].equals(positions[5]));

        /* Symmetric */
		assertTrue(positions[0].equals(positions[4]));
		assertTrue(positions[4].equals(positions[0]));

        /* Transitive */
		assertTrue(positions[0].equals(positions[4]));
		assertTrue(positions[4].equals(positions[5]));
		assertTrue(positions[0].equals(positions[5]));

        assertFalse(positions[0].equals(null));
        assertFalse(positions[4].equals(null));
        assertFalse(positions[5].equals(null));

    }


	@Test
    public void testHashSet() throws Exception {

        final Set<Position> Positions = new HashSet<>();
        Positions.add(positions[0]);

        assertEquals(Positions.iterator().next(),positions[4]);
        assertTrue(Positions.contains(positions[4]));
    }

    @Test
    public void testHashMap() throws Exception {

        final Map<Integer, Position> map = new HashMap<>();
        map.put(2, positions[0]);

        assertEquals(1,map.size());
        //assertEquals(positions[4],map.keySet().iterator().next());
        assertEquals(positions[4],map.values().iterator().next());
        assertTrue(map.containsValue(positions[4]));
    }

    @Test
    public void should_not_contain_doubles() throws Exception {

        final Set<Position> Positions = new HashSet<>();
        Positions.add(positions[0]);
        Positions.add(positions[4]);

        assertTrue(positions[0].equals(positions[4]));
        assertEquals(1,Positions.size());
    }

}
