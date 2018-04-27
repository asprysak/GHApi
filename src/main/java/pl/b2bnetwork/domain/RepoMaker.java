package pl.b2bnetwork.domain;

import org.springframework.web.client.RestTemplate;

public class RepoMaker {

    private RestTemplate restTemplate = new RestTemplate();

    public Repo makeRepo(String login, String repoName) {
        String url = "https://api.github.com/repos/" + login + "/repos/" + repoName;
        return restTemplate.getForObject(url, Repo.class);
    }
}