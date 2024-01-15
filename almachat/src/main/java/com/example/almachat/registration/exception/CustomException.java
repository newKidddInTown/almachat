package com.example.almachat.registration.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomException extends RuntimeException{

    private String code;
    private String message;

    public CustomException(Builder builder) {
        this.code = builder.getCode();
        this.message = builder.getMessage();
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Builder {

        @Getter
        private String code;
        @Getter
        private String message;

        public static Builder newBuilder() {
            return new Builder();
        }
        public Builder code(final String code) {
            this.code = code;
            return this;
        }

        public Builder message (final String message) {
            this.message = message;
            return this;
        }

        public CustomException build() {
            return new CustomException(this);
        }

    }
}
