package com.example.hw4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSubmit;
    EditText editBird, editZip, editPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSubmit = findViewById(R.id.buttonSearch);

        editBird = findViewById(R.id.editBird);
        editPerson = findViewById(R.id.editPerson);
        editZip = findViewById(R.id.editZipSearch);

        buttonSubmit.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.mainmenuitem) {
           Toast.makeText(this, "You are on this page", Toast.LENGTH_SHORT).show();
        } else if(item.getItemId() == R.id.searchmenuitem) {
            Intent searchIntent = new Intent(this, SearchActivity.class);
            startActivity(searchIntent);
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onClick(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");

        if (view == buttonSubmit) {

            String createBird = editBird.getText().toString();
            String createZip = editZip.getText().toString();
            String createPerson = editPerson.getText().toString();

            Sighting createSighting = new Sighting(createBird, createZip, createPerson);

            myRef.push().setValue(createSighting);
            }

        else {

        }




    }
}
