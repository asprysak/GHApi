package pl.b2bnetwork.domain;

import java.util.Map;
import java.util.Objects;

public class Gist {

    private String id;
    private String url;
    private String description;
    private Person owner;
    private Map<String, GistFile> files;

    public Gist(String id, String url, String description, Person owner, Map<String, GistFile> files) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.owner = owner;
        this.files = files;
    }

    public Gist() {
    }

    public static GistBuilder builder() {
        return new GistBuilder();
    }
    public String getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDescription() {
        return this.description;
    }

    public Person getOwner() {
        return this.owner;
    }

    public Map<String, GistFile> getFiles() {
        return this.files;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setFiles(Map<String, GistFile> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Gist{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", files=" + files +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gist gist = (Gist) o;
        return Objects.equals(id, gist.id) &&
                Objects.equals(url, gist.url) &&
                Objects.equals(description, gist.description) &&
                Objects.equals(owner, gist.owner) &&
                Objects.equals(files, gist.files);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, url, description, owner, files);
    }

    public static class GistBuilder {
        private String id;
        private String url;
        private String description;
        private Person owner;
        private Map<String, GistFile> files;

        GistBuilder() {
        }

        public Gist.GistBuilder id(String id) {
            this.id = id;
            return this;
        }

        public Gist.GistBuilder url(String url) {
            this.url = url;
            return this;
        }

        public Gist.GistBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Gist.GistBuilder owner(Person owner) {
            this.owner = owner;
            return this;
        }

        public Gist.GistBuilder files(Map<String, GistFile> files) {
            this.files = files;
            return this;
        }

        public Gist build() {
            return new Gist(this.id, this.url, this.description, this.owner, this.files);
        }

        @Override
        public String toString() {
            return "GistBuilder{" +
                    "id='" + id + '\'' +
                    ", url='" + url + '\'' +
                    ", description='" + description + '\'' +
                    ", owner=" + owner +
                    ", files=" + files +
                    '}';
        }
    }
}
