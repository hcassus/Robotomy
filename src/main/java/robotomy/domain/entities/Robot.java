package robotomy.domain.entities;

import lombok.Data;
import robotomy.domain.enumeration.Direction;

@Data
public class Robot {

  private Integer positionX;
  private Integer positionY;
  private Direction direction;

}
