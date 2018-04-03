package levandowski.primao.criptocon.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.drm.DrmStore;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import levandowski.primao.criptocon.MainActivity;
import levandowski.primao.criptocon.R;
import levandowski.primao.criptocon.adapter.CoinAdapter;
import levandowski.primao.criptocon.model.Coin;
import static levandowski.primao.criptocon.MainActivity.*;
import static levandowski.primao.criptocon.MainActivity.adapterSpinner;
import static levandowski.primao.criptocon.MainActivity.coinArrayList;
import static levandowski.primao.criptocon.MainActivity.coinSpinner;


@SuppressLint("ValidFragment")
public class FirstFragment extends Fragment {
    private RecyclerView recyclerViewCoin;
    private Spinner spinnerCoin;
    public interface AoSelecionarItemEventos {
        public void aoSelecionarItem(String item);
    }
    public FirstFragment() {

    }

    View v;

    @SuppressLint("ResourceType")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.first_fragment, container, false);//iniciando fragment
        //referencias
        recyclerViewCoin = v.findViewById(R.id.first_recyclerViewCoin);
        spinnerCoin = v.findViewById(R.id.first_spinner_coin);

        //fecha referencia

        //ArrayList
        adapter = new CoinAdapter(getActivity(), new ArrayList<Coin>());
        adapter.notifyDataSetChanged();
        //fecha ArrayList

        //ReciclerView
        recyclerViewCoin.setAdapter(adapter);
        recyclerViewCoin.setHasFixedSize(true);
        recyclerViewCoin.setLayoutManager(new LinearLayoutManager(getActivity()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCoin.setLayoutManager(linearLayoutManager);
        //fecha ReciclerView

        //spinner
        adapterSpinner = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item , coinSpinner);
        spinnerCoin.setAdapter(adapterSpinner);
        coinSpinner.add("Todas as Moedas");
        adapterSpinner.notifyDataSetChanged();

        spinnerCoin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,  int i, long l) {
               // Toast.makeText(getActivity(), " " +i, Toast.LENGTH_SHORT).show();
                if (!coinArrayList.isEmpty()) {
                    ArrayList<Coin> coinss = new ArrayList<>();
                   if( spinnerCoin.getItemAtPosition(i).toString().equals("Todas as Moedas")){
                       adapter.setCoin(coinArrayList);
                       adapter.notifyDataSetChanged();
                   }else{
                           coinss.add(coinArrayList.get(i-1));
                           adapter.setCoin(coinss);
                           adapter.notifyDataSetChanged();
                           adapterSpinner.notifyDataSetChanged();
                        }
                    }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapter.setCoin(coinArrayList);
                adapter.notifyDataSetChanged();
            }

        });
        final MainActivity o= (MainActivity) getActivity();
        refresh();
        o.getCoin();
        return  v;
    }//oncreate


//comando responsavel por atualizar os cards
  public void refresh(){
      final MainActivity c= (MainActivity) getActivity();
      final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipelayout);
      swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
          @Override
          public void onRefresh() {
              swipeRefreshLayout.setRefreshing(true);
              (new Handler()).postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      swipeRefreshLayout.setRefreshing(false);
                      coinArrayList.clear();
                      c.getCoin();
                  }
              },3000);
          }
      });
  }
}
