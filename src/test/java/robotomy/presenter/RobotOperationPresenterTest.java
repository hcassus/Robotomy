package robotomy.presenter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import robotomy.domain.Robot;
import robotomy.domain.enumeration.Direction;

public class RobotOperationPresenterTest {

  private RobotOperationPresenter robotOperationPresenter;

  @Before
  public void setup() {
    robotOperationPresenter = new RobotOperationPresenter();
  }

  @Test
  public void testPresenterWithRobot() {
    Robot robot = new Robot(1, 2, Direction.NORTH);

    robotOperationPresenter.storeRobotState(robot);

    assertThat(robotOperationPresenter.present(), is("1,2,NORTH"));
  }

}
