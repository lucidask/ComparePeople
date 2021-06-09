package com.example.r_course;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private EditText fn;
    private EditText ln;
    private EditText year;
    private EditText size;
    private RadioGroup groupradio;
    private RadioButton selectedradiobutton;
    private Button mix;
    private Button add;
    private Button clear;
    private TextView contentlist;
    private Switch switchagesize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fn=(EditText)findViewById(R.id.fname);
        ln=(EditText)findViewById(R.id.lname);
        year=(EditText)findViewById(R.id.yob);
        size=(EditText)findViewById(R.id.size);
        groupradio=(RadioGroup)findViewById(R.id.groupradio);
        mix=(Button)findViewById(R.id.mix);
        add=(Button)findViewById(R.id.add);
        clear=(Button)findViewById(R.id.clear);
        switchagesize=(Switch)findViewById(R.id.switchAgeSize);

        contentlist=(TextView)findViewById(R.id.listcontent);
        mix.setOnClickListener(this);
        add.setOnClickListener(this);
        clear.setOnClickListener(this);
        switchagesize.setOnCheckedChangeListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mix:
                String tf=fn.getText().toString();
                String tl=ln.getText().toString();
                if(!(tf.isEmpty() || tl.isEmpty())){
                    Toast.makeText(MainActivity.this, "Mince alors: "+tf+" "+tl,
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Fill First and Last name",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.add:
                 tf=fn.getText().toString();
                 tl=ln.getText().toString();
                String ty=year.getText().toString();
                String ts=size.getText().toString();
                int sex=groupradio.getCheckedRadioButtonId();
                if(!(tf.isEmpty() || tl.isEmpty() || ty.isEmpty() || ts.isEmpty() || sex<0)){
                    selectedradiobutton=(RadioButton)findViewById(groupradio.getCheckedRadioButtonId());
                    String sexp=selectedradiobutton.getText().toString();
                    int tsconvert=Integer.parseInt(ts);
                    DAO.addperson(tf,tl,ty,tsconvert,sexp);
                    contentlist.setText(DAO.tabperson.toString());
                }
                else {
                    Toast.makeText(MainActivity.this, "Fill in all fields",
                        Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.clear:
                fn.getText().clear();
                ln.getText().clear();
                year.getText().clear();
                groupradio.clearCheck();
                size.getText().clear();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int sizetab=DAO.tabperson.size();
        String tampcomp = "";
        if (isChecked && sizetab>1) {
            for (int i=0;i<=sizetab;i++){
                tampcomp=DAO.tabperson.get(sizetab-1).sizecompare(DAO.tabperson.get(sizetab-2));
            }
        } else if(!(isChecked) && sizetab>1) {
            for (int i=0;i<=sizetab;i++){
                tampcomp=DAO.tabperson.get(sizetab-1).agecompare(DAO.tabperson.get(sizetab-2));
            }
        }
        else {
            Toast.makeText(MainActivity.this, "Add more people",
                    Toast.LENGTH_SHORT).show();
        }
        contentlist.setText(DAO.tabperson.toString().concat("\n"+tampcomp));
    }
}
