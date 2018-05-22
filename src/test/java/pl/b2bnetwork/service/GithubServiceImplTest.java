package pl.b2bnetwork.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import pl.b2bnetwork.domain.Gist;
import pl.b2bnetwork.domain.GistFile;
import pl.b2bnetwork.domain.GithubApiAccess;
import pl.b2bnetwork.domain.Person;
import pl.b2bnetwork.dto.RepoDto;
import pl.b2bnetwork.dto.UserDto;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GithubServiceImplTest {

    @Mock
    private GithubApiAccess apiAccess;
    @InjectMocks
    private GithubServiceImpl service = new GithubServiceImpl();
    private UserDto user = new UserDto();
    private Person personAKowal;
    private List<Person> followers = new ArrayList<>();
    private List<Gist> gists = new ArrayList<>();
    private List<RepoDto> repos = new ArrayList<>();


    @Before
    public void init() {

        initPerson();
        mockFollowers();
        mockGists();
        mockRepos();
    }

    @Test
    public void averageNoOfFollowersOfFollowers() {

        assertEquals(14.00, service.averageNoOfFollowersOfFollowers(user.getLogin()), 0.001);
    }

    @Test
    public void averageNoOfFollowersRepos() {

        assertEquals(5.00, service.averageNoOfFollowersRepos("akowal"), 0.001);
    }

    @Test
    public void gistsWhichDescriptionContainsWordElements() {

        List<Gist> res = service.gistsWhichDescriptionContainsWord("akowal", "gist");
        assertThat(res, containsInAnyOrder(gists.get(0), gists.get(1)));
    }

    @Test
    public void gistsWhichDescriptionContainsWordSize() {

        List<Gist> res = service.gistsWhichDescriptionContainsWord("akowal", "gist");
        assertEquals(2, res.size());
    }

    @Test
    public void reposOfAUserWhichAreForks() {

        List<RepoDto> res = service.reposOfAUserWhichAreForks("akowal");
        assertThat(res, contains(repos.get(2)));
    }

    @Test
    public void reposOfAUserWhichAreForksSize() {

        List<RepoDto> res = service.reposOfAUserWhichAreForks("akowal");
        assertEquals(1, res.size());
    }
    @Test
    public void reposWrittenMostlyInASpecificLanguageElements() {

        List<RepoDto> res = service.reposWrittenMostlyInASpecificLanguage("akowal", "Java");
        assertThat(res, containsInAnyOrder(repos.get(0), repos.get(1)));
    }

    @Test
    public void reposWrittenMostlyInASpecificLanguageSize() {

        List<RepoDto> res = service.reposWrittenMostlyInASpecificLanguage("akowal", "Java");
        assertEquals(2, res.size());
    }

    private void mockRepos() {

        RepoDto rep1 = new RepoDto();
        rep1.setName("Empowerment");
        rep1.setLanguage("Java");
        rep1.setFork(false);
        repos.add(rep1);
        RepoDto rep2 = new RepoDto();
        rep2.setName("QDA");
        rep2.setLanguage("Java");
        rep2.setFork(false);
        repos.add(rep2);
        RepoDto rep3 = new RepoDto();
        rep3.setName("plf");
        rep3.setLanguage("Python");
        rep3.setFork(true);
        rep3.setOwner(personAKowal);
        repos.add(rep3);

        Mockito.when(apiAccess.reposOfAUser("akowal")).thenReturn(repos);
    }

    private void mockGists() {

        personAKowal = new Person(user.getLogin(), user.getId());
        Map<String, GistFile> files1 = new HashMap<>();
        gists.add(Gist.builder().id("aaa")
                .owner(personAKowal)
                .description("gist in python")
                .url("/adres/1")
                .files(files1)
                .build());
        Map<String, GistFile> files2 = new HashMap<>();
        gists.add(Gist.builder().id("bbb")
                .owner(personAKowal)
                .description("gist in java")
                .url("/adres/2")
                .files(files2)
                .build());
        Map<String, GistFile> files3 = new HashMap<>();
        gists.add(Gist.builder().id("ccc")
                .owner(personAKowal)
                .description("bash script")
                .url("/adres/3")
                .files(files3)
                .build());

        Mockito.when(apiAccess.gistsOfAUSer("akowal")).thenReturn(gists);
    }

    private void mockFollowers() {

        UserDto nowakUser = new UserDto();
        nowakUser.setFollowers(10);
        nowakUser.setNoOfPublicRepos(6);

        UserDto zbyszekUser = new UserDto();
        zbyszekUser.setFollowers(18);
        zbyszekUser.setNoOfPublicRepos(4);

        Mockito.when(apiAccess.makeUser("jnowak")).thenReturn(nowakUser);
        Mockito.when(apiAccess.makeUser("zbyszek")).thenReturn(zbyszekUser);

        Mockito.when(apiAccess.makeUser("akowal")).thenReturn(user);
        Mockito.when(apiAccess.followersOfAUser("akowal")).thenReturn(followers);
    }

    private void initPerson() {

        user.setId(1);
        user.setFollowers(3);
        user.setLogin("akowal");
        user.setDateOfCreatingAnAccount("2018-01-01");
        user.setNoOfPublicRepos(5);
        followers.add(new Person("jnowak", 2));
        followers.add(new Person("zbyszek", 3));
    }

}