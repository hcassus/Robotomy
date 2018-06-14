package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static robotomy.domain.enumeration.Direction.EAST;
import static robotomy.domain.enumeration.Direction.NORTH;
import static robotomy.domain.enumeration.Direction.SOUTH;
import static robotomy.domain.enumeration.Direction.WEST;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.MoveValidator;

@RunWith(MockitoJUnitRunner.class)
public class MoveRobotUsecaseTest {

  private MoveRobotUsecase moveRobotUsecase;
  private Tabletop tabletop;
  private MoveValidator validator;

  @Before
  public void setup() {
    tabletop = new Tabletop(5, 5);
    validator = new MoveValidator(tabletop);
    moveRobotUsecase = new MoveRobotUsecase(tabletop, validator);
  }

  @Test
  public void testMoveRobotNorth() {
    Integer posX = 4;
    Integer posY = 2;
    Direction direction = NORTH;
    Robot robot = new Robot(posX, posY, direction);
    tabletop.setRobot(robot);

    moveRobotUsecase.execute();

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
    Assert.assertThat(robot.getPositionX(), is(posX));
    Assert.assertThat(robot.getPositionY(), is(posY + 1));
  }

  @Test
  public void testInvalidMoveRobotNorth() {
    Integer posX = 4;
    Integer posY = 4;
    Direction direction = NORTH;
    Robot robot = new Robot(posX, posY, direction);
    tabletop.setRobot(robot);

    moveRobotUsecase.execute();

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
    Assert.assertThat(robot.getPositionX(), is(posX));
    Assert.assertThat(robot.getPositionY(), is(posY));
  }

  @Test
  public void testInvalidMoveRobotSouth() {
    Integer posX = 4;
    Integer posY = 0;
    Direction direction = SOUTH;
    Robot robot = new Robot(posX, posY, direction);
    tabletop.setRobot(robot);

    moveRobotUsecase.execute();

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
    Assert.assertThat(robot.getPositionX(), is(posX));
    Assert.assertThat(robot.getPositionY(), is(posY));
  }

  @Test
  public void testInvalidMoveRobotWest() {
    Integer posX = 0;
    Integer posY = 0;
    Direction direction = WEST;
    Robot robot = new Robot(posX, posY, direction);
    tabletop.setRobot(robot);

    moveRobotUsecase.execute();

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
    Assert.assertThat(robot.getPositionX(), is(posX));
    Assert.assertThat(robot.getPositionY(), is(posY));
  }

  @Test
  public void testInvalidMoveRobotEast() {
    Integer posX = 4;
    Integer posY = 3;
    Direction direction = EAST;
    Robot robot = new Robot(posX, posY, direction);
    tabletop.setRobot(robot);

    moveRobotUsecase.execute();

    robot = tabletop.getRobot();
    Assert.assertThat(robot.getDirection(), is(direction));
    Assert.assertThat(robot.getPositionX(), is(posX));
    Assert.assertThat(robot.getPositionY(), is(posY));
  }
}
