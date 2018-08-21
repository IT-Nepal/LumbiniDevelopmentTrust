package com.example.ubuntu.lumbinidevelopmenttrust;

import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView kapilvastu, ramagrama, devadaha, lumbini, ldt;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FrameLayout frameLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    ViewPager viewPager;

//
//    int [] images = new int []{R.drawable.devadaha, R.drawable.lumbini, R.drawable.ramagrama,
//    R.drawable.kapilavastu};
    int [] images = new int[] {R.drawable.lumbiniimage,R.drawable.deva,
    R.drawable.kapil, R.drawable.raa, R.drawable.ldt };

//    int [] images = new int [] {
//            R.drawable.ic_info_black_24dp, R.drawable.ic_gif_black_24dp, R.drawable.ic_logo
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationview);
        frameLayout = findViewById(R.id.frame_layout);
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager);

        kapilvastu = findViewById(R.id.iv);
        ramagrama = findViewById(R.id.iv1);
        devadaha = findViewById(R.id.iv2);
        lumbini = findViewById(R.id.iv3);
        ldt = findViewById(R.id.iv4);

        kapilvastu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), Kaplivastu.class);
            intent.putExtra("name", "This page belongs to kaplivastu, which is underconstruction");
            startActivity(intent);
            }
        });

        ramagrama.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Kaplivastu.class);
                intent.putExtra("name", "This page belongs to ramagrama, which is underconstruction");
                startActivity(intent);

            }
        });
        ldt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Kaplivastu.class);
                intent.putExtra("name", "This page belongs to LDT, which is underconstruction");
                startActivity(intent);

            }
        });
        lumbini.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Kaplivastu.class);
                intent.putExtra("name", "This page belongs to Lumbini, which is underconstruction");
                startActivity(intent);

            }
        });
        devadaha.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), Kaplivastu.class);
                intent.putExtra("name", "This page belongs to Devadaha, which is underconstruction");
                startActivity(intent);

            }
        });

        viewPager.setAdapter(new HamroPagerAdapter(getSupportFragmentManager()));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

        setSupportActionBar(toolbar);


        toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.about:
                        Toast.makeText(MainActivity.this,"About Us page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.gallary:
                        Toast.makeText(MainActivity.this,"Gallery Page", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.send:
                        Toast.makeText(MainActivity.this,"Send", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        Toast.makeText(MainActivity.this,"Share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.facebook:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new FacebookFragment()).commit();
                        break;
                    case R.id.linkedin:
                        Toast.makeText(MainActivity.this,"Connection to linkedin", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.youtube:
                        Toast.makeText(MainActivity.this,"Connection to youtube", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.twitter:
                        Toast.makeText(MainActivity.this,"Connection to twitter", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return  true;
            }
        });
    }

    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    public class HamroPagerAdapter extends FragmentPagerAdapter{
        public HamroPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            FragmentActivity fragmentActivity = new FragmentActivity();
            Bundle bundle = new Bundle();
            bundle.putInt("id", images[position]);
            fragmentActivity.setArguments(bundle);
            return fragmentActivity;

        }
        public int getCount(){
            return images.length;
        }
    }

    public class MyTimerTask extends TimerTask {
        public void run(){
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }else if(viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(4);
                    }else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}
