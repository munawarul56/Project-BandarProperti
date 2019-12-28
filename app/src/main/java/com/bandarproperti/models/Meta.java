package com.bandarproperti.models;

class Pagination {
    public int total;
    public int count;
    public int per_page;
    public int current_page;
    public int total_pages;
    public Links links;
}

class Links {
    public String previous;
    public String next;
}

public class Meta {
    public Pagination pagination;
}
