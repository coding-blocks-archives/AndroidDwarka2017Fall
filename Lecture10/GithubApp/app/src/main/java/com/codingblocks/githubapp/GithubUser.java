package com.codingblocks.githubapp;

/**
 * Created by harshit on 14/01/18.
 */

public class GithubUser {
    private final String login;
    private final String avatar_url;
    private final String url;
    private final Double score;

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public Double getScore() {
        return score;
    }

    public GithubUser(String login, String avatar_url, String url, Double score) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.url = url;
        this.score = score;
    }
}
