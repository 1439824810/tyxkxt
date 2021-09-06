package com.example.spbmvc.service;

public interface QywxGetUserInfoService {
    public String postAccessToken(String url);
    public String getInfoByTokenAndCode(String url);
    public String postUserInfoByUserIdAndAccessToken(String url);
}
