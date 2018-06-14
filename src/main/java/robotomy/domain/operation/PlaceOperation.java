package robotomy.domain.operation;

import lombok.Getter;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Operation;

@Getter
public class PlaceOperation extends RobotOperation {

  Integer posX;
  Integer posY;
  Direction direction;

  public PlaceOperation(Operation stringOperation, Integer posX, Integer posY,
      Direction direction) {
    this.operation = stringOperation;
    this.posX = posX;
    this.posY = posY;
    this.direction = direction;
  }
}
