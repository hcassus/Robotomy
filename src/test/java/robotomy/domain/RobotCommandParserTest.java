package robotomy.domain;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static robotomy.domain.enumeration.Direction.NORTH;
import static robotomy.domain.enumeration.Operation.MOVE;
import static robotomy.domain.enumeration.Operation.PLACE;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import robotomy.domain.operation.PlaceOperation;
import robotomy.domain.operation.RobotOperation;

public class RobotCommandParserTest {

  private RobotCommandParser robotCommandParser;

  @Before
  public void setup() {
    robotCommandParser = new RobotCommandParser();
  }

  @Test
  public void testParsePlaceOperations() {
    List<RobotOperation> operations = robotCommandParser.parseCommands("PLACE 1,0,NORTH");

    PlaceOperation operation = (PlaceOperation) operations.get(0);

    assertThat(operation.getOperation(), is(PLACE));
    assertThat(operation.getPosX(), is(1));
    assertThat(operation.getPosY(), is(0));
    assertThat(operation.getDirection(), is(NORTH));
  }

  @Test
  public void testParseBasicOperations() {
    List<RobotOperation> operations = robotCommandParser.parseCommands("MOVE");

    RobotOperation operation = operations.get(0);

    assertThat(operation.getOperation(), is(MOVE));
  }

  @Test
  public void testParseInvalidPlaceOperation() {
    List<RobotOperation> operations = robotCommandParser.parseCommands("PLACE 0,0,NOITH");

    assertThat(operations.size(), is(0));
  }

  @Test
  public void testParseInvalidBasicOperations() {
    List<RobotOperation> operations = robotCommandParser.parseCommands("INVALID");

    assertThat(operations.size(), is(0));
  }

}