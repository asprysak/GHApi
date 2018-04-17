package pl.b2bnetwork.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.Person;
import pl.b2bnetwork.domain.Repo;
import pl.b2bnetwork.domain.User;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GithubServiceImpl implements GithubService {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public int howManyFollowersThePersonHas(String login) {

        User user = makeUser(login);
        return user.getFollowers();
    }

    @Override
    public int howManyReposThePersonHas(String login) {

        User user = makeUser(login);
        return user.getNoOfPublicRepos();
    }

    @Override
    public String howManyDaysAgoTheAccountWasCreated(String login) {

        User user = makeUser(login);
        String dateString = user.getDateOfCreatingAnAccount();
        int year = Integer.parseInt(dateString.substring(0,4));
        int month = Integer.parseInt(dateString.substring(5,7));
        int day = Integer.parseInt(dateString.substring(8,10));

        Calendar calendar = new GregorianCalendar(year, month, day);
        Calendar now = Calendar.getInstance();
        Date d2 = now.getTime();
        Date d1 = calendar.getTime();
        long days = ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());
        return Long.toString(days);
    }

    @Override
    public Double averageNoOfFollowersOfFollowers(String login) {

        List<Person> followers = followersOfAUser(login);
        return followers.stream()
                .mapToInt(person -> howManyFollowersThePersonHas(person.getLogin()))
                .average().orElse(0);
    }

    @Override
    public Double averageNoOfFollowersRepos(String login) {

        List<Person> followers = followersOfAUser(login);
        return followers.stream()
                .mapToInt(person -> howManyReposThePersonHas(person.getLogin()))
                .average().orElse(0);
    }

    @Override
    public List<Gist> gistsOfAUSer(String login) {

        String url = "https://api.github.com/users/" + login + "/gists";
        Gist[] gists = restTemplate.getForObject(url, Gist[].class);
        return Arrays.asList(gists);
    }

    @Override
    public List<Gist> gistsWhichDescriptionContainsWord(String login, String word) {

        List<Gist> gists = gistsOfAUSer( login);
        return gists.stream()
                .filter(gist -> gist.getDescription().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Repo> reposOfAUser(String login) {

        String url = "https://api.github.com/users/" + login + "/repos";
        return Arrays.asList(restTemplate.getForObject(url, Repo[].class));
    }

    @Override
    public List<Repo> reposOfAUserWhichAreForks(String login) {

        List<Repo> repos = reposOfAUser(login);
        return repos.stream()
                .filter(Repo::isFork)
                .collect(Collectors.toList());
    }

    @Override
    public List<Repo> reposWrittenMostlyInASpecificLanguage(String login, String language) {

        List<Repo> repos = reposOfAUser(login);
        return repos.stream()
                .filter(repo -> repo.getLanguage() != null)
                .filter(repo -> repo.getLanguage().toLowerCase().equals(language.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> followersOfAUser(String login) {

        String url = "https://api.github.com/users/" + login + "/followers";
        Person[] followers = restTemplate.getForObject(url, Person[].class);
        return Arrays.asList(followers);
    }

    private User makeUser(String login) {

        String url = "https://api.github.com/users/" + login;
        return restTemplate.getForObject(url, User.class);
    }

}
