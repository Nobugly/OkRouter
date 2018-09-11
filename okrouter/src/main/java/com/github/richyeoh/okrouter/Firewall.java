package com.github.richyeoh.okrouter;

public interface Firewall {
    boolean allow();

    Exception.FirewallException thrown();
}
