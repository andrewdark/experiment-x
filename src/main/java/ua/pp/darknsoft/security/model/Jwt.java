package ua.pp.darknsoft.security.model;


public class Jwt {
    private Long userId;
    private String token;
    private String type = "Bearer";

    public Jwt(String accessToken, Long userId) {
        this.token = accessToken;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return token;
    }
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }
}