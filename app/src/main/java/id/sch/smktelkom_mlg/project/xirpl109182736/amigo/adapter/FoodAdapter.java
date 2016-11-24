package id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.R;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Food;

/**
 * Created by Qoriatul Masfufah on 11/25/2016.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    ArrayList<Food> foodlist;

    public FoodAdapter(ArrayList<Food> foodlist) {
        this.foodlist = foodlist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_food, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Food food = foodlist.get(position);
        holder.tvJudul.setText(food.judul);
        holder.tvDeskripsi.setText(food.deskripsi);
        holder.ivfoto.setImageDrawable(food.foto);
    }

    @Override
    public int getItemCount() {
        if (foodlist != null)
            return foodlist.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivfoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivfoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
