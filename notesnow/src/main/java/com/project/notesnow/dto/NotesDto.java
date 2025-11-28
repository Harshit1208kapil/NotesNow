package com.project.notesnow.dto;


public class NotesDto {
    private long id;
    private String heading;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NotesDto(long id, String heading, String content) {
        this.id = id;
        this.heading = heading;
        this.content = content;
    }
}
