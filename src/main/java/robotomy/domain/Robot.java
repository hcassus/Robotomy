package robotomy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import robotomy.domain.enumeration.Direction;

@Data
@AllArgsConstructor
public class Robot implements Cloneable {

  private Integer positionX;
  private Integer positionY;
  private Direction direction;

  @Override
  public Robot clone(){
    Robot clone = null;
    try {
      clone =  (Robot) super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }

}
