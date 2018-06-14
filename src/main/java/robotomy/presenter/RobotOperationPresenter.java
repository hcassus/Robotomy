package robotomy.presenter;

import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import robotomy.domain.Robot;

@Component
@RequestScope
public class RobotOperationPresenter {

  private Robot robot;

  public void storeRobotState(Robot robot){
    Optional<Robot> optionalRobot = Optional.ofNullable(robot);
    optionalRobot.ifPresent(receivedRobot -> this.robot = receivedRobot.clone());
  }

  public String present() {
    String operationResultMessage;

    if (Optional.ofNullable(robot).isPresent()) {
      operationResultMessage = String
          .format("%s,%s,%s", robot.getPositionX(), robot.getPositionY(), robot.getDirection());
    } else {
      operationResultMessage = "ROBOT MISSING";
    }
    return operationResultMessage;
  }

}
