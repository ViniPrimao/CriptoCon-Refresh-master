package levandowski.primao.criptocon.adapter;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import levandowski.primao.criptocon.model.Coin;
import levandowski.primao.criptocon.R;


public class CoinAdapter extends RecyclerView.Adapter {

    private Context context;
    public ArrayList<Coin> coin;

    private static ClickListener clickListener;

    public CoinAdapter(Context context, ArrayList<Coin> coin) {
        this.context = context;
        this.coin = coin;
    }


    public void setCoin(ArrayList<Coin> coin) {
        this.coin = coin;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_coin_line, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder hold = (ViewHolder) holder;
        Coin c = coin.get(position);
        //comandos responsaveis por setar valores do json nos cards

        //comando responsável por formatar os numeros do json de maneira correta.
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        //TITULO : comandos responsáveis  por setar os textos e cores vindo do json nos cards

        //condicional de 24hrs
        if(c.getPercent_change_24h()==null){
            hold.priceTwentyView.setText("Sem Informação");
            hold.priceTwentyView.setTextColor(Color.BLACK);
        }
        else{
            if (c.getPercent_change_24h()>= 0.01){
                hold.priceTwentyView.setTextColor(Color.GREEN);
                hold.percentsTwenty.setTextColor(Color.GREEN);
            }
            else if (c.getPercent_change_24h()<=-0.01){
                hold.priceTwentyView.setTextColor(Color.RED);
                hold.percentsTwenty.setTextColor(Color.RED);
            }
            hold.priceTwentyView.setText(String.valueOf(c.getPercent_change_24h()));
        }

        //condicional de 1hrs
        if(c.getPercent_change_1h()==null){
            hold.priceOneView.setText("Sem Informação");
            hold.priceOneView.setTextColor(Color.BLACK);
        }
        else{
            if (c.getPercent_change_1h()>= 0.01){
                hold.priceOneView.setTextColor(Color.GREEN);
                hold.percentsOne.setTextColor(Color.GREEN);
            }
            else if (c.getPercent_change_1h()<=-0.01) {
                hold.priceOneView.setTextColor(Color.RED);
                hold.percentsOne.setTextColor(Color.RED);
            }
            hold.priceOneView.setText(String.valueOf(c.getPercent_change_1h()));
        }

        //condicional de erro para preços
        if(c.getPrice_brl()==null){
            hold.priceView.setText("Sem Informação");
        }
        else{
            hold.priceView.setText((nf.format(c.getPrice_brl())));
        }

        //condicional de erro para o nome das moedas
        if(c.getName()==null){
            hold.nomeView.setText("Sem Informação");
        }
        else {
            hold.nomeView.setText(c.getName());
        }

    }

    @Override
    public int getItemCount() {
        return coin.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private final TextView nomeView;
        private final TextView priceTwentyView;
        private final TextView priceOneView;
        private final TextView priceView;
        private final TextView percentsOne;
        private final TextView percentsTwenty;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            //chamando as referencias do xml coinline
            nomeView = (TextView) v.findViewById(R.id.coin_answer_view_name);
            priceTwentyView = (TextView) v.findViewById(R.id.coin_answer_view_price_twenty_four_hours);
            priceOneView= (TextView) v.findViewById(R.id.coin_answer_view_price_one_hour);
            priceView = (TextView) v.findViewById(R.id.coin_answer_view_price);
            percentsOne = (TextView) v.findViewById(R.id.coin_percentage_one_hour);
            percentsTwenty = (TextView) v.findViewById(R.id.coin_percentage_twenty_four_hours);
            //aqui termina as refs
        }


        @Override
        public void onClick(View view) {
            // clickListener.onItemClick(getAdapterPosition(), view);
            //Toast.makeText(view.getContext(), "position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            //.onItemLongClick(getAdapterPosition(), view);
            return true;
        }

    }

    public void setOnItemClickListener(ClickListener clickListener) {
        CoinAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

}