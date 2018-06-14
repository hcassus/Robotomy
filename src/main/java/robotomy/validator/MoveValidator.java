package robotomy.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.Tabletop;

@Component
@RequiredArgsConstructor
public class MoveValidator {

  private final Tabletop tabletop;

  public Boolean isValidMove(Integer xIntendedPosition, Integer yIntendedPosition) {
    return xIntendedPosition <= tabletop.getMaxIndexX() && yIntendedPosition <= tabletop
        .getMaxIndexY();
  }
}
