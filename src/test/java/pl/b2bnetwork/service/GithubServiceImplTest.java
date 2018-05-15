package pl.b2bnetwork.service;

import org.junit.Assert;
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

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GithubServiceImplTest {

    @Mock
    private GithubApiAccess apiAccess;
    @InjectMocks
    private GithubServiceImpl service = new GithubServiceImpl();
    private UserDto user = new UserDto();
    private Person akowalPerson;
    private List<Person> followers = new ArrayList<>();

    @Before
    public void init() {

        user.setId(1);
        user.setFollowers(3);
        user.setLogin("akowal");
        user.setDateOfCreatingAnAccount("2018-01-01");
        user.setNoOfPublicRepos(5);
        followers.add(new Person("jnowak", 2));
        followers.add(new Person("zbyszek", 3));

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

        List<Gist> gists = new ArrayList<>();
        akowalPerson = new Person(user.getLogin(), user.getId());
        Map<String, GistFile> files1 = new HashMap<>();
        gists.add(Gist.builder().id("aaa")
                .owner(akowalPerson)
                .description("gist in python")
                .url("/adres/1")
                .files(files1)
                .build());
        Map<String, GistFile> files2 = new HashMap<>();
        gists.add(Gist.builder().id("bbb")
                .owner(akowalPerson)
                .description("gist in java")
                .url("/adres/2")
                .files(files2)
                .build());
        Map<String, GistFile> files3 = new HashMap<>();
        gists.add(Gist.builder().id("ccc")
                .owner(akowalPerson)
                .description("bash script")
                .url("/adres/3")
                .files(files3)
                .build());

        Mockito.when(apiAccess.gistsOfAUSer("akowal")).thenReturn(gists);

        List<RepoDto> repos = new ArrayList<>();
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
        repos.add(rep3);

        Mockito.when(apiAccess.reposOfAUser("akowal")).thenReturn(repos);
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

        Map<String, GistFile> files1 = new HashMap<>();
        Gist g1 = Gist.builder().id("aaa")
                .owner(akowalPerson)
                .description("gist in python")
                .url("/adres/1")
                .files(files1)
                .build();
        Map<String, GistFile> files2 = new HashMap<>();
        Gist g2 = Gist.builder().id("bbb")
                .owner(akowalPerson)
                .description("gist in java")
                .url("/adres/2")
                .files(files2)
                .build();

        List<Gist> res = service.gistsWhichDescriptionContainsWord("akowal", "gist");
        System.out.println(res);
        assertThat(res, containsInAnyOrder(g1, g2));
    }

    @Test
    public void gistsWhichDescriptionContainsWordSize() {

        List<Gist> res = service.gistsWhichDescriptionContainsWord("akowal", "gist");
        System.out.println(res);
        assertEquals(2, res.size());
    }

    @Test
    public void reposOfAUserWhichAreForks() {

        List<RepoDto> expected = new ArrayList<>();
        RepoDto rep3 = new RepoDto();
        rep3.setName("plf");
        rep3.setLanguage("Python");
        rep3.setFork(true);
        expected.add(rep3);

        List<RepoDto> res = service.reposOfAUserWhichAreForks("akowal");
        assertEquals(expected, res);
    }

    @Test
    public void reposWrittenMostlyInASpecificLanguageElements() {

        RepoDto rep1 = new RepoDto();
        rep1.setName("Empowerment");
        rep1.setLanguage("Java");
        RepoDto rep2 = new RepoDto();
        rep2.setName("QDA");
        rep2.setLanguage("Java");

        List<RepoDto> res = service.reposWrittenMostlyInASpecificLanguage("akowal", "Java");

        assertThat(res, containsInAnyOrder(rep1, rep2));
    }

    @Test
    public void reposWrittenMostlyInASpecificLanguageSize() {

        List<RepoDto> res = service.reposWrittenMostlyInASpecificLanguage("akowal", "Java");
        assertEquals(2, res.size());
    }
}