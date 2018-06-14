package robotomy.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import robotomy.domain.RobotCommandParser;
import robotomy.domain.enumeration.Rotation;
import robotomy.domain.operation.PlaceOperation;
import robotomy.domain.operation.RobotOperation;
import robotomy.presenter.RobotOperationPresenter;

@Component
@RequiredArgsConstructor
public class OperateRobotUsecase {

  private final RobotOperationPresenter robotOperationPresenter;
  private final MoveRobotUsecase moveRobotUsecase;
  private final PlaceRobotUsecase placeRobotUsecase;
  private final ReportRobotPositionUsecase reportRobotPositionUsecase;
  private final TurnRobotUsecase turnRobotUsecase;
  private final RobotCommandParser robotCommandParser;

  public String execute(String commands) {
    robotCommandParser.parseCommands(commands).forEach(this::performOperation);

    return robotOperationPresenter.present();
  }

  private void performOperation(RobotOperation operation) {
    switch (operation.getOperation()) {
      case MOVE:
        moveRobotUsecase.execute();
        break;
      case REPORT:
        reportRobotPositionUsecase.execute();
        break;
      case LEFT:
        turnRobotUsecase.execute(Rotation.LEFT);
        break;
      case RIGHT:
        turnRobotUsecase.execute(Rotation.RIGHT);
        break;
      case PLACE:
        PlaceOperation place = (PlaceOperation) operation;
        placeRobotUsecase.execute(place.getPosX(), place.getPosY(), place.getDirection());
        break;
    }
  }

}
