package robotomy.usecase;

import static org.hamcrest.Matchers.is;
import static robotomy.domain.enumeration.Direction.SOUTH;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;
import robotomy.domain.enumeration.Direction;

@RunWith(MockitoJUnitRunner.class)
public class ReportRobotUsecaseTest {

  private ReportRobotPositionUsecase reportRobotPositionUsecase;
  private Tabletop tabletop;

  @Before
  public void setup(){
    tabletop = new Tabletop(5, 5);
    reportRobotPositionUsecase = new ReportRobotPositionUsecase(tabletop);
  }

  @Test
  public void testReportRobot(){
    Direction direction = SOUTH;
    int positionX = 3;
    int positionY = 2;
    Robot robot = prepareRobot(direction, positionX, positionY);
    tabletop.setRobot(robot);

    String position = reportRobotPositionUsecase.execute();

    Assert.assertThat(position, is(String.format("%s,%s,%s", positionX, positionY, direction)));
  }

  private Robot prepareRobot(Direction direction, int positionX, int positionY) {
    Robot robot = new Robot();
    robot.setPositionX(positionX);
    robot.setPositionY(positionY);
    robot.setDirection(direction);
    return robot;
  }

}
