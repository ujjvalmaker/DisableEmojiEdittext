package com.alastrine.edittextemoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

import com.alastrine.edittextemoji.exception.TypeFacedException;


public class EdtxtEmoji extends EditText {



    public static final String charset_1 = "";

    public static final String charset_2 = "qwertyuiopasdfghjklzxcvbnm 0123456789 QWERTYUIOPASDFGHJKLZXCVBNM";

    public static final String charset_3 = "0123456789";

    private AttributeSet attributeSet;
    private Context context;
    private Drawable imgCloseButton /*= getResources().getDrawable(android.R.drawable.btn_plus, null)*/;
    public EdtxtEmoji(Context context) {
        super(context);
        this.context = context;
    }

    public EdtxtEmoji(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attributeSet = attrs;
    }

    protected void setCustomImage(final Drawable customDrawable, final int width, final int height) {
        imgCloseButton = customDrawable;
        imgCloseButton.setBounds(0, 0, width, height);
    }

    // TODO for First Cahracter is Capital

    public void firstCharCapital(boolean t){
        if (t) {
            this.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String ss=s.toString();
                    if((!ss.equals(ss.toUpperCase()) && ss.length()==1)) {
                        ss=ss.toUpperCase();
                        setText(ss);
                        setSelection(ss.length());
                    }
                }
            });
        }

    }


    // TODO for Allow Character in Edittext

    public void setAllowChar(final int type){
        this.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence src, int start, int end, Spanned dest, int dstart, int dend) {
                if(src.equals("")){ // for backspace
                    return src;
                }
                if (type == 0){ // TODO Only Character Allow
                    if(src.toString().matches("[a-zA-Z]+")){
                        return src;
                    }
                }else if(type == 1){ // TODO character and Digit Allow
                    if(src.toString().matches("[a-zA-Z0-9]+")){
                        return src;
                    }
                }else if (type == 2){// TODO only Digit Allow
                    if(src.toString().matches("[0-9]+")){
                        return src;
                    }
                }

                return "";
            }
        }});

    }

    // TODO for Set Custom Font in Edittext

    public void setCustomFont(String fontName) {
        try {
            setCustomFont(this, context, attributeSet, fontName);
        } catch (TypeFacedException e) {
            e.printStackTrace();
        }
    }

    public void setCustomFont(EdtxtEmoji edtxtEmoji, Context context, AttributeSet attrs, String customFontName)throws TypeFacedException {
        if (attrs!=null){

        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.edtxtfont);
        String font;

        if (customFontName.equals("")) {
            font = a.getString(R.styleable.edtxtfont_font_style);
        } else {
            font = customFontName;
            try {
                Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + customFontName);
                edtxtEmoji.setTypeface(myTypeface);
            } catch (Exception e){
                throw new TypeFacedException("Font not found exceptiom");
            }
        }

        if (font == null) {
            return;
        }
        a.recycle();

    }

    // TODO For Set Backgroud shape

    public void shapeBackground(int shape){
        setBackgroundResource(shape);
    }


}
