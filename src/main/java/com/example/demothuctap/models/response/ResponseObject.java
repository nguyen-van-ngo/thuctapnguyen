package com.example.demothuctap.models.response;

import lombok.*;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private String status;
    private String msg;
    private Object data;
}
