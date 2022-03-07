package com.panda.pauloartdraw.market.domain.dto;

public class AuthenticationResponseDto {

    private String token;
    private String rol;

    public AuthenticationResponseDto(String token, String rol) {
        this.token = token;
        this.rol = rol;
    }

    public AuthenticationResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
