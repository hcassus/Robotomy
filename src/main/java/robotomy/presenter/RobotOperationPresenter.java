package robotomy.presenter;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import robotomy.domain.Robot;
import robotomy.domain.Tabletop;

@Component
@RequestScope
@RequiredArgsConstructor
public class RobotOperationPresenter {

  private final Tabletop tabletop;
  private Robot robotState;

  public void storeRobotState(Robot robot){
    Optional<Robot> optionalRobot = Optional.ofNullable(robot);
    optionalRobot.ifPresent(receivedRobot -> this.robotState = receivedRobot.clone());
  }

  public String present() {
    String operationResultMessage;

    boolean hasStoredState = Optional.ofNullable(robotState).isPresent();
    boolean isRobotPlaced = Optional.ofNullable(tabletop.getRobot()).isPresent();

    if (hasStoredState) {
      operationResultMessage = String
          .format("%s,%s,%s", robotState.getPositionX(), robotState.getPositionY(), robotState.getDirection());
    } else if (isRobotPlaced){
      operationResultMessage = "";
    } else {
      operationResultMessage = "ROBOT MISSING";
    }
    return operationResultMessage;
  }

}
