package com.t3h.nitefoodie.ui.main.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.t3h.nitefoodie.R;
import com.t3h.nitefoodie.common.Constants;
import com.t3h.nitefoodie.ui.base.fragment.BaseMVPFragment;
import com.t3h.nitefoodie.ui.model.Store;

/**
 * Created by dungtx on 04/07/2017.
 */

public class RegisterFragment extends BaseMVPFragment implements View.OnClickListener {

    private DatabaseReference mData;
    private EditText edtName;
    private EditText edtAddress;
    private EditText edtPhone;
    private String idUser;

    private Button btnRegister;

    @Override
    public int getLayoutMain() {
        return R.layout.store_register_fragment;
    }

    @Override
    public void findViewByIds() {
        edtName = (EditText) getView().findViewById(R.id.edt_name);
        edtAddress = (EditText) getView().findViewById(R.id.edt_address);
        edtPhone = (EditText) getView().findViewById(R.id.edt_phone);
        btnRegister = (Button) getView().findViewById(R.id.btn_register);

    }

    @Override
    public void initComponents() {
        mData = FirebaseDatabase.getInstance().getReference();
        idUser = getArguments().getString(Constants.ID_USER);
    }

    @Override
    public void setEvents() {
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = edtName.getText().toString();
        String address = edtAddress.getText().toString();
        String phone = edtPhone.getText().toString();

        writeNewUser(name, address, phone);
    }

    private void writeNewUser( String name, String address, String phone) {

        Store store = new Store(name, address, phone);

        mData.child("Store").child(idUser).setValue(store);
    }

}
