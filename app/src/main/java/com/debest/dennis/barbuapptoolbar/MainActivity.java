package com.debest.dennis.barbuapptoolbar;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Force app into fullscreen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //override font
        TypeFaceUtil.overrideFont(this, "MONOSPACE", "fonts/custom_font.ttf");
        setContentView(R.layout.activity_main);

        //Set the toolbar title for the main menu
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.action_bar_title_menu);
        }
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    //start a new game on click
    public void startGame(View view) {
        Intent gameIntent = new Intent(this, GameActivity.class);
        //Pass the name of this activity to the game activity
        gameIntent.putExtra("previousActivity", "MainActivity");
        startActivity(gameIntent);
    }

    //open the rules activity on click
    public void openRules(View view) {
        Intent ruleIntent = new Intent(this, RulesActivity.class);
        startActivity(ruleIntent);
    }

    public void quit(View view) {
        finish();
        System.exit(0);
    }
}
