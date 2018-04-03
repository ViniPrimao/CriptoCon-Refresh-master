package levandowski.primao.criptocon.fragments;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import levandowski.primao.criptocon.R;


@SuppressLint("ValidFragment")
public class FifthFragment extends Fragment {

    public interface AoSelecionarItemEventos {
        public void aoSelecionarItem( String item );
    }
    public FifthFragment() {
    }
    View myView;
    private Button btnfacebook;
    private Button btnWhatsApp;
    private ImageView imagem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fifth_fragment, container, false);

       Button btnFacebook=(Button) myView.findViewById(R.id.fifth_btn_share);
       final ImageView imagem=(ImageView) myView.findViewById(R.id.fifth_image_constructor);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              share();
            }
        });
        return myView;
    }
    void share(){
        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.bitcoin);
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        File f = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg");
        try {
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        share.putExtra(Intent.EXTRA_TEXT, "Instale e acompanhe novas tendências do mercado das Criptomoedas /*LinkCriptoCon*/");


        share.putExtra(Intent.EXTRA_STREAM, Uri.parse("CriptoCon-master\\app\\src\\main\\res\\drawable\\bitcoin.png"));
        startActivity(Intent.createChooser(share, "Share Image"));
    }
}
