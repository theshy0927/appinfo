package com.t248.appinfo.dto;


import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO {
    private Long id;
    private String nextLevel=null;
    private String categoryName;
    private List<Long> childCategory = null;
    private Long parentId;
}
