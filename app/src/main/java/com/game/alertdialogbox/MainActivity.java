package com.game.alertdialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AlertDialog With 1 Button
//        This Has A method setButton maybe outdated,it is throwing error in my code

//        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle("Terms & Conditions");
//        alertDialog.setIcon(R.drawable.baseline_info_24);
//        alertDialog.setMessage("Read all the terms & conditions");
//        alertDialog.setButton("Yes, I have read ", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//        alertDialog.show();


//        AlertDialog With 2 button

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete")
                .setIcon(R.drawable.baseline_delete_24)
                .setMessage("Are you sure want to delete?")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                    }
                })
//                .setPositiveButtonIcon(getDrawable(R.drawable.baseline_check_24))
//                .setNegativeButtonIcon(getDrawable(R.drawable.baseline_close_24));
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.show();
    }

//  AlertDialog with 3 Button, Here with example to handle back button from the Main Activity.
    public void onBackPressed() {
        AlertDialog.Builder exitBuilder = new AlertDialog.Builder(this);
        exitBuilder.setTitle("Exit")
                .setIcon(R.drawable.baseline_check_24)
                .setMessage("Are you sure want to exit")
                .setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Welcome Again", Toast.LENGTH_SHORT).show();

                    }
                })
                .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
                        MainActivity.super.onBackPressed();
//                        Since we Are inside the DialogInterface.onClickListener class so need to call with MainActivity.
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                    }
                });
        exitBuilder.show();
    }
}

