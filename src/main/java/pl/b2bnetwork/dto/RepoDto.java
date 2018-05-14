package pl.b2bnetwork.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.b2bnetwork.domain.Person;

public class RepoDto {

    private long id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private String description;
    private Person owner;
    private boolean fork;
    @JsonProperty("created_at")
    private String dateOfCreatingARepo;
    private int size;
    @JsonProperty("forks_count")
    private int forksCount;
    private String language;

    public RepoDto(long id, String name, String fullName, String description, Person owner, boolean fork,
                   String dateOfCreatingARepo, int size, int forksCount, String language) {
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

    public RepoDto() {
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

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
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
}
