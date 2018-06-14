package robotomy.usecase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static robotomy.domain.enumeration.Rotation.LEFT;

import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import robotomy.domain.RobotCommandParser;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Operation;
import robotomy.domain.enumeration.Rotation;
import robotomy.domain.operation.PlaceOperation;
import robotomy.domain.operation.RobotOperation;
import robotomy.presenter.RobotOperationPresenter;

@RunWith(MockitoJUnitRunner.class)
public class OperateRobotUsecaseTest {

  @InjectMocks
  private OperateRobotUsecase operateRobotUsecase;

  @Mock
  private ReportRobotPositionUsecase reportRobotPositionUsecase;

  @Mock
  private MoveRobotUsecase moveRobotUsecase;

  @Mock
  private TurnRobotUsecase turnRobotUsecase;

  @Mock
  private PlaceRobotUsecase placeRobotUsecase;

  @Mock
  private RobotCommandParser robotCommandParser;

  @Mock
  private RobotOperationPresenter robotOperationPresenter;

  @Test
  public void testOperateRobotReport() {
    String command = "REPORT";
    mockBasicOperations(command);

    operateRobotUsecase.execute(command);

    verify(reportRobotPositionUsecase, times(1)).execute();
    verify(robotCommandParser, times(1)).parseCommands(command);
    verify(robotOperationPresenter, times(1)).present();
  }

  @Test
  public void testOperateRobotMove() {
    String command = "MOVE";
    mockBasicOperations(command);

    operateRobotUsecase.execute(command);

    verify(moveRobotUsecase, times(1)).execute();
    verify(robotCommandParser, times(1)).parseCommands(command);
    verify(robotOperationPresenter, times(1)).present();
  }

  @Test
  public void testOperateRobotLeft() {
    String command = "LEFT";
    mockBasicOperations(command);

    operateRobotUsecase.execute(command);

    verify(turnRobotUsecase, times(1)).execute(LEFT);
    verify(robotCommandParser, times(1)).parseCommands(command);
    verify(robotOperationPresenter, times(1)).present();
  }

  @Test
  public void testOperateRobotRight() {
    String command = "RIGHT";
    mockBasicOperations(command);

    operateRobotUsecase.execute(command);

    verify(turnRobotUsecase, times(1)).execute(Rotation.RIGHT);
    verify(robotCommandParser, times(1)).parseCommands(command);
    verify(robotOperationPresenter, times(1)).present();
  }

  @Test
  public void testOperationRobotPlaceNorth() {
    String command = "PLACE 0,1,NORTH";
    when(robotCommandParser.parseCommands(command)).thenReturn(Arrays
        .asList(new PlaceOperation(Operation.PLACE, 0, 1, Direction.NORTH)));

    operateRobotUsecase.execute(command);

    verify(placeRobotUsecase, times(1)).execute(0, 1, Direction.NORTH);
    verify(robotCommandParser, times(1)).parseCommands(command);
    verify(robotOperationPresenter, times(1)).present();
  }

  @Test
  public void testOperationRobotPlaceSouth() {
    String command = "PLACE 2,3,SOUTH";
    when(robotCommandParser.parseCommands(command)).thenReturn(Arrays
        .asList(new PlaceOperation(Operation.PLACE, 2, 3, Direction.SOUTH)));

    operateRobotUsecase.execute(command);

    verify(placeRobotUsecase, times(1)).execute(2, 3, Direction.SOUTH);
    verify(robotCommandParser, times(1)).parseCommands(command);
    verify(robotOperationPresenter, times(1)).present();
  }

  private void mockBasicOperations(String command) {
    when(robotCommandParser.parseCommands(command)).thenReturn(Arrays
        .asList(new RobotOperation(Operation.valueOf(command))));
  }
}
