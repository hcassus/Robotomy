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
import robotomy.usecase.OperateRobotUsecase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = Robotomy.class)
public class RobotRawControllerTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext wac;

  @MockBean
  private OperateRobotUsecase operateRobotUsecase;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  public void testPlaceRobot() throws Exception {
    String operations = "PLACE 2,1,SOUTH\nMOVE\nREPORT";
    mockMvc.perform(MockMvcRequestBuilders.post("/robot/operate/raw").content(operations));
    verify(operateRobotUsecase, times(1)).execute(operations);
  }

}
