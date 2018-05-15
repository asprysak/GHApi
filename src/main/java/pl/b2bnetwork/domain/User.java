package pl.b2bnetwork.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDb;
    @Length(min = 1, message = "")
    @Column(unique = true)
    private String login;
    private long id;
    private int noOfPublicRepos;
    private int followers;
    private Date dateOfCreatingAnAccount;
    private String reposUrl;
    private String avatarUrl;

    public Long getIdDb() {
        return idDb;
    }

    public void setIdDb(Long idDb) {
        this.idDb = idDb;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getDateOfCreatingAnAccount() {
        return dateOfCreatingAnAccount;
    }

    public void setDateOfCreatingAnAccount(Date dateOfCreatingAnAccount) {
        this.dateOfCreatingAnAccount = dateOfCreatingAnAccount;
    }

    public User(Long idDb, String login, long id, int noOfPublicRepos, int followers,
                Date dateOfCreatingAnAccount, String reposUrl, String avatarUrl) {
        this.idDb = idDb;
        this.login = login;
        this.id = id;
        this.noOfPublicRepos = noOfPublicRepos;
        this.followers = followers;
        this.dateOfCreatingAnAccount = dateOfCreatingAnAccount;
        this.reposUrl = reposUrl;
        this.avatarUrl = avatarUrl;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "idDb=" + idDb +
                ", login='" + login + '\'' +
                ", id=" + id +
                ", noOfPublicRepos=" + noOfPublicRepos +
                ", followers=" + followers +
                ", dateOfCreatingAnAccount='" + dateOfCreatingAnAccount + '\'' +
                ", reposUrl='" + reposUrl + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                noOfPublicRepos == user.noOfPublicRepos &&
                followers == user.followers &&
                Objects.equals(idDb, user.idDb) &&
                Objects.equals(login, user.login) &&
                Objects.equals(dateOfCreatingAnAccount, user.dateOfCreatingAnAccount) &&
                Objects.equals(reposUrl, user.reposUrl) &&
                Objects.equals(avatarUrl, user.avatarUrl);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idDb, login, id, noOfPublicRepos, followers, dateOfCreatingAnAccount, reposUrl, avatarUrl);
    }

    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    public static class UserBuilder {
        private Long idDb;
        private String login;
        private long id;
        private int noOfPublicRepos;
        private int followers;
        private Date dateOfCreatingAnAccount;
        private String reposUrl;
        private String avatarUrl;

        UserBuilder() {
        }

        public User.UserBuilder idDb(Long idDb) {
            this.idDb = idDb;
            return this;
        }

        public User.UserBuilder login(String login) {
            this.login = login;
            return this;
        }

        public User.UserBuilder id(long id) {
            this.id = id;
            return this;
        }

        public User.UserBuilder noOfPublicRepos(int noOfPublicRepos) {
            this.noOfPublicRepos = noOfPublicRepos;
            return this;
        }

        public User.UserBuilder followers(int followers) {
            this.followers = followers;
            return this;
        }

        public User.UserBuilder dateOfCreatingAnAccount(Date dateOfCreatingAnAccount) {
            this.dateOfCreatingAnAccount = dateOfCreatingAnAccount;
            return this;
        }

        public User.UserBuilder reposUrl(String reposUrl) {
            this.reposUrl = reposUrl;
            return this;
        }

        public User.UserBuilder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }

        public User build() {
            return new User(this.idDb, this.login, this.id, this.noOfPublicRepos, this.followers,
                    this.dateOfCreatingAnAccount, this.reposUrl, this.avatarUrl);
        }

        @Override
        public String toString() {
            return "UserBuilder{" +
                    "idDb=" + idDb +
                    ", login='" + login + '\'' +
                    ", id=" + id +
                    ", noOfPublicRepos=" + noOfPublicRepos +
                    ", followers=" + followers +
                    ", dateOfCreatingAnAccount='" + dateOfCreatingAnAccount + '\'' +
                    ", reposUrl='" + reposUrl + '\'' +
                    ", avatarUrl='" + avatarUrl + '\'' +
                    '}';
        }
    }
}
