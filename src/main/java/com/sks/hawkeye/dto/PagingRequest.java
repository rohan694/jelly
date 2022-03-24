package com.sks.hawkeye.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class PagingRequest {

    private int start;
    private int length;
    private int draw;
    private String type;
    private String tournamentName;
    private String tournamentYear;
    private List<Order> order;
    private List<Column> columns;
    private Search search;

}
