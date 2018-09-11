package com.github.richyeoh.okrouter;

public class LoginFirewall implements Firewall {
    @Override
    public boolean allow() {
        return false;
    }

    @Override
    public Exception.FirewallException thrown() {
        return new Exception.FirewallException("you must been login.");
    }
}
