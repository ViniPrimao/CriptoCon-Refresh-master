package levandowski.primao.criptocon.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import levandowski.primao.criptocon.R;


@SuppressLint("ValidFragment")
public class FourFragment extends Fragment {
    private Button btnWalltime;
    private Button btnBinance;
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.four_fragment, container, false);
        Button btnWalltime= (Button) myView.findViewById(R.id.four_btn_card_one);
        Button btnBinance= (Button) myView.findViewById(R.id.four_btn_card_two);
        
        btnWalltime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://walltime.info/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        btnBinance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://play.google.com/store/apps/details?id=com.binance.dev";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        return myView;
    }
}
