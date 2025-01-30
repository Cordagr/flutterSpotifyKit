import okhttp3.*;

import java.io.IOException;

public class SpotifyAuthService {

    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";
    private static final String CLIENT_ID = "YOUR_CLIENT_ID";
    private static final String CLIENT_SECRET = "YOUR_CLIENT_SECRET";
    private static final String REDIRECT_URI = "http://localhost:8888/callback";

    public void exchangeCodeForToken(String code) {
        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "authorization_code")
                .add("code", code)
                .add("redirect_uri", REDIRECT_URI)
                .add("client_id", CLIENT_ID)
                .add("client_secret", CLIENT_SECRET)
                .build();

        Request request = new Request.Builder()
                .url(TOKEN_URL)
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                // Handle the error here
            }

          public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
        String responseBody = response.body().string();
        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();
        String accessToken = json.get("access_token").getAsString();
        String refreshToken = json.get("refresh_token").getAsString();
        int expiresIn = json.get("expires_in").getAsInt();

        // Store the access token and refresh token securely
        System.out.println("Access Token: " + accessToken);
        System.out.println("Refresh Token: " + refreshToken);
        System.out.println("Expires In: " + expiresIn);
        } else {
        // Handle the error here
        System.err.println("Error: " + response.code() + " - " + response.message());
    }
}
        });
    }
}
