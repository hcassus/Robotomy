package robotomy.domain.entities;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Tabletop {

  public Tabletop(
      @Value("${robotomy.tabletop.sizeX}") Integer sizeX,
      @Value("${robotomy.tabletop.sizeY}") Integer sizeY){
    this.sizeX = sizeX;
    this.sizeY = sizeY;
  }

  private final Integer sizeX;
  private final Integer sizeY;
  private Robot robot;

}
