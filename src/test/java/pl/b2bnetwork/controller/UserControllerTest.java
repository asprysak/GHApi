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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.User;
import pl.b2bnetwork.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private List<User> userList = new ArrayList<>();

    @Before
    public void init() {

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        userList.add(User.builder().login("User1").id(1L).noOfPublicRepos(3).build());
        Mockito.when(userService.findAllUsers()).thenReturn(userList);
    }

    @Test
    public void findAllUsersTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/findAll"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("users", userList))
                .andExpect(view().name("userForm"));

    }

    @Test
    public void getHomeTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/home"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(model().attribute("users", userList))
                .andExpect(view().name("userHome"));

    }

}