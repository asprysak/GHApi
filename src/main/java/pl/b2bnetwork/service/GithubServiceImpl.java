package pl.b2bnetwork.service;

import org.springframework.stereotype.Service;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.GithubApiAccess;
import pl.b2bnetwork.domain.Person;
import pl.b2bnetwork.dto.RepoDto;
import pl.b2bnetwork.dto.UserDto;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GithubServiceImpl implements GithubService {

    private GithubApiAccess apiAccess = new GithubApiAccess();

    @Override
    public int howManyFollowersThePersonHas(String login) {

        UserDto user = apiAccess.makeUser(login);
        return user.getFollowers();
    }

    @Override
    public int howManyReposThePersonHas(String login) {

        UserDto user = apiAccess.makeUser(login);
        return user.getNoOfPublicRepos();
    }

    @Override
    public String howManyDaysAgoTheAccountWasCreated(String login) {

        UserDto user = apiAccess.makeUser(login);
        Date dateOfCreatingAnAccount = user.getCalendarForCreatingAnAccount().getTime();
        Calendar now = Calendar.getInstance();
        Date dateNow = now.getTime();
        long days = ChronoUnit.DAYS.between(dateOfCreatingAnAccount.toInstant(), dateNow.toInstant());
        return Long.toString(days);
    }

    @Override
    public Double averageNoOfFollowersOfFollowers(String login) {

        List<Person> followers = apiAccess.followersOfAUser(login);
        Double average = followers.stream()
                .mapToInt(person -> howManyFollowersThePersonHas(person.getLogin()))
                .average().orElse(0);
        return Math.round(average*100.0)/100.0;
    }

    @Override
    public Double averageNoOfFollowersRepos(String login) {

        List<Person> followers = apiAccess.followersOfAUser(login);
        Double average = followers.stream()
                .mapToInt(person -> howManyReposThePersonHas(person.getLogin()))
                .average().orElse(0);
        return Math.round(average*100.0)/100.0;
    }

    @Override
    public List<Gist> gistsOfAUSer(String login) {

        return apiAccess.gistsOfAUSer(login);
    }

    @Override
    public List<Gist> gistsWhichDescriptionContainsWord(String login, String word) {

        List<Gist> gists = apiAccess.gistsOfAUSer(login);
        return gists.stream()
                .filter(gist -> gist.getDescription().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RepoDto> reposOfAUser(String login) {

        return apiAccess.reposOfAUser(login);
    }

    @Override
    public List<RepoDto> reposOfAUserWhichAreForks(String login) {

        List<RepoDto> repos = apiAccess.reposOfAUser(login);
        return repos.stream()
                .filter(RepoDto::isFork)
                .collect(Collectors.toList());
    }

    @Override
    public List<RepoDto> reposWrittenMostlyInASpecificLanguage(String login, String language) {

        List<RepoDto> repos = apiAccess.reposOfAUser(login);
        return repos.stream()
                .filter(repo -> repo.getLanguage() != null)
                .filter(repo -> repo.getLanguage().toLowerCase().equals(language.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> followersOfAUser(String login) {

        return apiAccess.followersOfAUser(login);
    }
}
