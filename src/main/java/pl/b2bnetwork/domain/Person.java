package pl.b2bnetwork.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String login;
    private long id;
}
