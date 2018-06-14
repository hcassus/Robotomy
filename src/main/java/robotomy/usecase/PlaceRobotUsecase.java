package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;
import robotomy.domain.enumeration.Direction;
import robotomy.validator.MoveValidator;

@Component
@RequiredArgsConstructor
public class PlaceRobotUsecase {

  private final Tabletop tabletop;
  private final MoveValidator validator;

  public void execute(Integer posX, Integer posY, Direction direction) {
    if (validator.isValidMove(posX, posY)) {
      tabletop.setRobot(new Robot(posX, posY, direction));
    }
  }
}
