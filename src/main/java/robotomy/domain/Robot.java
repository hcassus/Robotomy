package robotomy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import robotomy.domain.enumeration.Direction;

@Data
@AllArgsConstructor
public class Robot {

  private Integer positionX;
  private Integer positionY;
  private Direction direction;

}
