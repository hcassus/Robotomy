package robotomy.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import robotomy.Robotomy;
import robotomy.domain.Direction;
import robotomy.domain.Rotation;
import robotomy.usecase.MoveRobotUsecase;
import robotomy.usecase.PlaceRobotUsecase;
import robotomy.usecase.ReportRobotPositionUsecase;
import robotomy.usecase.TurnRobotUsecase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Robotomy.class)
public class RobotControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @MockBean
  private PlaceRobotUsecase placeRobotUsecase;

  @MockBean
  private MoveRobotUsecase moveRobotUsecase;

  @MockBean
  private TurnRobotUsecase turnRobotUsecase;

  @MockBean
  private ReportRobotPositionUsecase reportRobotPositionUsecase;

  @Before
  public void setup(){
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void testPlaceRobot() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/robot/place/0/0/NORTH"));
    verify(placeRobotUsecase, times(1)).execute(0,0, Direction.NORTH);
  }

  @Test
  public void testMoveRobot() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/robot/move"));
    verify(moveRobotUsecase, times(1)).execute();
  }

  @Test
  public void testTurnRobotLeft() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/robot/turn/LEFT"));
    verify(turnRobotUsecase, times(1)).execute(Rotation.LEFT);
  }

  @Test
  public void testReport() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/robot/report"));
    verify(reportRobotPositionUsecase, times(1)).execute();
  }

}
