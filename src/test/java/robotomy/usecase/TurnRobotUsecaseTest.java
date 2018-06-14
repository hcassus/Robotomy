package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static robotomy.domain.enumeration.Direction.EAST;
import static robotomy.domain.enumeration.Direction.NORTH;
import static robotomy.domain.enumeration.Direction.WEST;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Rotation;

@RunWith(MockitoJUnitRunner.class)
public class TurnRobotUsecaseTest {

  private TurnRobotUsecase turnRobotUsecase;
  private Tabletop tabletop;

  @Before
  public void setup() {
    tabletop = new Tabletop(5, 5);
    turnRobotUsecase = new TurnRobotUsecase(tabletop);
  }

  @Test
  public void testTurnRobotLeft() {
    Robot robot = new Robot(0, 1, NORTH);
    tabletop.setRobot(robot);

    turnRobotUsecase.execute(Rotation.RIGHT);

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(EAST));
  }

  @Test
  public void testFullRightTurnRobot() {
    Direction direction = WEST;
    Robot robot = new Robot(2, 3, direction);
    tabletop.setRobot(robot);

    perform360DegreeTurn(Rotation.RIGHT);

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
  }

  @Test
  public void testFullLeftTurnRobot() {
    Direction direction = WEST;
    Robot robot = new Robot(4, 3, direction);
    tabletop.setRobot(robot);

    perform360DegreeTurn(Rotation.LEFT);

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
  }

  private void perform360DegreeTurn(Rotation rotation) {
    turnRobotUsecase.execute(rotation);
    turnRobotUsecase.execute(rotation);
    turnRobotUsecase.execute(rotation);
    turnRobotUsecase.execute(rotation);
  }

}
