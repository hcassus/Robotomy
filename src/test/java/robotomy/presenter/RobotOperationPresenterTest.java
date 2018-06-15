package robotomy.presenter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;

public class RobotOperationPresenterTest {

  private RobotOperationPresenter robotOperationPresenter;
  private Tabletop tabletop;

  @Before
  public void setup() {
    tabletop = new Tabletop(5,5);
    robotOperationPresenter = new RobotOperationPresenter(tabletop);
  }

  @Test
  public void testPresenterWithRobot() {
    Robot robot = new Robot(1, 2, Direction.NORTH);

    robotOperationPresenter.storeRobotState(robot);

    assertThat(robotOperationPresenter.present(), is("1,2,NORTH"));
  }

  @Test
  public void testPresenterWithNoRobot() {
    assertThat(robotOperationPresenter.present(), is("ROBOT MISSING"));
  }

  @Test
  public void testPresenterWithRobotWithoutReport(){
    Robot robot = new Robot(1, 2, Direction.NORTH);

    tabletop.setRobot(robot);

    assertThat(robotOperationPresenter.present(), is(""));
  }

}
