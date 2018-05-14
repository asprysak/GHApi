package pl.b2bnetwork.domain;

import java.util.Objects;

public class GistFile {

    private String filename;
    private String type;
    private String language;
    private int size;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GistFile gistFile = (GistFile) o;
        return size == gistFile.size &&
                Objects.equals(filename, gistFile.filename) &&
                Objects.equals(type, gistFile.type) &&
                Objects.equals(language, gistFile.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(filename, type, language, size);
    }

    @Override
    public String toString() {
        return "GistFile{" +
                "filename='" + filename + '\'' +
                ", type='" + type + '\'' +
                ", language='" + language + '\'' +
                ", size=" + size +
                '}';
    }
}
