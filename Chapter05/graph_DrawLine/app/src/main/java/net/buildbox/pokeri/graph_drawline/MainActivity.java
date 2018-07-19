package net.buildbox.pokeri.graph_drawline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.buildbox.pokeri.graph_drawline.view.GraphView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GraphView(this));
    }
}
