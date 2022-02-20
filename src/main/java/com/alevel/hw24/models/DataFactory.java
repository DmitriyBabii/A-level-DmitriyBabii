package com.alevel.hw24.models;

import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
public class DataFactory {
    private String name;
    private Long sum;
    private Long count;

    @Override
    public String toString() {
        return String.format("Name: %-15s   Sum: %-10d   Count: %-6d", name, sum, count);
    }
}
