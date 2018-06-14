package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.Tabletop;
import robotomy.presenter.RobotOperationPresenter;

@Component
@RequiredArgsConstructor
public class ReportRobotPositionUsecase {

  private final Tabletop tabletop;
  private final RobotOperationPresenter presenter;

  public void execute() {
    presenter.storeRobotState(tabletop.getRobot());
  }
}
