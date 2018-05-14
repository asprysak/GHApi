package pl.b2bnetwork.domain;

import org.springframework.web.client.RestTemplate;
import pl.b2bnetwork.dto.RepoDto;
import pl.b2bnetwork.dto.UserDto;

import java.util.Arrays;
import java.util.List;

public class GithubApiAccess {

    private final String urlCore = "https://api.github.com/users/";
    private RestTemplate restTemplate = new RestTemplate();

    public UserDto makeUser(String login) {
        String url = urlCore + login;
        return restTemplate.getForObject(url, UserDto.class);
    }

    public List<RepoDto> reposOfAUser(String login) {

        String url = urlCore + login + "/repos";
        return Arrays.asList(restTemplate.getForObject(url, RepoDto[].class));
    }

    public List<Person> followersOfAUser(String login) {

        String url = urlCore + login + "/followers";
        Person[] followers = restTemplate.getForObject(url, Person[].class);
        return Arrays.asList(followers);
    }

    public List<Gist> gistsOfAUSer(String login) {

        String url = urlCore + login + "/gists";
        Gist[] gists = restTemplate.getForObject(url, Gist[].class);
        return Arrays.asList(gists);
    }

    public RepoDto makeRepo(String login, String repoName) {
        String url = urlCore + login + "/" + repoName;
        return restTemplate.getForObject(url, RepoDto.class);
    }
}
