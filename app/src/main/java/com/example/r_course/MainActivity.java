package com.example.r_course;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText fn;
    private EditText ln;
    private EditText year;
    private RadioGroup groupradio;
    private RadioButton selectedradiobutton;
    private Button mix;
    private Button add;
    private Button clear;
    private TextView contentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fn=(EditText)findViewById(R.id.fname);
        ln=(EditText)findViewById(R.id.lname);
        year=(EditText)findViewById(R.id.yob);
        groupradio=(RadioGroup)findViewById(R.id.groupradio);
        mix=(Button)findViewById(R.id.mix);
        add=(Button)findViewById(R.id.add);
        clear=(Button)findViewById(R.id.clear);

        contentlist=(TextView)findViewById(R.id.listcontent);
        mix.setOnClickListener(this);
        add.setOnClickListener(this);
        clear.setOnClickListener(this);
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
                int sex=groupradio.getCheckedRadioButtonId();
                if(!(tf.isEmpty() || tl.isEmpty() || ty.isEmpty() || sex<0)){
                    selectedradiobutton=(RadioButton)findViewById(groupradio.getCheckedRadioButtonId());
                    String sexp=selectedradiobutton.getText().toString();
                    DAO.addperson(tf,tl,ty,sexp);
                    int sizetab=DAO.tabperson.size();
                    String tampcomp = "";
                    if(sizetab>1){
                        for (int i=0;i<=sizetab;i++){
                            tampcomp=DAO.tabperson.get(sizetab-1).agecompare(DAO.tabperson.get(sizetab-2));
                        }
                    }
                    contentlist.setText(DAO.tabperson.toString().concat("\n"+tampcomp));
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
                break;
        }
    }
}