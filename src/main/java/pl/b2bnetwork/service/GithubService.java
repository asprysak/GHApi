package pl.b2bnetwork.service;

import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.Person;
import pl.b2bnetwork.domain.Repo;

import java.util.List;

public interface GithubService {

    int howManyFollowersThePersonHas(String login);
    int howManyReposThePersonHas(String login);
    String howManyDaysAgoTheAccountWasCreated(String login);
    Double averageNoOfFollowersOfFollowers(String login);
    Double averageNoOfFollowersRepos(String login);
    List<Gist> gistsOfAUSer(String login);
    List<Gist> gistsWhichDescriptionContainsWord(String login, String word);
    List<Repo> reposOfAUser(String login);
    List<Repo> reposOfAUserWhichAreForks(String login);
    List<Repo> reposWrittenMostlyInASpecificLanguage(String login, String language);
    List<Person> followersOfAUser(String login);
}
