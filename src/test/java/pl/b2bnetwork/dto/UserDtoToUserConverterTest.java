package pl.b2bnetwork.dto;

import org.junit.Before;
import org.junit.Test;
import pl.b2bnetwork.domain.User;

import java.sql.Date;

import static org.junit.Assert.*;

public class UserDtoToUserConverterTest {

    private UserDtoToUserConverter mapper = new UserDtoToUserConverter();
    private UserDto userDto;
    private User user;

    @Before
    public void init() {

        long id = 1;
        String login = "akowal";
        int noOfPublicRepos = 3;
        int noOfFollowers = 5;
        String dateOfCreatingAnAccount = "2013-05-14T21:17:56Z";
        String reposUrl = "/g/1";
        String avatarUrl = "/a/1";
        userDto = new UserDto(id, login, noOfPublicRepos, noOfFollowers, dateOfCreatingAnAccount,reposUrl,avatarUrl);

        user = User.builder()
                .id(id)
                .login(login)
                .noOfPublicRepos(noOfPublicRepos)
                .followers(noOfFollowers)
                .dateOfCreatingAnAccount(Date.valueOf("2013-05-14"))
                .reposUrl(reposUrl)
                .avatarUrl(avatarUrl)
                .build();
    }

    @Test
    public void convert() {

        User result = mapper.convert(userDto);
        assertEquals(user, result);
    }
}