package com.baladika.tgcpokemon.component;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.baladika.tgcpokemon.DetailActivity;
import com.baladika.tgcpokemon.R;
import com.baladika.tgcpokemon.base.BaseParam;
import com.baladika.tgcpokemon.response.Data;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<Data> cardDataList;
    private Context context;

    public CardAdapter(List<Data> cardDataList, Context context) {
        this.cardDataList = cardDataList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCard;
        TextView nameCard;
        RelativeLayout itemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            imgCard = itemView.findViewById(R.id.item_card_image);
            nameCard = itemView.findViewById(R.id.item_card_name);
            itemLayout = itemView.findViewById(R.id.item_layout);
        }
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {

        final Data cardData = cardDataList.get(position);

        holder.nameCard.setText(cardData.getName());


        Glide.with(context)
                .load(cardData.getImages().getSmall())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imgCard);


        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(BaseParam.ID_CARD,cardData.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cardDataList.size();
    }


}
