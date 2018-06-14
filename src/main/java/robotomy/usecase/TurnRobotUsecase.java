package robotomy.usecase;

import java.util.Optional;
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
    Optional<Robot> optionalRobot = Optional.ofNullable(tabletop.getRobot());
    if (optionalRobot.isPresent()) {
      Robot robot = optionalRobot.get();
      Direction direction = calculateNewDirection(robot, rotation);
      robot.setDirection(direction);
    }
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
