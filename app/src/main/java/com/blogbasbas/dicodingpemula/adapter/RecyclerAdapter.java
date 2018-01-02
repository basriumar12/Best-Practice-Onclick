package com.blogbasbas.dicodingpemula.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogbasbas.dicodingpemula.R;
import com.blogbasbas.dicodingpemula.modelpojo.ResponseWisata;
import com.blogbasbas.dicodingpemula.modelpojo.WisataItem;
import com.blogbasbas.dicodingpemula.onclick.CustomOnItemClickListener;
import com.bumptech.glide.Glide;
import com.infideap.atomic.FutureCallback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by User on 01/01/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {
    private ListItemClickListener mOnClickListener;
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex, WisataItem wisataItem);
    }
    public RecyclerAdapter(List<WisataItem> data, Context context, ListItemClickListener mOnClickListener) {

  //  public RecyclerAdapter(List<WisataItem> data, Context context) {
        this.mOnClickListener = mOnClickListener;
        this.data = data;
        this.context = context;
    }

    List<WisataItem> data;
    Context context;
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

            return new MyHolder(view);

    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.txtNama.setText(data.get(position).getNamaWisata());
        holder.txtAlamat.setText(data.get(position).getAlamatWisata());
        Picasso.with(context)
              .load("https://wisata-smg-basri.000webhostapp.com/wisata_semarang/wisata_semarang/img/wisata/"+data.get(position).getGambarWisata())
              .error(R.mipmap.ic_launcher)
              .placeholder(R.mipmap.ic_launcher)
              .into(holder.imgWisata);
        final  WisataItem wisataItem = data.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClickListener.onListItemClick(position, wisataItem );
            }
        });
        /*holder.itemView.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {

            }
        }));*/

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtNama, txtAlamat;
        ImageView imgWisata;
        public MyHolder(View itemView) {

            super(itemView);

            txtNama= (TextView)itemView.findViewById(R.id.tv_item_name);
            txtAlamat= (TextView) itemView.findViewById(R.id.tv_item_alamat);
            imgWisata = (ImageView) itemView.findViewById(R.id.img_item_wisata);
        }


    }

}
