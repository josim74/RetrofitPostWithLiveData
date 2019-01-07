package josim74.github.com.retrofitpost_concepteliasvai.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import josim74.github.com.retrofitpost_concepteliasvai.model.Post;

public class UserViewModel extends ViewModel {
    private static MutableLiveData<String> postMutableLiveData;

    public MutableLiveData<String> getPostMutableLiveData() {
        if (postMutableLiveData == null) {
            postMutableLiveData = new MutableLiveData < String >();
        }
        return postMutableLiveData;
    }
}
