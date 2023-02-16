package org.example.entity;

import lombok.Data;

@Data
public class Project {
    private String name;
    private String status;
    private String sourceLanguage;
    private String targetLanguage;
}
