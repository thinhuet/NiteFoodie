package com.t3h.nitefoodie.ui.main.account;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.common.Constants;
import com.t3h.nitefoodie.model.User;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;

/**
 * Created by thinhquan on 6/25/17.
 */

public class AccountFragment extends BaseMVPFragment {
    private Toolbar toolbar;
    private String idUser;
    private DatabaseReference mData;
    private ImageView ivUserAvatar;
    private TextView tvUserName;
    private TextView tvUserEmail;

    @Override
    public int getLayoutMain() {
        return R.layout.account_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        ivUserAvatar = (ImageView) getView().findViewById(R.id.iv_user_avatar);
        tvUserName = (TextView) getView().findViewById(R.id.tv_user_name);
        tvUserEmail = (TextView) getView().findViewById(R.id.tv_user_email);
    }

    @Override
    public void initComponents() {
        mData = FirebaseDatabase.getInstance().getReference();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("Tài Khoản");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initProfile();
    }

    private void initProfile() {
        idUser = getArguments().getString(Constants.ID_USER);

        mData.child(Constants.USERS).child(idUser).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    User user = dataSnapshot.getValue(User.class);
                    Picasso.with(getContext()).load(user.getPhotoUrl())
                            .into(ivUserAvatar);
                    tvUserName.setText(user.getName());
                    tvUserEmail.setText(user.getEmail());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void setEvents() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackRoot();
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getBaseActivity().getMenuInflater().inflate(R.menu.menu_account_toolbar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_account_logout:
                logOut();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut() {

    }
}
