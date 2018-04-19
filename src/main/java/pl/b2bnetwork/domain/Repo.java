package pl.b2bnetwork.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Repo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDb;
    private long id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private String description;
    //  private User owner;
    private boolean fork;
    @JsonProperty("created_at")
    private String dateOfCreatingARepo;
    private int size;
    @JsonProperty("forks_count")
    private int forksCount;
    private String language;

}
