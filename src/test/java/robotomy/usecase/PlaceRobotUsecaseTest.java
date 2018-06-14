package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static robotomy.domain.enumeration.Direction.NORTH;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.validator.MoveValidator;

@RunWith(MockitoJUnitRunner.class)
public class PlaceRobotUsecaseTest {

  private PlaceRobotUsecase placeRobotUsecase;
  private Tabletop tabletop;
  private MoveValidator validator;


  @Before
  public void setup() {
    tabletop = new Tabletop(5, 5);
    validator = new MoveValidator(tabletop);
    placeRobotUsecase = new PlaceRobotUsecase(tabletop, validator);
  }

  @Test
  public void testRobotPlacement() {
    Direction direction = NORTH;
    int positionX = 0;
    int positionY = 1;

    placeRobotUsecase.execute(positionX, positionY, direction);

    Robot robot = tabletop.getRobot();
    Assert.assertThat(robot, notNullValue());
    Assert.assertThat(robot.getPositionX(), is(positionX));
    Assert.assertThat(robot.getPositionY(), is(positionY));
    Assert.assertThat(robot.getDirection(), is(direction));
  }

  @Test
  public void testInvalidRobotPlacement() {
    int positionX = 5;
    int positionY = 5;

    placeRobotUsecase.execute(positionX, positionY, NORTH);

    Robot robot = tabletop.getRobot();
    Assert.assertThat(robot, nullValue());
  }

}
