package pl.b2bnetwork.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class GistFile {

    private String filename;
    private String type;
    private String language;
    private int size;
}
