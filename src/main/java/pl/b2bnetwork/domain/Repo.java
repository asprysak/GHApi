package pl.b2bnetwork.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Repo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDb;
    private long id;
    private String name;
    private String fullName;
    private String description;
    @ManyToOne
    private User owner;
    private boolean fork;
    private String dateOfCreatingARepo;
    private int size;
    private int forksCount;
    private String language;

    public Repo(Long idDb, long id, String name, String fullName, String description, User owner, boolean fork,
                String dateOfCreatingARepo, int size, int forksCount, String language) {
        this.idDb = idDb;
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.owner = owner;
        this.fork = fork;
        this.dateOfCreatingARepo = dateOfCreatingARepo;
        this.size = size;
        this.forksCount = forksCount;
        this.language = language;
    }

    public Repo() {
    }

    @Override
    public String toString() {
        return "Repo{" +
                "idDb=" + idDb +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", fork=" + fork +
                ", dateOfCreatingARepo='" + dateOfCreatingARepo + '\'' +
                ", size=" + size +
                ", forksCount=" + forksCount +
                ", language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Repo repo = (Repo) o;
        return id == repo.id &&
                fork == repo.fork &&
                size == repo.size &&
                forksCount == repo.forksCount &&
                Objects.equals(idDb, repo.idDb) &&
                Objects.equals(name, repo.name) &&
                Objects.equals(fullName, repo.fullName) &&
                Objects.equals(description, repo.description) &&
                Objects.equals(owner, repo.owner) &&
                Objects.equals(dateOfCreatingARepo, repo.dateOfCreatingARepo) &&
                Objects.equals(language, repo.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), idDb, id, name, fullName, description, owner, fork, dateOfCreatingARepo,
                size, forksCount, language);
    }

    public Long getIdDb() {
        return idDb;
    }

    public void setIdDb(Long idDb) {
        this.idDb = idDb;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getDateOfCreatingARepo() {
        return dateOfCreatingARepo;
    }

    public void setDateOfCreatingARepo(String dateOfCreatingARepo) {
        this.dateOfCreatingARepo = dateOfCreatingARepo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getForksCount() {
        return forksCount;
    }

    public void setForksCount(int forksCount) {
        this.forksCount = forksCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static class RepoBuilder {
        private Long idDb;
        private long id;
        private String name;
        private String fullName;
        private String description;
        private User owner;
        private boolean fork;
        private String dateOfCreatingARepo;
        private int size;
        private int forksCount;
        private String language;

        RepoBuilder() {
        }

        public Repo.RepoBuilder idDb(Long idDb) {
            this.idDb = idDb;
            return this;
        }

        public Repo.RepoBuilder id(long id) {
            this.id = id;
            return this;
        }

        public Repo.RepoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Repo.RepoBuilder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Repo.RepoBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Repo.RepoBuilder owner(User owner) {
            this.owner = owner;
            return this;
        }

        public Repo.RepoBuilder fork(boolean fork) {
            this.fork = fork;
            return this;
        }

        public Repo.RepoBuilder dateOfCreatingARepo(String dateOfCreatingARepo) {
            this.dateOfCreatingARepo = dateOfCreatingARepo;
            return this;
        }

        public Repo.RepoBuilder size(int size) {
            this.size = size;
            return this;
        }

        public Repo.RepoBuilder forksCount(int forksCount) {
            this.forksCount = forksCount;
            return this;
        }

        public Repo.RepoBuilder language(String language) {
            this.language = language;
            return this;
        }

        public Repo build() {
            return new Repo(this.idDb, this.id, this.name, this.fullName, this.description, this.owner, this.fork,
                    this.dateOfCreatingARepo, this.size, this.forksCount, this.language);
        }

        @Override
        public String toString() {
            return "RepoBuilder{" +
                    "idDb=" + idDb +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", description='" + description + '\'' +
                    ", owner=" + owner +
                    ", fork=" + fork +
                    ", dateOfCreatingARepo='" + dateOfCreatingARepo + '\'' +
                    ", size=" + size +
                    ", forksCount=" + forksCount +
                    ", language='" + language + '\'' +
                    '}';
        }
    }
}
