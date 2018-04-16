package pl.b2bnetwork.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@Builder
@ToString
public class Gist {

    private String id;
    private String url;
    private String description;
    private Person owner;
    private Map<String, GistFile> files;
}
