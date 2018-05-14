package pl.b2bnetwork.domain;

import org.springframework.web.client.RestTemplate;
import pl.b2bnetwork.dto.UserDto;

public class UserMaker {

    private RestTemplate restTemplate = new RestTemplate();

    public UserDto makeUser(String login) {
        String url = "https://api.github.com/users/" + login;
        return restTemplate.getForObject(url, UserDto.class);
    }
}
