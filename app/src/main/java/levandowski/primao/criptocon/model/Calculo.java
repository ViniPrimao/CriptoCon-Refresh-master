package levandowski.primao.criptocon.model;

import android.widget.EditText;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Calculo {
    @SerializedName("price_brl")
    @Expose
    private double cotacao;
    private double valor;
    public Calculo() {

    }

    public double getValor() {return valor;}

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getCotacao() {

        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    double formula(){
        return valor/cotacao;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("#,####0.0000");
        return df.format(formula())+"\n Criptomoedas";
    }
}