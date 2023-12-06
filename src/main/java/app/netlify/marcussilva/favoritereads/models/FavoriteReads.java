package app.netlify.marcussilva.favoritereads.models;

import java.time.LocalDate;

public class FavoriteReads {

    private Integer id;
    private String bookName;
    private String authorName;
    private LocalDate published;

    public FavoriteReads(Integer id, String bookName, String authorName, LocalDate published) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.published = published;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }
}
