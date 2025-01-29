import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SpotifyCallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith("http://localhost:8888/callback")) {
            String code = uri.getQueryParameter("code");
            if (code != null) {
                // Exchange the authorization code for an access token
                exchangeCodeForToken(code);
            }
        }
    }

    private void exchangeCodeForToken(String code) {
        // Implement the logic to exchange the code for an access token
        // This might involve making a network request to Spotify's token endpoint
    }
}
