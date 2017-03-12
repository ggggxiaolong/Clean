package com.example.mrtan.clean.domain.exception;

import org.immutables.value.Value;

/**
 * Created by tanxiaolong on 17/3/6.
 */

@Value.Immutable
public abstract class DefaultErrorBundle implements ErrorBundle {

    @Override
    @Value.Default
    public String errorMessage() {
        return "Unknown error";
    }
}
