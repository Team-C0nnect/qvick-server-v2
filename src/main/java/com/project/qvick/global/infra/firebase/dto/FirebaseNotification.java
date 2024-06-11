package com.project.qvick.global.infra.firebase.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class FirebaseNotification {

    private List<String> tokens;
    private String message;
    private String title;
    @Builder.Default
    Map<String, Object> data = new HashMap<>();

}

