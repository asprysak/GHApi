package pl.b2bnetwork.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDb;
    @Length(min = 1)
    @Column(unique = true)
    private String login;
    private long id;
    @JsonProperty("public_repos")
    private int noOfPublicRepos;
    private int followers;
    @JsonProperty("created_at")
    private String dateOfCreatingAnAccount;
    @JsonProperty("repos_url")
    private String reposUrl;


}
