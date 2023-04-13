package com.org.myapp.api.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SearchResponse {

    private int count;

    private List<Profile> profiles;

    private LocalDateTime searchDateTime;

}
