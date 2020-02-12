package com.iamjosephvarghese.bharatham2020;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.iamjosephvarghese.bharatham2020.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout video, liveScore, gallery, updates, website_home, events;
    LinearLayout selfie, selfie_gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        video = findViewById(R.id.drawable_videos);
        liveScore = findViewById(R.id.drawable_live_scores);
        gallery = findViewById(R.id.drawable_gallery);
        updates = findViewById(R.id.drawable_updates);
//        selfie = findViewById(R.id.drawable_website1);
//        selfie_gallery = findViewById(R.id.drawable__selfie_gallery);
        website_home = findViewById(R.id.drawable_website);
        events = findViewById(R.id.drawable_events);

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Schedule.class);
                startActivity(intent);
            }
        });

        website_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://bharatham2020.in")));
            }
        });

//        selfie_gallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SelfieGallery.class);
//                startActivity(intent);
//            }
//        });
//
//        selfie.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Home.class);
//                startActivity(intent);
//            }
//        });


        updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Updates.class);
                startActivity(intent);
            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Gallery.class);
                startActivity(intent);
            }
        });

        liveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Chart.class);
                startActivity(intent);
            }
        });


        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Youtube.class);
                startActivity(intent);
            }
        });

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rate) {
            final String appPackageName = getPackageName();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }


        } else if (id == R.id.nav_bug) {

            final String appPackageName = getPackageName();
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }

        } else if (id == R.id.nav_share) {

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Download the bharatham app. https://play.google.com/store/apps/details?id=com.roundmelon.iamjosephvarghese.bharatham_2k18&hl=en_IN");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }
//        else if (id == R.id.fb) {
//
//            try {
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/169929660582298"));
//                startActivity(intent);
//            } catch (Exception e) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/bharatham2k18/")));
//            }

//        }
        else if (id == R.id.insta) {

            Uri uri = Uri.parse("http://instagram.com/_u/bharatham2k18");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/bharatham2020?hl=en")));
            }

        } else if (id == R.id.website) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://bharatham2020.in")));
        }
//        else if (id == R.id.youtube) {
//            String url = "https://www.youtube.com/channel/UCvKw6jTBXaNfxsF3iHA1LMw";
//            try {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setPackage("com.google.android.youtube");
//                intent.setData(Uri.parse(url));
//                startActivity(intent);
//            } catch (ActivityNotFoundException e) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(url));
//                startActivity(intent);
//            }
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void UnderWork(View v) {
        Toast.makeText(this, "Coming Soon!", Toast.LENGTH_LONG).show();
    }
}
