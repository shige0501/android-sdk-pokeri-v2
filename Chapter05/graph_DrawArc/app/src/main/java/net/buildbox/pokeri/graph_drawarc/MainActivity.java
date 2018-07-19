package net.buildbox.pokeri.graph_drawarc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.buildbox.pokeri.graph_drawarc.view.GraphView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphView(this));
    }
}
