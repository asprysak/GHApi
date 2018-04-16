package pl.b2bnetwork.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Person {

    private String login;
    private int id;
}
