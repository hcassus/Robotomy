package robotomy.presenter;

import java.util.Optional;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import robotomy.domain.Robot;

@Component
@RequestScope
@Setter
public class RobotOperationPresenter {

  private Robot robot;

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
