package com.example.quangndph14804_duanmau.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quangndph14804_duanmau.LoaiSach.LoaiSachFragment;
import com.example.quangndph14804_duanmau.R;
import com.example.quangndph14804_duanmau.model.LoaiSach;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Objects;

public class LoaiSachAdapter extends ArrayAdapter<LoaiSach> {
    private final Context context;
    LoaiSachFragment fragment;
    private final ArrayList<LoaiSach> list;
    TextView tvMaLS,tvTenLS;
    ImageView imgDelLS;
    public LoaiSachAdapter(@NonNull Context context,LoaiSachFragment fragment,ArrayList<LoaiSach> list) {
        super(context,0,list);
        this.context=context;
        this.fragment=fragment;
        this.list=list;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
      View v=convertView;
      if (v==null){
          LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          v=inflater.inflate(R.layout.loai_sach_item,null);
      }

      final LoaiSach item =list.get(position);
      if (item !=null){

          tvMaLS=v.findViewById(R.id.tvMaLS);
          tvTenLS=v.findViewById(R.id.tvTenLS);
          imgDelLS=v.findViewById(R.id.imgDelLS);

          tvMaLS.setText(MessageFormat.format("Mã ls: {0}", item.getMaLoai()));
          tvTenLS.setText(MessageFormat.format("Tên ls: {0}", item.getTenLoai()));

          imgDelLS.setOnClickListener(v1 -> fragment.xoa(String.valueOf(item.getMaLoai())));
      }
        assert item != null;
        if (Objects.equals(item.getTenLoai(), String.valueOf(false)))
     {
         tvTenLS.setTextColor(Color.GREEN);
     }

      return v;
    }
}
