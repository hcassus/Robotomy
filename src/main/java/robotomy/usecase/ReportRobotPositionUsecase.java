package robotomy.usecase;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.entities.Robot;
import robotomy.domain.entities.Tabletop;

@Component
@RequiredArgsConstructor
public class ReportRobotPositionUsecase {

  private final Tabletop tabletop;

  public String execute(){
    Optional<Robot> optionalRobot = Optional.ofNullable(tabletop.getRobot());
    String report = "ROBOT MISSING";
    if (optionalRobot.isPresent()){
      Robot robot = optionalRobot.get();
      report = String.format("%s,%s,%s", robot.getPositionX(), robot.getPositionY(), robot.getDirection());
    }
    return report;
  }
}
