package db;

import java.util.Date;
import java.util.zip.DataFormatException;

public class Tasks {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private Date addedDate;

    public Tasks() {
    }

    public Tasks(Long id, Long userId, String title, String description, Date addedDate) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.addedDate = addedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
