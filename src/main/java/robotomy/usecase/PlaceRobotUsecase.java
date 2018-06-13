package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;
import robotomy.domain.enumeration.Direction;

@Component
@RequiredArgsConstructor
public class PlaceRobotUsecase {

  private final Tabletop tabletop;

  public void execute(Integer posX, Integer posY, Direction direction){
    Robot robot = new Robot();
    robot.setPositionX(posX);
    robot.setPositionY(posY);
    robot.setDirection(direction);
    tabletop.setRobot(robot);
  }
}
