package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
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
public class PlaceRobotUsecaseTest {

  private PlaceRobotUsecase placeRobotUsecase;
  private Tabletop tabletop;

  @Before
  public void setup(){
    tabletop = new Tabletop(5, 5);
    placeRobotUsecase = new PlaceRobotUsecase(tabletop);
  }

  @Test
  public void testPlaceRobot(){
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

}
