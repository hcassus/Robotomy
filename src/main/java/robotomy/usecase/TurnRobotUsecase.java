package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Rotation;

@Component
@RequiredArgsConstructor
public class TurnRobotUsecase {

  private static final int DIRECTION_COUNT = Direction.values().length;
  private final Tabletop tabletop;

  public void execute(Rotation rotation) {
    Robot robot = tabletop.getRobot();
    Direction direction = calculateNewDirection(robot, rotation);
    robot.setDirection(direction);
  }

  private Direction calculateNewDirection(Robot robot, Rotation rotation) {
    Integer ordinalDirection = calculateDirectionOrdinal(robot, rotation);
    return Direction.values()[ordinalDirection];
  }

  private int calculateDirectionOrdinal(Robot robot, Rotation rotation) {
    int newDirecionOrdinal =
        (robot.getDirection().ordinal() + rotation.getCardinalOffset()) % DIRECTION_COUNT;
    return newDirecionOrdinal >= 0 ? newDirecionOrdinal : newDirecionOrdinal + DIRECTION_COUNT;
  }

}
