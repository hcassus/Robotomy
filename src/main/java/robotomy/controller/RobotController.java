package robotomy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import robotomy.domain.enumeration.Direction;
import robotomy.domain.enumeration.Rotation;
import robotomy.usecase.MoveRobotUsecase;
import robotomy.usecase.PlaceRobotUsecase;
import robotomy.usecase.ReportRobotPositionUsecase;
import robotomy.usecase.TurnRobotUsecase;

@RestController
@RequestMapping(value = "/robot/")
@RequiredArgsConstructor
public class RobotController {

  private final PlaceRobotUsecase placeRobotUsecase;
  private final MoveRobotUsecase moveRobotUsecase;
  private final TurnRobotUsecase turnRobotUsecase;
  private final ReportRobotPositionUsecase reportRobotPositionUsecase;

  @RequestMapping(value = "/place/{posX}/{posY}/{direction}", method = RequestMethod.POST)
  public void placeRobot(
      @PathVariable("posX") Integer posX,
      @PathVariable("posY") Integer posY,
      @PathVariable("direction") Direction direction){
    placeRobotUsecase.execute(posX, posY, direction);
  }

  @RequestMapping(value = "/move", method = RequestMethod.POST)
  public void move(){
    moveRobotUsecase.execute();
  }

  @RequestMapping(value = "/turn/{rotation}", method = RequestMethod.POST)
  public void turn(@PathVariable("rotation") Rotation rotation){
    turnRobotUsecase.execute(rotation);
  }

  @RequestMapping(value = "/report", method = RequestMethod.GET)
  public String report(){
    return reportRobotPositionUsecase.execute();
  }

}
