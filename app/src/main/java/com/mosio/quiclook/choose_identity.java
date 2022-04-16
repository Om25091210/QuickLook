package com.mosio.quiclook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.furkanakdemir.surroundcardview.SurroundCardView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class choose_identity extends AppCompatActivity {

    SurroundCardView user;
    String choice;
    ArrayList<String> list=new ArrayList<>();
    Button next,y_n_1,y_b_2,add,next_p,next_e;
    TextView head,tap,your_business,category,Name,phone,address,location,textView_p,Email,Name_1,phone_1,
            strength,Name_e,phone_e;
    EditText category_edit,name_edit,phone_edit,location_edit,address_edit,email_edit,name_edit_1,phone_edit_1,
            strength_edit,name_edit_e,phone_edit_e;
    ImageView imageView,bck,back2,p_back,e_back;
    Animation animFadein,fade_out;
    View yb_layout,_choice_,yb1,lp,epl;
    RecyclerView recyclerView;
    SurroundCardView admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_identity);

        Window window = choose_identity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(choose_identity.this, R.color.screen_bg));

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        fade_out= AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_out);

        user=findViewById(R.id.user);
        y_n_1=findViewById(R.id.y_n_1);
        yb1=findViewById(R.id.yb1);
        bck=findViewById(R.id.bck);
        add=findViewById(R.id.add);
        back2=findViewById(R.id.back2);
        epl=findViewById(R.id.epl);
        yb_layout=findViewById(R.id.yb);
        _choice_=findViewById(R.id.choice);
        lp=findViewById(R.id.lp);
        recyclerView=findViewById(R.id.rv);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(choose_identity.this);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setLayoutManager(layoutManager1);

        your_business=findViewById(R.id.textView3);
        category=findViewById(R.id.category);
        Name=findViewById(R.id.Name);
        phone=findViewById(R.id.phone);
        category_edit=findViewById(R.id.category_edit);
        name_edit=findViewById(R.id.name_edit);
        phone_edit=findViewById(R.id.phone_edit);
        head=findViewById(R.id.textView2);
        tap=findViewById(R.id.select);
        imageView=findViewById(R.id.imageView4);
        next=findViewById(R.id.next);
        admin=findViewById(R.id.admin);

        address=findViewById(R.id.address);
        address_edit=findViewById(R.id.address_edit);
        location=findViewById(R.id.location);
        location_edit=findViewById(R.id.location_edit);
        y_b_2=findViewById(R.id.y_b_2);
        bck=findViewById(R.id.bck);

        textView_p=findViewById(R.id.textView_p);
        Email=findViewById(R.id.Email);
        email_edit=findViewById(R.id.email_edit);
        Name_1=findViewById(R.id.Name_1);
        name_edit_1=findViewById(R.id.name_edit_1);
        phone_1=findViewById(R.id.phone_1);
        phone_edit_1=findViewById(R.id.phone_edit_1);
        next_p=findViewById(R.id.next_p);
        p_back=findViewById(R.id.p_back);

        strength=findViewById(R.id.strength);
        strength_edit=findViewById(R.id.strength_edit);
        name_edit_e=findViewById(R.id.name_edit_e);
        Name_e=findViewById(R.id.Name_e);
        phone_e=findViewById(R.id.phone_e);
        phone_edit_e=findViewById(R.id.phone_edit_e);
        next_e=findViewById(R.id.next_e);
        e_back=findViewById(R.id.e_back);

        user.setOnClickListener(v->{
            if(!user.isCardSurrounded()) {
                choice="user";
                user.setSurroundStrokeWidth(R.dimen.width_card);
                user.surround();
                admin.release();
            }
        });
        admin.setOnClickListener(v-> {
            if (!admin.isCardSurrounded()) {
                choice="admin";
                admin.setSurroundStrokeWidth(R.dimen.width_card);
                admin.surround();
                user.release();
            }
        });

        next.setOnClickListener(v->{
            offanimate(user);
            offanimate(admin);
            offanimate(head);
            offanimate(tap);
            offanimate(next);
            offanimate(imageView);
            new Handler(Looper.myLooper()).postDelayed(() -> {
                yb_layout.setVisibility(View.VISIBLE);
                yb_layout.startAnimation(animFadein);
            },600);
        });
        bck.setOnClickListener(v->{
            yb_layout.startAnimation(fade_out);
            yb_layout.setVisibility(View.GONE);
            onAnimate(user);
            onAnimate(admin);
            onAnimate(head);
            onAnimate(tap);
            onAnimate(next);
            onAnimate(imageView);
        });
        y_n_1.setOnClickListener(v->{
            offanimate(category);
            offanimate(category_edit);
            offanimate(name_edit);
            offanimate(Name);
            offanimate(phone);
            offanimate(phone_edit);
            offanimate(y_n_1);
            offanimate(bck);
            new Handler(Looper.myLooper()).postDelayed(() -> {
                yb1.setVisibility(View.VISIBLE);
                yb1.startAnimation(animFadein);
            },600);
        });
        back2.setOnClickListener(v->{
            yb1.startAnimation(fade_out);
            yb1.setVisibility(View.GONE);
            onAnimate(category);
            onAnimate(category_edit);
            onAnimate(name_edit);
            onAnimate(Name);
            onAnimate(phone);
            onAnimate(phone_edit);
            onAnimate(y_n_1);
            onAnimate(bck);
        });

        y_b_2.setOnClickListener(v->{
            offanimate(address);
            offanimate(address_edit);
            offanimate(location);
            offanimate(location_edit);
            offanimate(add);
            offanimate(back2);
            offanimate(your_business);
            offanimate(recyclerView);
            offanimate(y_b_2);
            new Handler(Looper.myLooper()).postDelayed(() -> {
                lp.setVisibility(View.VISIBLE);
                lp.startAnimation(animFadein);
            },600);
        });

        p_back.setOnClickListener(v->{
            lp.startAnimation(fade_out);
            lp.setVisibility(View.GONE);
            onAnimate(address);
            onAnimate(address_edit);
            onAnimate(location);
            onAnimate(location_edit);
            onAnimate(add);
            onAnimate(back2);
            onAnimate(your_business);
            onAnimate(recyclerView);
            onAnimate(y_b_2);
        });

        next_p.setOnClickListener(v->{
            offanimate(textView_p);
            offanimate(email_edit);
            offanimate(Email);
            offanimate(Name_1);
            offanimate(name_edit_1);
            offanimate(phone_1);
            offanimate(phone_edit_1);
            offanimate(p_back);
            offanimate(next_p);
            new Handler(Looper.myLooper()).postDelayed(() -> {
                epl.setVisibility(View.VISIBLE);
                epl.startAnimation(animFadein);
            },600);
        });

        e_back.setOnClickListener(v->{
            epl.startAnimation(fade_out);
            epl.setVisibility(View.GONE);
            onAnimate(textView_p);
            onAnimate(email_edit);
            onAnimate(Email);
            onAnimate(Name_1);
            onAnimate(name_edit_1);
            onAnimate(phone_1);
            onAnimate(phone_edit_1);
            onAnimate(p_back);
            onAnimate(next_p);
        });

        next_e.setOnClickListener(v->{
            Toast.makeText(choose_identity.this, "To be continued !!!", Toast.LENGTH_SHORT).show();
        });



        add.setOnClickListener(v->{
            list.add(location_edit.getText().toString().trim());
            location_edit.setText("");
            Collections.reverse(list);
            Adapter adapter=new Adapter(choose_identity.this,list);
            if(recyclerView!=null) {
                recyclerView.setItemViewCacheSize(20);
                recyclerView.setDrawingCacheEnabled(true);
                recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
                recyclerView.setAdapter(adapter);
            }
        });
    }
    void offanimate(View view){
        ObjectAnimator move=ObjectAnimator.ofFloat(view, "translationX",-800f);
        move.setDuration(1000);
        ObjectAnimator alpha2= ObjectAnimator.ofFloat(view, "alpha",0);
        alpha2.setDuration(500);
        AnimatorSet animset=new AnimatorSet();
        animset.play(alpha2).with(move);
        animset.start();
    }
    void onAnimate(View view){
        ObjectAnimator move=ObjectAnimator.ofFloat(view, "translationX",0f);
        move.setDuration(1000);
        ObjectAnimator alpha2= ObjectAnimator.ofFloat(view, "alpha",100);
        alpha2.setDuration(500);
        AnimatorSet animset=new AnimatorSet();
        animset.play(alpha2).with(move);
        animset.start();
    }



}