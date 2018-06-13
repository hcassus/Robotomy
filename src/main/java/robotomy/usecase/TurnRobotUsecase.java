package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Rotation;

@Component
@RequiredArgsConstructor
public class TurnRobotUsecase {

  private final Tabletop tabletop;

  public void execute(Rotation rotation){
    Robot robot = tabletop.getRobot();
    Direction direction = calculateNewDirection(robot, rotation);
    robot.setDirection(direction);
  }

  private Direction calculateNewDirection(Robot robot, Rotation rotation) {
    Integer ordinalDirection = robot.getDirection().ordinal() + rotation.getCardinalOffset();
    return Direction.values()[ordinalDirection];
  }

}
