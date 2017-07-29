
package com.example.tanapon.mebooks;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class OneFragment extends Fragment {
    ArrayList mMultiSelected;
    View myView;
    String[] listItems;


    public static OneFragment newInstance() {
        OneFragment fragment = new OneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_one, container, false);
        EditText add = (EditText) myView.findViewById(R.id.add);
        final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        Button button = (Button) myView.findViewById(R.id.button_open_dialog);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMultiSelected = new ArrayList<Integer>();

                listItems = getResources().getStringArray(R.array.shopping_item);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select MeBooks");
                builder.setMultiChoiceItems(listItems, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            mMultiSelected.add(which);
                        } else if (mMultiSelected.contains(which)) {
                            mMultiSelected.remove(Integer.valueOf(which));
                        }
                    }
                });

                builder.setPositiveButton("ขายแล้ว", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // เซฟค่าลง database หรือ SharedPreferences.
                        StringBuffer buffer = new StringBuffer();
                        for (Object team : mMultiSelected) {
                            buffer.append(" ");
                            buffer.append(listItems[(int) team]);
                            mRootRef.child("status").push().setValue(listItems[(int) team]);
                        }
                        Toast.makeText(getActivity(), "หนังสือที่ขายแล้ว คือ " + buffer.toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("ยกเลิก", null);
                builder.create();

                builder.show();
            }
        });

        return myView;
    }
}
