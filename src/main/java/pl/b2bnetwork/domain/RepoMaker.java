package pl.b2bnetwork.domain;

import org.springframework.web.client.RestTemplate;
import pl.b2bnetwork.dto.RepoDto;

public class RepoMaker {

    private RestTemplate restTemplate = new RestTemplate();

    public RepoDto makeRepo(String login, String repoName) {
        String url = "https://api.github.com/repos/" + login + "/repos/" + repoName;
        return restTemplate.getForObject(url, RepoDto.class);
    }
}