import org.junit.*;
import static org.junit.Assert.*;

public class PlaceTest {

  @Test
  public void Place_instantiatesCorrectly_true() {
    Place myPlace = new Place("Costa Rica");
    assertEquals(true, myPlace instanceof Place);
  }

  @Test
  public void Place_instantiatesWithDestination_String() {
    Place myPlace = new Place("Costa Rica");
    assertEquals("Costa Rica", myPlace.getDestination());
  }
}
