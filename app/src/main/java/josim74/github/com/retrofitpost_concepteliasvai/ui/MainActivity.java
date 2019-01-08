package josim74.github.com.retrofitpost_concepteliasvai.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import josim74.github.com.retrofitpost_concepteliasvai.rest.Api;
import josim74.github.com.retrofitpost_concepteliasvai.R;
import josim74.github.com.retrofitpost_concepteliasvai.model.Post;
import josim74.github.com.retrofitpost_concepteliasvai.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "SEND_POST";
    private TextView mResponseTv;
    private Api api;
    private EditText titleEt;
    private EditText bodyEt;
    private Button submitBtn;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    doSearch();
            }
        });

        userViewModel.getPostMutableLiveData().observe(this, new Observer<Post>() {
            @Override
            public void onChanged(@Nullable Post post) {
                mResponseTv.setText(post.getId()+post.getUserId()+post.getTitle()+post.getBody());
            }
        });
    }

    private void doSearch() {
        String title = titleEt.getText().toString().trim();
        String body = bodyEt.getText().toString().trim();
        if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
            Post post = new Post();
            post.setTitle(title);
            post.setBody(body);
            post.setId(101);
            post.setUserId(1);
            userViewModel.savePost(post);
        }
    }

    private void initView() {
        titleEt = findViewById(R.id.et_title);
        bodyEt = findViewById(R.id.et_body);
        submitBtn = findViewById(R.id.btn_submit);
        mResponseTv = findViewById(R.id.tv_response);
    }
}
