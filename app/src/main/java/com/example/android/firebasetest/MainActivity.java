package com.example.android.firebasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference personRef = database.getReference("person");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void set(View view){
        Person temp;
        EditText name_text = (EditText) findViewById(R.id.name_input);
        String name = name_text.toString();
        EditText age_text = (EditText) findViewById(R.id.age_input);
        String age_string = age_text.toString();
        int age = Integer.parseInt(age_string);
        CheckBox grad_input = (CheckBox) findViewById(R.id.grad_input);
        boolean grad;
        if(grad_input.isChecked()){
            grad = true;
        }
        else{
            grad = false;
        }
        temp = new Person(name, age, grad);
        personRef.setValue(temp);
    }
}
