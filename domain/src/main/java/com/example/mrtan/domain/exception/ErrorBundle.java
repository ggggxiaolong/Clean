package com.example.mrtan.domain.exception;

/**
 * @author mrtan 17-3-12
 */

public interface ErrorBundle {
    Exception exception();

    String errorMessage();
}
