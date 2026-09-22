package com.tads.ecommerce.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StanderErro
{
    private Instant timestamp;
    private Integer status;
    private String erro;
    private String message;
    private String path;

}