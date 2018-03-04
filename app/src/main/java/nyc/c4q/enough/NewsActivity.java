package nyc.c4q.enough;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import nyc.c4q.enough.network.NYTAPI;
import nyc.c4q.enough.network.NYTimesServiceGenerator;
import nyc.c4q.enough.news.HealthNewsFragment;
import nyc.c4q.enough.news.MovieNewsFragment;
import nyc.c4q.enough.news.TopNewsFragment;
import nyc.c4q.enough.news.TravelNewsFragment;

public class NewsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int CAM_REQUEST=1313;

    private FrameLayout fragmentContainer;
    private Toolbar toolbar;
    private int clickCount = 0;

    public static final NYTAPI apiCallback = NYTimesServiceGenerator.createService();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        fragmentContainer = findViewById(R.id.fragment_container);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    clickCount++;
                }
                else if(clickCount >= 3){
                    Toast.makeText(getApplicationContext(), "Triple!", Toast.LENGTH_SHORT).show();
                    clickCount = 0;
                }

                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAM_REQUEST);

                Snackbar.make(view, "Recording", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction;

        switch (id){
            case R.id.nav_topnews:
                TopNewsFragment topNewsFragment = new TopNewsFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragment_container, topNewsFragment)
                        .commit();
                break;
            case R.id.nav_health:
                HealthNewsFragment healthNewsFragment = new HealthNewsFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragment_container, healthNewsFragment)
                        .commit();
                break;
            case R.id.nav_movie:
                MovieNewsFragment movieNewsFragment = new MovieNewsFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragment_container, movieNewsFragment)
                        .commit();
                break;
            case R.id.nav_travel:
                TravelNewsFragment travelNewsFragment = new TravelNewsFragment();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction
                        .replace(R.id.fragment_container, travelNewsFragment)
                        .commit();
                break;
            case R.id.nav_help:

                Intent helpIntent = new Intent(this, HelpActivity.class);
                startActivity(helpIntent);
                break;
            default:
                Toast.makeText(getApplicationContext(), "uh oh", Toast.LENGTH_LONG).show();
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
