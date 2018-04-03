package levandowski.primao.criptocon.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import levandowski.primao.criptocon.R;

@SuppressLint("ValidFragment")
public class SecondFragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.second_fragment, container, false);
        return myView;
    }
}
