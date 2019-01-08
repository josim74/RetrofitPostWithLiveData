package josim74.github.com.retrofitpost_concepteliasvai.helper;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import josim74.github.com.retrofitpost_concepteliasvai.rest.Api;
import josim74.github.com.retrofitpost_concepteliasvai.rest.ApiClient;
import josim74.github.com.retrofitpost_concepteliasvai.model.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ApiHelper {

    public static void savePost(Post post, PostFetchingListener listener) {

        Api api = ApiClient.getClient().create(Api.class);

        api.savePost(/*title:*/post.getTitle(), /*body:*/post.getBody(), post.getUserId())
                .enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()) {

                    if(response.code() == 201) {
                        List<Post> postList = new ArrayList<>();
                        postList.add(response.body());
                        listener.onPostFetched(postList);

                        Log.i(TAG, "post submitted to API." + response.body().toString());
                    }
                    Log.i(TAG, "post submitted to API." + response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.e(TAG, "Unable to submit post to API.");
            }
        });
    }

    public interface PostFetchingListener{
        void onPostFetched(List<Post> postList);
    }

}
