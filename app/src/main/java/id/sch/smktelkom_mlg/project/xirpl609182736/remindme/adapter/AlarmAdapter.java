package id.sch.smktelkom_mlg.project.xirpl609182736.remindme.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl609182736.remindme.R;
import id.sch.smktelkom_mlg.project.xirpl609182736.remindme.model.Alarm;

/**
 * Created by Asus on 11/20/2016.
 */
public class AlarmAdapter extends RecyclerView.Adapter<AlarmAdapter.ViewHolder> {
    ArrayList<Alarm> alarmList;
    IAlarmAdapter mIAlarmAdapter;

    public AlarmAdapter(Context context, ArrayList<Alarm> alarmList) {
        this.alarmList = alarmList;
        mIAlarmAdapter = (IAlarmAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Alarm alarm = alarmList.get(position);
        holder.tvJudul.setText(alarm.judul);
        holder.tvDesk.setText(alarm.desk);
        holder.tpWaktu.setMinute(Integer.parseInt(alarm.waktu));
        holder.dpHari.setCalendarViewShown(Boolean.parseBoolean(alarm.hari));
    }

    @Override
    public int getItemCount() {
        if (alarmList != null)
            return alarmList.size();
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public interface IAlarmAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        EditText tvJudul;
        EditText tvDesk;
        TimePicker tpWaktu;
        DatePicker dpHari;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJudul = (EditText) itemView.findViewById(R.id.editTextJudul);
            tvDesk = (EditText) itemView.findViewById(R.id.editTextDes);
            tpWaktu = (TimePicker) itemView.findViewById(R.id.timePicker1);
            dpHari = (DatePicker) itemView.findViewById(R.id.datePicker1);
        }
    }
}
