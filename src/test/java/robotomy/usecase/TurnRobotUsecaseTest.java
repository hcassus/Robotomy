package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static robotomy.domain.enumeration.Direction.EAST;
import static robotomy.domain.enumeration.Direction.SOUTH;
import static robotomy.domain.enumeration.Direction.WEST;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Rotation;

@RunWith(MockitoJUnitRunner.class)
public class TurnRobotUsecaseTest {

  private TurnRobotUsecase turnRobotUsecase;
  private Tabletop tabletop;

  @Before
  public void setup(){
    tabletop = new Tabletop(5, 5);
    turnRobotUsecase = new TurnRobotUsecase(tabletop);
  }

  @Test
  public void testTurnRobotLeft(){
    Robot robot = new Robot();
    robot.setDirection(SOUTH);
    tabletop.setRobot(robot);

    turnRobotUsecase.execute(Rotation.LEFT);

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(EAST));
  }

  @Test
  public void testFullRightTurnRobot(){
    Robot robot = new Robot();
    Direction direction = WEST;
    robot.setDirection(direction);
    tabletop.setRobot(robot);

    perform360DegreeTurn(Rotation.RIGHT);

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
  }

  @Test
  public void testFullLeftTurnRobot(){
    Robot robot = new Robot();
    Direction direction = WEST;
    robot.setDirection(direction);
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
