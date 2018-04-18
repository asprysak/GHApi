package pl.b2bnetwork.domain;

import org.springframework.web.client.RestTemplate;

public class UserMaker {

    private RestTemplate restTemplate = new RestTemplate();

    public User makeUser(String login) {
        String url = "https://api.github.com/users/" + login;
        return restTemplate.getForObject(url, User.class);
    }
}
