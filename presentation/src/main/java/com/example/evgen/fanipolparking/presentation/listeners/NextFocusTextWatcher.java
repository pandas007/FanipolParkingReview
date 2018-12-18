package com.example.evgen.fanipolparking.presentation.listeners;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

//Use is BindingAdapters for requesting focus.
public class NextFocusTextWatcher implements TextWatcher{

    private EditText editText;
    private int maxLength;

    public NextFocusTextWatcher(EditText editText) {
        this.editText = editText;
        this.maxLength = editText.getHint().length();
        editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (s.length() >= maxLength){
            View nextView = editText.focusSearch(View.FOCUS_RIGHT);
            if (nextView != null){
                nextView.requestFocus();
            }
        }
    }
}
