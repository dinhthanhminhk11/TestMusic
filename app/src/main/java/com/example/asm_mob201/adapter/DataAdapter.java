package com.example.asm_mob201.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.asm_mob201.DanhSachTKActivity;
import com.example.asm_mob201.MainActivity;
import com.example.asm_mob201.R;
import com.example.asm_mob201.dto.TaiKhoan;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends BaseAdapter {
    ArrayList<TaiKhoan> list ;
    Activity activity;
    private Context context;

    public DataAdapter(Activity activity, ArrayList<TaiKhoan> list ){
        this.activity = activity;
        this.list = list;

    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getMaTk();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_tk, null);

        TextView tv_email = convertView.findViewById(R.id.tv_email);
        TextView tv_pass = convertView.findViewById(R.id.tv_pass);
        ImageView img_tk = convertView.findViewById(R.id.img_tk);

        tv_email.setText(list.get(position).getTenDangNhap());
        tv_pass.setText(list.get(position).getMatkhau());
        img_tk.setImageResource(R.drawable.ic_person);

//        img_tk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean pick = true;
//                if(pick==true){
//                    if(!checkCameraPermission()){
//                        requestCameraPermission();
//
//
//                    }else{
//                        PickImage();
//                    }
//                }else{
//                    if(!checkStoragePermission()){
//                        requestStoragePermission();
//
//
//                    }else{
//                        PickImage();
//                    }
//
//                }
//            }
//        });


        return convertView;
    }



//    private boolean checkStoragePermission(){
//        boolean res2 = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED;
//        return res2;
//    }
//
//    private boolean checkCameraPermission(){
//        boolean res1 = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED;
//        boolean res2 = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED;
//        return res1&&res2;
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    private void requestCameraPermission(){
//        activity.requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    private void requestStoragePermission(){
//        activity.requestPermissions( new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
//    }
//
//    private void PickImage(){
//    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            if (resultCode == RESULT_OK) {
//                Uri resultUri = result.getUri();
//            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                Exception error = result.getError();
//            }
//        }
//    }




}
