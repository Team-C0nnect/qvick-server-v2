package com.project.qvick.global.common.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 페이징 처리 설정
 */
@Getter
@Setter
public class PageRequest {

    private int page;
    private int size;

    public PageRequest() {
        page = 1;
        size = 15;
    }

    public PageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

}
