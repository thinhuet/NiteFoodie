package com.t3h.nitefoodie.ui.main.account;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.common.Constants;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

/**
 * Created by dungtx on 04/07/2017.
 */

public class RegisterFragment extends BaseMVPFragment implements Constants, View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private Toolbar toolbar;
    private DatabaseReference mData;
    private ImageView ivStore;
    private EditText edtName;
    private EditText edtAddress;
    private EditText edtPhone;
    private String idUser;

    private Button btnAddFood;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public int getLayoutMain() {
        return R.layout.store_register_fragment;
    }

    @Override
    public void findViewByIds() {
        toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        ivStore = (ImageView) getView().findViewById(R.id.iv_store);
        edtName = (EditText) getView().findViewById(R.id.edt_name);
        edtAddress = (EditText) getView().findViewById(R.id.edt_address);
        edtPhone = (EditText) getView().findViewById(R.id.edt_phone);
        btnAddFood = (Button) getView().findViewById(R.id.btn_add_food);

    }

    @Override
    public void initComponents() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("My Store");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mData = FirebaseDatabase.getInstance().getReference();
        idUser = getArguments().getString(Constants.ID_USER);
    }

    @Override
    public void setEvents() {
        btnAddFood.setOnClickListener(this);
        ivStore.setOnClickListener(this);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_store_register_toolbar, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_done:
                updateStore();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_store:
                PopupMenu popupMenu = new PopupMenu(getContext(), ivStore);
                popupMenu.getMenuInflater().inflate(R.menu.menu_add_image, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(this);
                popupMenu.show();
                break;
            case R.id.btn_add_food:
                //uploadImageToStorage();
                break;
        }
    }

    private void updateStore() {

    }

    private void writeNewUser(String name, String address, String phone) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_take_picture:
                takePicture();
                break;
            case R.id.action_gallery:
                chooseGallery();
                break;
        }
        return false;
    }

    private void chooseGallery() {
        Intent imagePickerIntent = new Intent(Intent.ACTION_PICK);
        imagePickerIntent.setType("image/*");
        startActivityForResult(imagePickerIntent, REQUEST_LOAD_GALLERY);
    }

    private void takePicture() {
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(captureIntent, REQUEST_LOAD_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == getActivity().RESULT_OK && data != null) {
            if (requestCode == REQUEST_LOAD_GALLERY) {
                Uri imgUri = data.getData();
                Picasso.with(getContext()).load(imgUri).into(ivStore);
            }

            if (requestCode == REQUEST_LOAD_CAPTURE) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                ivStore.setImageBitmap(bitmap);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void uploadImageToStorage() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        ivStore.setDrawingCacheEnabled(true);
        ivStore.buildDrawingCache();
        Bitmap bitmap = ivStore.getDrawingCache();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] data = baos.toByteArray();

        Calendar calendar = Calendar.getInstance();

        StorageReference imgUpload = storageRef.child("img" + calendar.getTimeInMillis() + ".png");
        UploadTask uploadTask = imgUpload.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Toast.makeText(getContext(), "Loi upload hinh anh", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                Log.d(RegisterFragment.class.getSimpleName(), downloadUrl.toString());
            }
        });
    }
}
