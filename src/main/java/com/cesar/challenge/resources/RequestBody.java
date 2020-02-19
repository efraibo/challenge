package com.cesar.challenge.resources;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestBody {

    private String q;
    private String filters;
    private String resource_id;
}
