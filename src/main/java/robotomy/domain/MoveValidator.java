package robotomy.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoveValidator {

  private final Tabletop tabletop;

  public Boolean isValidMove(Integer xIntendedPosition, Integer yIntendedPosition) {
    return xIntendedPosition < tabletop.getSizeX() && yIntendedPosition < tabletop
        .getSizeY() && xIntendedPosition >= 0 && yIntendedPosition >= 0;
  }
}
