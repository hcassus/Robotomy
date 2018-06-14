package robotomy.usecase;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.MoveValidator;

@Component
@RequiredArgsConstructor
public class MoveRobotUsecase {

  private final Tabletop tabletop;
  private final MoveValidator moveValidator;

  public void execute() {
    Optional<Robot> optionalRobot = Optional.ofNullable(tabletop.getRobot());
    if (optionalRobot.isPresent()) {
      Robot robot = moveRobot(optionalRobot.get());
      tabletop.setRobot(robot);
    }
  }

  private Robot moveRobot(Robot robot) {
    Direction direction = robot.getDirection();

    int finalPositionX = robot.getPositionX() + direction.getPositionOffsetX();
    int finalPositionY = robot.getPositionY() + direction.getPositionOffsetY();

    if (moveValidator.isValidMove(finalPositionX, finalPositionY)) {
      robot.setPositionX(finalPositionX);
      robot.setPositionY(finalPositionY);
    }

    return robot;
  }
}