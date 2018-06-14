package robotomy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import robotomy.usecase.OperateRobotUsecase;

@RestController
@RequestMapping(value = "/robot")
@RequiredArgsConstructor
public class RobotRawController {

  private final OperateRobotUsecase operateRobotUsecase;

  @RequestMapping(value = "/operate/raw", method = RequestMethod.POST)
  public String operateRobot(@RequestBody String commands) {
    return operateRobotUsecase.execute(commands);
  }

}
