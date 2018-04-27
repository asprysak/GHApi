package pl.b2bnetwork.domain;

import org.springframework.web.client.RestTemplate;

public class RepoMaker {

    private RestTemplate restTemplate = new RestTemplate();

    public Repo makeRepos(String login) {
        String url = "https://api.github.com/repos/" + login + "/repos";
        return restTemplate.getForObject(url, Repo.class);
    }
}