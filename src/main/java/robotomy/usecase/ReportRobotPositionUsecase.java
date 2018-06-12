package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;

@Component
@RequiredArgsConstructor
public class ReportRobotPositionUsecase {

  private final Tabletop tabletop;

  public String execute(){
    Robot robot = tabletop.getRobot();
    return String.format("%s,%s,%s", robot.getPositionX(), robot.getPositionY(), robot.getDirection());
  }
}
