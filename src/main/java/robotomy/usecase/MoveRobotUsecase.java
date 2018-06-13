package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.validator.MoveValidator;

@Component
@RequiredArgsConstructor
public class MoveRobotUsecase {

  private final Tabletop tabletop;
  private final MoveValidator validator;

  public void execute(){
    Robot robot = moveRobot(tabletop.getRobot());
    tabletop.setRobot(robot);
  }

  private Robot moveRobot(Robot robot) {
    Direction direction = robot.getDirection();

    int finalPositionX = robot.getPositionX() + direction.getPositionOffsetX();
    int finalPositionY = robot.getPositionY() + direction.getPositionOffsetY();

    if (validator.isValidMove(finalPositionX, finalPositionY)){
      robot.setPositionX(finalPositionX);
      robot.setPositionY(finalPositionY);
    }


    return robot;
  }
}