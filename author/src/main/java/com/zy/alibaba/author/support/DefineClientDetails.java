package com.zy.alibaba.author.support;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;


public class DefineClientDetails implements ClientDetails {

    private Clients clients;

    public DefineClientDetails(Clients clients) {

        this.clients = clients;
    }

    @Override
    public String getClientId() {
        return clients.getClient_id();
    }

    @Override
    public Set<String> getResourceIds() {
        return clients.getResource_ids() == null ? null : transformStringToSet(clients.getResource_ids(), String.class);
    }

    @Override
    public boolean isSecretRequired() {
        return true;
    }

    @Override
    public String getClientSecret() {
        return clients.getClient_secret();
    }

    @Override
    public boolean isScoped() {
        return clients.isIs_scoped();
    }

    @Override
    public Set<String> getScope() {
        return clients.getScope() == null ? null : transformStringToSet(clients.getScope(), String.class);
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return clients.getGrant_type() == null ?  null : transformStringToSet(clients.getGrant_type(), String.class);
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return clients.getRedirect_url() == null  ? null : transformStringToSet(clients.getRedirect_url(), String.class);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return clients.getAuthotities() == null ? null :AuthorityUtils.commaSeparatedStringToAuthorityList(clients.getAuthotities());
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return clients.getToken_seconds();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return clients.getRefresh_token_seconds();
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return clients.isAuto_approve();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }

    public  Set transformStringToSet(String str, Class type) {

        Set<? super Object> parameters = new HashSet<>();

        String[] tmps = str.trim().split(",");

        String typeName = type.getSimpleName();

        switch (typeName) {
            case "Byte":
                for (String item : tmps) {
                    try {
                        Byte var1 = Byte.parseByte(item);
                        parameters.add(var1);
                    } catch (Exception e) {
                        throw e;
                    }
                }
                break;
            case "Long":
                for (String item : tmps) {
                    try {
                        Long var1 = Long.parseLong(item);
                        parameters.add(var1);
                    } catch (Exception e) {
                        throw e;
                    }
                }
            default:
                for (String item : tmps) {
                    parameters.add(item);
                }
        }

        return parameters;
    }
}
