package com.codestates.hello_world;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto {
    private long messageId;
    private String message;
}
