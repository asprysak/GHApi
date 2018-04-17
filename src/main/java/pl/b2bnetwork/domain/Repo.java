package pl.b2bnetwork.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Repo {

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

}
