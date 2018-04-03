package levandowski.primao.criptocon;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {
    private Button btnFacebook;
    private Button btnglevandowski;
    private Button btnprimao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        btnFacebook = findViewById(R.id.about_btn_tree);
        btnprimao = findViewById(R.id.about_btn_two);
        btnglevandowski = findViewById(R.id.about_btn_one);
        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/CriptoCon39/";
                Intent a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse(url));
               startActivity(a);
            }
        });
        btnglevandowski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlll = "https://github.com/glevandowski";
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse(urlll));
                startActivity(b);
            }
        });
        btnprimao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urll = "https://github.com/ViniPrimao";
                Intent c = new Intent(Intent.ACTION_VIEW);
                c.setData(Uri.parse(urll));
                startActivity(c);
            }
        });
    }
}
