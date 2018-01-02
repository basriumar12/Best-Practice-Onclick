package com.blogbasbas.dicodingpemula;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "hasil" ;
    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.txtDetailNama)
    TextView txtDetailNama;
    @BindView(R.id.txtDetailAlamat)
    TextView txtDetailAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent getdata = getIntent();
        String imgWisata =getdata.getStringExtra("gambar");
        Log.d(TAG, "onCreate: "+imgWisata);
        txtDetailNama.setText(getdata.getStringExtra("nama"));
        txtDetailAlamat.setText(getdata.getStringExtra("alamat"));
        Picasso.with(DetailActivity.this)
                .load(imgWisata)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imgDetail);
    }
}
