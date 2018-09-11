package com.github.richyeoh.okrouter;

public interface Exception {
    class FirewallException extends RuntimeException {
        FirewallException(String message) {
            super(message);
        }
    }
}
