package com.example.retouro_v1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.widget.NumberPicker;
import android.view.LayoutInflater;
import android.view.View;

public class TimeDialog extends AppCompatDialogFragment {
    NumberPicker timePicker = null;
    TimeDialogListener listener;
    String [] timeSlot = {"7:00 - 8:00",
            "8:00 - 9:00",
            "9:00 - 10:00",
            "10:00 - 11:00",
            "11:00 - 12:00",
            "12:00 - 13:00",
            "13:00 - 14:00",
            "14:00 - 15:00",
            "15:00 - 16:00",
            "16:00 - 17:00",
            "17:00 - 18:00",
            "18:00 - 19:00",
            "19:00 - 20:00",
            "20:00 - 21:00"};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_time, null);

        timePicker = (NumberPicker) view.findViewById(R.id.timePicker);
        timePicker.setMinValue(0);
        timePicker.setMaxValue(13);
        timePicker.setDisplayedValues(timeSlot);

        builder.setView(view)
                .setTitle("Bitte wählen Sie einen Zeitslot:")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String startTimeSelected = timeSlot[timePicker.getValue()];
                        listener.applyTime(startTimeSelected);
                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (TimeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement TimeDialogListener");
        }
    }

    public interface TimeDialogListener {
        void applyTime (String selectedStartTime);
    }

}
