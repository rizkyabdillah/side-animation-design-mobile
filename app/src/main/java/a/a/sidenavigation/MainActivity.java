package a.a.sidenavigation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView btnMenu, userpict;
    RelativeLayout mainContent;
    LinearLayout mainMenu;
    Animation fromtop, frombottom;
    TextView user, country;
    Button exp, ao, msg, st, so;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenu = (ImageView) findViewById(R.id.btn_menu);
        userpict = (ImageView) findViewById(R.id.userpict);

        exp = (Button) findViewById(R.id.exp);
        ao = (Button) findViewById(R.id.ao);
        msg = (Button) findViewById(R.id.msg);
        st = (Button) findViewById(R.id.st);
        so = (Button) findViewById(R.id.so);

        user = (TextView) findViewById(R.id.user);
        country = (TextView) findViewById(R.id.country);

        fromtop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        frombottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);

        mainContent = (RelativeLayout) findViewById(R.id.maincontent);
        mainMenu = (LinearLayout) findViewById(R.id.mainmenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainContent.getTranslationX() == 0) {
                    mainContent.animate().translationX(-735);
                    mainMenu.animate().translationX(-735);
                } else {
                    mainContent.animate().translationX(0);
                    mainMenu.animate().translationX(0);

                    exp.startAnimation(frombottom);
                    ao.startAnimation(frombottom);
                    msg.startAnimation(frombottom);
                    st.startAnimation(frombottom);
                    so.startAnimation(frombottom);

                    user.startAnimation(fromtop);
                    country.startAnimation(fromtop);
                    userpict.startAnimation(fromtop);
                }
            }
        });

        mainContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainContent.animate().translationX(-735);
                mainMenu.animate().translationX(-735);
            }
        });
    }
}