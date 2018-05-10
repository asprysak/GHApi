package pl.b2bnetwork.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDb;
    @Length(min = 1, message = "")
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
    @JsonProperty("avatar_url")
    private String avatarUrl;

    //TODO builder

}
