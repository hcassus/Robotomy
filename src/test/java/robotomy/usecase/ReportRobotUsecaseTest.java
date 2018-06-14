package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static robotomy.domain.enumeration.Direction.SOUTH;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.presenter.RobotOperationPresenter;

@RunWith(MockitoJUnitRunner.class)
public class ReportRobotUsecaseTest {

  private ReportRobotPositionUsecase reportRobotPositionUsecase;
  private Tabletop tabletop;
  private RobotOperationPresenter robotOperationPresenter;

  @Before
  public void setup() {
    tabletop = new Tabletop(5, 5);
    robotOperationPresenter = new RobotOperationPresenter();
    reportRobotPositionUsecase = new ReportRobotPositionUsecase(tabletop, robotOperationPresenter);
  }

  @Test
  public void testReportRobot() {
    Direction direction = SOUTH;
    int positionX = 3;
    int positionY = 2;
    Robot robot = new Robot(positionX, positionY, direction);
    tabletop.setRobot(robot);

    reportRobotPositionUsecase.execute();

    Assert.assertThat(robotOperationPresenter.present(),
        is(String.format("%s,%s,%s", positionX, positionY, direction)));
  }

  @Test
  public void testReportMissingRobot() {
    reportRobotPositionUsecase.execute();

    Assert.assertThat(robotOperationPresenter.present(), is("ROBOT MISSING"));
  }

}
