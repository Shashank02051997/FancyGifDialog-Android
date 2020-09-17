package com.shashank.sony.fancygifdialoglibrary;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                new FancyGifDialog.Builder(this)
                        .setTitle("Granny eating chocolate dialog box")
                        .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy gify dialog.")
                        .setNegativeBtnText("Cancel")
                        .setPositiveBtnBackground(R.color.positiveButton)
                        .setPositiveBtnText("Ok")
                        .setNegativeBtnBackground(R.color.negativeButton)
                        .setGifResource(R.drawable.gif1)
                        .isCancellable(true)
                        .OnPositiveClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                                toaster("ok");
                            }
                        })
                        .OnNegativeClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                                toaster("cancel");
                            }
                        })
                        .build();
                break;
            case R.id.button2:
                new FancyGifDialog.Builder(this)
                        .setTitle(R.string.from_resources)
                        .setMessage(R.string.description_from_resources)
                        .setNegativeBtnText(android.R.string.cancel)
                        .setPositiveBtnBackground(R.color.positiveButton)
                        .setPositiveBtnText(android.R.string.ok)
                        .setNegativeBtnBackground(R.color.negativeButton)
                        .setGifResource(R.drawable.gif1)
                        .isCancellable(true)
                        .setOnCancelListener(new DialogInterface.OnCancelListener() {
                            @Override
                            public void onCancel(DialogInterface dialogInterface) {
                                toaster("Cancelled");
                            }
                        })
                        .OnPositiveClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                                toaster("Ok");
                            }
                        })
                        .OnNegativeClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                                toaster("Cancel");
                            }
                        })
                        .build();
                break;
        }


    }

    private void toaster(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
