package com.alastrine.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alastrine.edittextemoji.EdtxtEmoji;

public class MainActivity extends AppCompatActivity {

    EdtxtEmoji edtxtEmoji,edtxtEmojiTxtDigit,edtxtEmojiDigit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComp();
    }

    private void initComp() {

        edtxtEmoji = findViewById(R.id.edtxt_custom);
        edtxtEmojiTxtDigit = findViewById(R.id.edtxt_custom1);
        edtxtEmojiDigit = findViewById(R.id.edtxt_custom2);

        // TODO set First Character is Capital
        edtxtEmoji.firstCharCapital(true);

        // TODO Set Shape Background
        edtxtEmoji.shapeBackground(R.drawable.edittext_shape);

        // TODO Set Allow Cahracter in Edittext , Disable emoji and other character
        edtxtEmoji.setAllowChar(0);


        // TODO set First Character is Capital
        edtxtEmojiTxtDigit.firstCharCapital(true);

        // TODO Set Shape Background
        edtxtEmojiTxtDigit.shapeBackground(R.drawable.edittext_shape);

        // TODO Set Allow Cahracter in Edittext , Disable emoji and other character
        edtxtEmojiTxtDigit.setAllowChar(1);



        // TODO Set Shape Background
        edtxtEmojiDigit.shapeBackground(R.drawable.edittext_shape);

        // TODO Set Allow Cahracter in Edittext , Disable emoji and other character
        edtxtEmojiDigit.setAllowChar(2);

    }
}
