package pl.b2bnetwork.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.Person;
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

        String url = "https://api.github.com/users/" + login + "/followers";
        Person[] followersTask = restTemplate.getForObject(url, Person[].class);
        Double average = Arrays.stream(followersTask)
                .mapToInt(person -> howManyFollowersThePersonHas(person.getLogin()))
                .average().orElse(0);
        return average;
    }

    @Override
    public Double averageNoOfFollowersRepos(String login) {

        String url = "https://api.github.com/users/" + login + "/followers";
        Person[] followersTask = restTemplate.getForObject(url, Person[].class);
        Double average = Arrays.stream(followersTask)
                .mapToInt(person -> howManyReposThePersonHas(person.getLogin()))
                .average().orElse(0);
        return average;
    }

    @Override
    public List<Gist> gistsOfAnUSer(String login) {

        String url = "https://api.github.com/users/" + login + "/gists";
        Gist[] gists = restTemplate.getForObject(url, Gist[].class);
        return Arrays.asList(gists);
    }

    @Override
    public List<Gist> gistsWhichDescriptionContainsWord(String login, String word) {

        String url = "https://api.github.com/users/" + login + "/gists";
        Gist[] gists = restTemplate.getForObject(url, Gist[].class);
        List<Gist> result = Arrays.stream(gists)
                .filter(gist -> gist.getDescription().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
        return result;
    }

    private User makeUser(String login) {

        String url = "https://api.github.com/users/" + login;
        return restTemplate.getForObject(url, User.class);
    }

}
