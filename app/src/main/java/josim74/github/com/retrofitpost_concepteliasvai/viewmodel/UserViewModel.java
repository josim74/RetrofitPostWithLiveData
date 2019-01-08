package josim74.github.com.retrofitpost_concepteliasvai.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import josim74.github.com.retrofitpost_concepteliasvai.helper.ApiHelper;
import josim74.github.com.retrofitpost_concepteliasvai.model.Post;

public class UserViewModel extends ViewModel {
    private final MutableLiveData<Post> postMutableLiveData;
    //public final MutableLiveData<List<Post>> postList;

    public UserViewModel(){
        postMutableLiveData = new MutableLiveData<>();
        //postList = new MutableLiveData<>();
    }

    public MutableLiveData<Post> getPostMutableLiveData() {
        return postMutableLiveData;
    }

    public void savePost(Post post){
        ApiHelper.savePost(post,postList -> {
            if(!postList.isEmpty()) {
                postMutableLiveData.setValue(postList.get(0));
            }
        });
    }
}
