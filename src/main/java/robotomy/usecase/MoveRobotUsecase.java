package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;
import robotomy.domain.enumeration.Direction;

@Component
@RequiredArgsConstructor
public class MoveRobotUsecase {

  private final Tabletop tabletop;

  public void execute(){
    Robot robot = moveRobot(tabletop.getRobot());
    tabletop.setRobot(robot);
  }

  private Robot moveRobot(Robot robot) {
    Integer posX = robot.getPositionX();
    Integer posY = robot.getPositionY();
    Direction direction = robot.getDirection();

    robot.setPositionX(posX + direction.getPositionOffsetX());
    robot.setPositionY(posY + direction.getPositionOffsetY());

    return robot;
  }
}