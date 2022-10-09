package com.antonb.kbase.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class ItemDto {
    private Long id;
    private String title;
    private String text;
    private Timestamp lastupdate;
    private List<String> tags;
}
