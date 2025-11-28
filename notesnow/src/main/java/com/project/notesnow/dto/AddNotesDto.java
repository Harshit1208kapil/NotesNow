package com.project.notesnow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddNotesDto {
    @NotBlank
    @Size(min = 1, max = 20)
    private String heading;

    @NotBlank
    @Size(min = 20)
    private String content;

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

    public AddNotesDto(String heading, String content) {
        this.heading = heading;
        this.content = content;
    }
}
