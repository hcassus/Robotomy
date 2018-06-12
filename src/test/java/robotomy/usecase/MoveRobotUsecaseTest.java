package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static robotomy.domain.enumeration.Direction.NORTH;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;
import robotomy.domain.enumeration.Direction;

@RunWith(MockitoJUnitRunner.class)
public class MoveRobotUsecaseTest {

  private MoveRobotUsecase moveRobotUsecase;
  private Tabletop tabletop;

  @Before
  public void setup(){
    tabletop = new Tabletop(5, 5);
    moveRobotUsecase = new MoveRobotUsecase(tabletop);
  }

  @Test
  public void testMoveRobotNorth(){
    Integer posX = 4;
    Integer posY = 2;
    Direction direction = NORTH;
    Robot robot = prepareRobot(direction, posX, posY);
    tabletop.setRobot(robot);

    moveRobotUsecase.execute();

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
    Assert.assertThat(robot.getPositionX(), is(posX));
    Assert.assertThat(robot.getPositionY(), is(posY + 1));
  }

  private Robot prepareRobot(Direction direction, int positionX, int positionY) {
    Robot robot = new Robot();
    robot.setPositionX(positionX);
    robot.setPositionY(positionY);
    robot.setDirection(direction);
    return robot;
  }
}
