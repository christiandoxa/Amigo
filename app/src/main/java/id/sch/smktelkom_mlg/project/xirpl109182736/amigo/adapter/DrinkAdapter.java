package id.sch.smktelkom_mlg.project.xirpl109182736.amigo.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.R;
import id.sch.smktelkom_mlg.project.xirpl109182736.amigo.model.Drink;

/**
 * Created by redUSER on 11/25/2016.
 */

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.ViewHolder> {
    ArrayList<Drink> drinklist;
    IDrinkAdapter mIDrinkAdapter;

    public DrinkAdapter(Context context, ArrayList<Drink> drinklist) {
        this.drinklist = drinklist;
        mIDrinkAdapter = (IDrinkAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_drink, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drink drink = drinklist.get(position);
        holder.tvJudul.setText(drink.judul);
        holder.tvDeskripsi.setText(drink.deskripsi);
        holder.ivfoto.setImageURI(Uri.parse(drink.foto));
    }

    @Override
    public int getItemCount() {
        if (drinklist != null)
            return drinklist.size();
        return 0;
    }

    public interface IDrinkAdapter {
        void doClick(int pos);
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mIDrinkAdapter.doClick(getAdapterPosition());
                }
            });

        }
    }
}
