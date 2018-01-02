package com.blogbasbas.dicodingpemula;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.blogbasbas.dicodingpemula.adapter.RecyclerAdapter;
import com.blogbasbas.dicodingpemula.modelpojo.ResponseWisata;
import com.blogbasbas.dicodingpemula.modelpojo.WisataItem;
import com.google.gson.Gson;
import com.infideap.atomic.Atom;
import com.infideap.atomic.FutureCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.ListItemClickListener {

    private static final String TAG = "TAG";
    @BindView(R.id.rv_category)
    RecyclerView rvCategory;
    @BindView(R.id.pd)
    ProgressBar pd;
    @BindView(R.id.txtProgress)
    TextView txtProgress;
    List<WisataItem> datawisata ;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Atom.with(MainActivity.this)
                // .load("https://reqres.in/api/users/2")
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/wisata/read_wisata.php")
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        if (e != null)
                            Log.e(TAG, "e : " + new Gson().toJson(e));

                        Log.e(TAG, "onCompleted  ggg: " + result);
                    }
                });

        pd.setVisibility(View.VISIBLE);
        txtProgress.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                getData();
            }
        }, 1500);

    }

    private void getData() {
        Atom.with(MainActivity.this)
                .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/wisata/read_wisata.php")
                .as(ResponseWisata.class)
                .setCallback(new FutureCallback<ResponseWisata>() {
                    @Override
                    public void onCompleted(Exception e, ResponseWisata result) {
                        pd.setVisibility(View.VISIBLE);
                           txtProgress.setVisibility(View.VISIBLE);
                        if (e != null) {
                            e.printStackTrace();
                            Log.d(TAG, "onCompleted: "+e.toString());
                            Toast.makeText(MainActivity.this, " gagal request", Toast.LENGTH_SHORT).show();
                        } else if (result.getWisata() != null) {
                            List<WisataItem> list = result.getWisata();
                            Log.d(TAG, "onCompleted: " + list);
                            Log.d(TAG, "onCompleted: " + result.getWisata().get(1).getNamaWisata());
                            RecyclerAdapter adapter = new RecyclerAdapter(list,MainActivity.this, MainActivity.this);

                            pd.setVisibility(View.GONE);
                            txtProgress.setVisibility(View.GONE);
                            rvCategory.setAdapter(adapter);
                            rvCategory.setLayoutManager(new LinearLayoutManager(MainActivity.this));


                        }

                    }
                });

    }

    @Override
    public void onListItemClick(int clickedItemIndex, WisataItem wisataItem) {
        if (mToast != null) {
            mToast.cancel();
        }


        String toastMessage = "Item #" + clickedItemIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        mToast.show();
       /* Intent kirimData = new Intent(MainActivity.this, DetailActivity.class);
        kirimData.putExtra("nama",datawisata.get(clickedItemIndex));
        kirimData.putExtra("alamat", datawisata.get(clickedItemIndex).getAlamatWisata());
        kirimData.putExtra("gambar",datawisata.get(clickedItemIndex).getGambarWisata());
        startActivity(kirimData);*/


    }
}
