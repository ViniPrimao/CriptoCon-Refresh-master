package levandowski.primao.criptocon.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import levandowski.primao.criptocon.MainActivity;
import levandowski.primao.criptocon.adapter.CoinAdapter;
import levandowski.primao.criptocon.model.Calculo;
import levandowski.primao.criptocon.R;
import levandowski.primao.criptocon.model.Coin;
import levandowski.primao.criptocon.util.MoneyTextWatcher;

import static levandowski.primao.criptocon.MainActivity.adapter;
import static levandowski.primao.criptocon.MainActivity.adapterSpinner;
import static levandowski.primao.criptocon.MainActivity.coinArrayList;
import static levandowski.primao.criptocon.MainActivity.coinSpinner;


@SuppressLint("ValidFragment")
public class ThirdFragment extends Fragment {
    private EditText valorCoin;
    private EditText valorReais;
    private TextView resposta;
    private Button buttonCalc;
    private Spinner spinnerCoin;
    MainActivity j=(MainActivity) getActivity();

    Calculo c = new Calculo();
    Locale mLocale = new Locale("pt", "BR");

    public interface AoSelecionarItemEventos {
        public void aoSelecionarItem(String item);
    }

    public ThirdFragment() {
    }

    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.third_fragment, container, false);
        valorReais = (EditText) v.findViewById(R.id.third_edit_cotacao);
        valorCoin = (EditText) v.findViewById(R.id.third_edit_valor);
        resposta = (TextView) v.findViewById(R.id.third_view_answer);
        buttonCalc = (Button) v.findViewById(R.id.third_btn_calcular);
        spinnerCoin = (Spinner) v.findViewById(R.id.first_spinner_coin);


        adapter = new CoinAdapter(getActivity(), new ArrayList<Coin>(0));
        adapter.notifyDataSetChanged();

        adapterSpinner = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, coinSpinner);
        spinnerCoin.setAdapter(adapterSpinner);
        adapterSpinner.notifyDataSetChanged();

        spinnerCoin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ArrayList<Coin> coinss = new ArrayList<>();
                for( i = 1; i < coinArrayList.size(); i++){
                    coinss.add(null);
                    if(spinnerCoin.getSelectedItem().equals(coinArrayList.get(i-1).getName())
                            && coinArrayList.get(i).getName() !=null && coinArrayList.get(i).getPrice_brl() != null
                            && coinArrayList.get(i).getPercent_change_24h() != null
                            && coinArrayList.get(i).getPercent_change_1h() != null && i<1595){
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        coinss.add(coinArrayList.get(i-1));
                        adapter.setCoin(coinss);
                        adapter.notifyDataSetChanged();
                        Double priceBrl = coinss.get(i).getPrice_brl();
                        valorCoin.addTextChangedListener(new MoneyTextWatcher(valorCoin, mLocale));
                        if(!(priceBrl==null)) {
                            valorReais.setText(nf.format(priceBrl));
                        }else{
                            Toast.makeText(getActivity(),"Sem valores a ser exibido",Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapter.setCoin(coinArrayList);
                adapter.notifyDataSetChanged();
            }

        });

        buttonCalc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    c.setCotacao(Double.parseDouble(onlyNumbers(valorReais.getText().toString())));
                    c.setValor(Double.parseDouble(onlyNumbers(valorCoin.getText().toString())));
                    resposta.setText(String.valueOf(c.toString()));
                }catch (Exception ex){
                    Toast.makeText(getActivity(),"Obrigatório Preencher Valores",Toast.LENGTH_LONG).show();
                }
            }
        });

        return v;
    }
    public static String onlyNumbers(String str) {
        if (str != null) {
            return str.replaceAll("[^0123456789]", "");
        } else {
            return "";
        }
    }
}