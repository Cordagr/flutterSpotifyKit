import android.content.Context;
import android.content.SharedPreferences;

public class TokenStorage {
    private static final String PREFS_NAME = "SpotifyPrefs";
    private static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String REFRESH_TOKEN_KEY = "refresh_token";
    private static final String EXPIRES_IN_KEY = "expires_in";

    private SharedPreferences sharedPreferences;

    public TokenStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void storeTokens(String accessToken, String refreshToken, int expiresIn) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(ACCESS_TOKEN_KEY, accessToken);
        editor.putString(REFRESH_TOKEN_KEY, refreshToken);
        editor.putInt(EXPIRES_IN_KEY, expiresIn);
        editor.apply();
    }

    public String getAccessToken() {
        return sharedPreferences.getString(ACCESS_TOKEN_KEY, null);
    }

    public String getRefreshToken() {
        return sharedPreferences.getString(REFRESH_TOKEN_KEY, null);
    }

    public int getExpiresIn() {
        return sharedPreferences.getInt(EXPIRES_IN_KEY, 0);
    }
}
