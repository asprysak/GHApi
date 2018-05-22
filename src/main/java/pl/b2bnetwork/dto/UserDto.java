package pl.b2bnetwork.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class UserDto {

    private long id;
    private String login;
    @JsonProperty("public_repos")
    private int noOfPublicRepos;
    private int followers;
    @JsonProperty("created_at")
    private String dateOfCreatingAnAccount;
    @JsonProperty("repos_url")
    private String reposUrl;
    @JsonProperty("avatar_url")
    private String avatarUrl;

    public UserDto(long id, String login, int noOfPublicRepos, int followers, String dateOfCreatingAnAccount,
                   String reposUrl, String avatarUrl) {
        this.id = id;
        this.login = login;
        this.noOfPublicRepos = noOfPublicRepos;
        this.followers = followers;
        this.dateOfCreatingAnAccount = dateOfCreatingAnAccount;
        this.reposUrl = reposUrl;
        this.avatarUrl = avatarUrl;
    }

    public UserDto() {
    }

    public Calendar getCalendarForCreatingAnAccount() {
        String dateString = dateOfCreatingAnAccount;
        int year = Integer.parseInt(dateString.substring(0,4));
        int month = Integer.parseInt(dateString.substring(5,7));
        int day = Integer.parseInt(dateString.substring(8,10));
        return new GregorianCalendar(year, month - 1, day);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNoOfPublicRepos() {
        return noOfPublicRepos;
    }

    public void setNoOfPublicRepos(int noOfPublicRepos) {
        this.noOfPublicRepos = noOfPublicRepos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getDateOfCreatingAnAccount() {
        return dateOfCreatingAnAccount;
    }

    public void setDateOfCreatingAnAccount(String dateOfCreatingAnAccount) {
        this.dateOfCreatingAnAccount = dateOfCreatingAnAccount;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
