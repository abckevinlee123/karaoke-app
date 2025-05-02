package com.karaokeapp.service.Spotify;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import com.fasterxml.jackson.annotation.JsonProperty;

@Service
public class SpotifyAuthService {

    private final WebClient authWebClient;

    private final String clientId = "3bcabd86a88e4115b51e57f8591d842b";      // put your real client id here
    private final String clientSecret = "5ba4565d89b94abc975fe6b03ef2d3e9";  // put your real client secret here

    public SpotifyAuthService(@Qualifier("spotifyAuthWebClient") WebClient authWebClient) {
        this.authWebClient = authWebClient;
    }

    public String getAccessToken() {
        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = java.util.Base64.getEncoder().encodeToString(credentials.getBytes());

        // TEMPORARY: Log the raw JSON response
        String rawResponse = authWebClient.post()
                .uri("/token")
                .header(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials)
                .header(HttpHeaders.CONTENT_TYPE)
                .bodyValue("grant_type=client_credentials")
                .retrieve()
                .bodyToMono(String.class) // Instead of parsing JSON, just grab as String
                .block(); // still synchronous for now

        // Parse the token manually (quick and dirty for now)
        int tokenStart = rawResponse.indexOf("\"access_token\":\"") + 16;
        int tokenEnd = rawResponse.indexOf("\"", tokenStart);
        return rawResponse.substring(tokenStart, tokenEnd);
    }

/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static class TokenResponse {
        @JsonProperty("access_token")
        private String accessToken;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String access_token) {
            this.accessToken = accessToken;
        }
    }
/////// UNDER WORK //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}