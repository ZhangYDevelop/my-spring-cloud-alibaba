package com.zy.alibaba.author.support;

import java.io.Serializable;

/**
 * 认证服务器客户端
 */
public class Clients implements Serializable {

    private Long id;

    private String client_id;

    private String client_secret;

    private boolean is_scoped;

    private String scope;

    private String grant_type;

    private String redirect_url;

    private String authotities;

    private Integer token_seconds;

    private Integer refresh_token_seconds;

    private boolean auto_approve;

    private String information;

    private String resource_ids;

    public String getResource_ids() {
        return resource_ids;
    }

    public void setResource_ids(String resource_ids) {
        this.resource_ids = resource_ids;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public boolean isIs_scoped() {
        return is_scoped;
    }

    public void setIs_scoped(boolean is_scoped) {
        this.is_scoped = is_scoped;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getAuthotities() {
        return authotities;
    }

    public void setAuthotities(String authotities) {
        this.authotities = authotities;
    }

    public Integer getToken_seconds() {
        return token_seconds;
    }

    public void setToken_seconds(Integer token_seconds) {
        this.token_seconds = token_seconds;
    }

    public Integer getRefresh_token_seconds() {
        return refresh_token_seconds;
    }

    public void setRefresh_token_seconds(Integer refresh_token_seconds) {
        this.refresh_token_seconds = refresh_token_seconds;
    }

    public boolean isAuto_approve() {
        return auto_approve;
    }

    public void setAuto_approve(boolean auto_approve) {
        this.auto_approve = auto_approve;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
