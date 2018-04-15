package pl.b2bnetwork.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.b2bnetwork.domain.github.Person;

@Service
public class GithubServiceImpl implements GithubService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String howManyFollowersThePersonHas(String name) {

        String url = "https://api.github.com/users/" + name;
        Person person = restTemplate.getForObject(url, Person.class);
        return Integer.toString(person.getFollowers());
    }
}
