package pl.b2bnetwork.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build(); //mockowanie springa
    }

    @Test
    public void numberOfMainStarsCasiopea() throws Exception {
        List<User> userList = new ArrayList<>();
        User user1 = User.builder().login("User1").id(1L).noOfPublicRepos(3).build();
        userList.add(user1);
        Mockito.when(userService.findAllUsers()).thenReturn(userList);
        mockMvc.perform(MockMvcRequestBuilders.get("/findAll"))
                .andExpect(status().isNotFound());

    }

}