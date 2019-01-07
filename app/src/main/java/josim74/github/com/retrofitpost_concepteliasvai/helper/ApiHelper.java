package josim74.github.com.retrofitpost_concepteliasvai.helper;

import android.util.Log;

import josim74.github.com.retrofitpost_concepteliasvai.Api;
import josim74.github.com.retrofitpost_concepteliasvai.ApiClient;
import josim74.github.com.retrofitpost_concepteliasvai.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ApiHelper {
    public static void getPost() {

        Api api = ApiClient.getClient().create(Api.class);

        api.savePost(/*title:*/"Title", /*body:*/"Body", 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    //showResponse(response.body().toString());
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });

    }

}
