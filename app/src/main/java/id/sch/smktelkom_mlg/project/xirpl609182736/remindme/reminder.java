package id.sch.smktelkom_mlg.project.xirpl609182736.remindme;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl609182736.remindme.adapter.AlarmAdapter;
import id.sch.smktelkom_mlg.project.xirpl609182736.remindme.model.Alarm;

public class reminder extends AppCompatActivity implements AlarmAdapter.IAlarmAdapter {

    public static final String ALARM = "alarm";
    private static final int REQUEST_CODE_ADD = 88;
    ArrayList<Alarm> mList = new ArrayList<>();
    AlarmAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AlarmAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goAdd();
            }
        });
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.places);
        String[] arDeskripsi = resources.getStringArray(R.array.place_desc);
        String[] arWaktu = resources.getStringArray(R.array.place_waktu);
        String[] arHari = resources.getStringArray(R.array.place_hari);

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Alarm(arJudul[i], arDeskripsi[i], arWaktu[i], arHari[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    private void goAdd() {
        startActivityForResult(new Intent(this, InputActivity.class), REQUEST_CODE_ADD);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {

        }

    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(ALARM, mList.get(pos));
        startActivity(intent);
    }
}
