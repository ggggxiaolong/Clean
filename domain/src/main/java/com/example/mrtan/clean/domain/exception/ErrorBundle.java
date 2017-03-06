package com.example.mrtan.clean.domain.exception;

/**
 * Created by tanxiaolong on 17/3/6.
 */

public interface ErrorBundle {
    Exception exception();

    String errorMessage();
}
