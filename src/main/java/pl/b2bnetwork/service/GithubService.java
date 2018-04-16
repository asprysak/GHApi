package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.Gist;

import java.util.List;

public interface GithubService {

    int howManyFollowersThePersonHas(String login);
    int howManyReposThePersonHas(String login);
    String howManyDaysAgoTheAccountWasCreated(String login);
    Double averageNoOfFollowersOfFollowers(String login);
    Double averageNoOfFollowersRepos(String login);
    List<Gist> gistsOfAnUSer(String login);
    List<Gist> gistsWhichDescriptionContainsWord(String login, String word);
}
