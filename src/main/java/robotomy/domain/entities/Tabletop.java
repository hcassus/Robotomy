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
    this.maxIndexX = sizeX - 1;
    this.maxIndexY = sizeY - 1;
  }

  private final Integer maxIndexX;
  private final Integer maxIndexY;
  private Robot robot;

}
