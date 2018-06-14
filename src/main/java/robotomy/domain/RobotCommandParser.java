package robotomy.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Operation;
import robotomy.domain.operation.PlaceOperation;
import robotomy.domain.operation.RobotOperation;

@Component
public class RobotCommandParser {

  private static final String PLACE_COMMAND_MATCHER = "PLACE [0-9],[0-9],[A-Z]{4,5}";
  private static final String COMMAND_ARGS_SPLIT_REGEX = "(\\s|,)";
  private static final String COMMAND_SEPARATOR = "\n";

  public List<RobotOperation> parseCommands(String operations) {
    List<RobotOperation> robotOperations = new ArrayList<>();
    String[] stringOperations = operations.split(COMMAND_SEPARATOR);

    Arrays.stream(stringOperations)
        .forEach(command -> {
          try {
            robotOperations.add(convertCommand(command));
          } catch (IllegalArgumentException e) {
            e.printStackTrace();
          }
        });

    return robotOperations;
  }

  private RobotOperation convertCommand(String stringOperation) {
    if (stringOperation.matches(PLACE_COMMAND_MATCHER)) {
      return generatePlaceOperation(stringOperation);
    } else {
      return new RobotOperation(Operation.valueOf(stringOperation));
    }
  }

  private PlaceOperation generatePlaceOperation(String stringOperation) {
    String[] placeCommand = stringOperation.split(COMMAND_ARGS_SPLIT_REGEX);
    Operation operationAction = Operation.valueOf(placeCommand[0]);
    Integer posX = Integer.parseInt(placeCommand[1]);
    Integer posY = Integer.parseInt(placeCommand[2]);
    Direction direction = Direction.valueOf(placeCommand[3]);

    return new PlaceOperation(operationAction, posX, posY, direction);
  }

}
