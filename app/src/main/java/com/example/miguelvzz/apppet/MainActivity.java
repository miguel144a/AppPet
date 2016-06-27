package com.example.miguelvzz.apppet;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.miguelvzz.apppet.activities.AcercaActivity;
import com.example.miguelvzz.apppet.activities.ContactoActivity;
import com.example.miguelvzz.apppet.adaptadores.Mascota_adaptador;
import com.example.miguelvzz.apppet.adaptadores.PageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ImageView iv_estrella;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Toolbar action_bar = (Toolbar) findViewById(R.id.barra_herramintas);
        setSupportActionBar(action_bar);*/

        toolbar = (Toolbar) findViewById(R.id.tb_toolbar);

        iv_estrella = (ImageView) findViewById(R.id.iv_estrella);
        iv_estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lista_Favoritos.class);
                startActivity(intent);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tl_tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp_viewPager);

        setUpViewPager();

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_popup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mn_acerca:
                Intent intent = new Intent(MainActivity.this, AcercaActivity.class);
                startActivity(intent);
                break;
            case R.id.mn_contacto:
                Intent intent1 = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intent1);
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void setUpViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.home);
        tabLayout.getTabAt(1).setIcon(R.drawable.dog);

    }

    private ArrayList<Fragment> agregarFragments() {

        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new FragmentLista());
        fragments.add(new FragmentDetalle());

        return fragments;
    }
}
