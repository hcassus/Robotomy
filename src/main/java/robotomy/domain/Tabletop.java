package robotomy.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Data
@RequestScope
public class Tabletop {

  private final Integer maxIndexX;
  private final Integer maxIndexY;
  private Robot robot;
  public Tabletop(
      @Value("${robotomy.tabletop.sizeX}") Integer sizeX,
      @Value("${robotomy.tabletop.sizeY}") Integer sizeY) {
    this.maxIndexX = sizeX - 1;
    this.maxIndexY = sizeY - 1;
  }

}
