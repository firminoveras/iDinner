package edu.fppi.idinner.steps.userinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

import edu.fppi.idinner.R;

public class FragUserInfo extends Fragment {
    private Context mContext;
    private EditText mName;
    private CalendarView mCalendar;
    private EditText mBirthDate;
    private EditText mGenre;
    private EditText mEmail;
    private EditText mPhone;
    private Button mButtonNext;
    private OnButtonNextClick onButtonNextClick = () -> {
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_frag_user, container, false);

        mName = root.findViewById(R.id.Frag_User_Name);
        mCalendar = root.findViewById(R.id.Frag_User_Calendar);
        mBirthDate = root.findViewById(R.id.Frag_User_Birth);
        mGenre = root.findViewById(R.id.Frag_User_Genre);
        mEmail = root.findViewById(R.id.Frag_User_Email);
        mPhone = root.findViewById(R.id.Frag_User_Phone);
        mButtonNext = root.findViewById(R.id.Frag_User_NextButton);

        mCalendar.setVisibility(View.GONE);
        mBirthDate.setFocusable(false);
        mBirthDate.setOnClickListener(view -> mCalendar.setVisibility(View.VISIBLE));
        mCalendar.setOnDateChangeListener((calendarView, i, i1, i2) -> {
            mBirthDate.setText(String.format(Locale.ENGLISH, "%02d/%02d/%04d", i2, i1, i));
            calendarView.setVisibility(View.GONE);
        });

        mButtonNext.setOnClickListener(view -> {
            boolean hasError = false;
            if (mName.getText().length() == 0) {
                mName.setError("Este campo não pode ficar vazio.");
                hasError = true;
            }
            if (mBirthDate.getText().length() == 0) {
                mBirthDate.setError("Este campo não pode ficar vazio.");
                hasError = true;
            }
            if (mEmail.getText().length() == 0) {
                mEmail.setError("Este campo não pode ficar vazio.");
                hasError = true;
            }
            if (mPhone.getText().length() == 0) {
                mPhone.setError("Este campo não pode ficar vazio.");
                hasError = true;
            }
            if (!checkDateFormat(String.valueOf(mBirthDate.getText()))) {
                mBirthDate.setError("Data inválida.");
                hasError = true;
            }
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mEmail.getText().toString()).matches()) {
                mEmail.setError("Email inválido.");
                hasError = true;
            }
            if (!hasError) {
                saveUser();
                onButtonNextClick.onButtonNextClick();
            }
        });

        mGenre.setFocusable(false);
        mGenre.setOnClickListener(view -> {
            if (mGenre.getText().toString().equals("")) mGenre.setText(R.string.masculino);
            else if (mGenre.getText().toString().equals("Masculino"))
                mGenre.setText(R.string.feminino);
            else if (mGenre.getText().toString().equals("Feminino")) mGenre.setText(R.string.outro);
            else if (mGenre.getText().toString().equals("Outro"))
                mGenre.setText(R.string.masculino);
        });

        loadUser();

        return root;
    }

    private void saveUser() {
        SharedPreferences saved_values = requireContext().getSharedPreferences("edu.fppi.idinner", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saved_values.edit();
        editor.putString("userName", mName.getText().toString());
        editor.putString("userBirth", mBirthDate.getText().toString());
        editor.putString("userGenre", mGenre.getText().toString());
        editor.putString("userEmail", mEmail.getText().toString());
        editor.putString("userPhone", mPhone.getText().toString());
        editor.apply();
    }

    private void loadUser() {
        SharedPreferences saved_values = requireContext().getSharedPreferences("edu.fppi.idinner", Context.MODE_PRIVATE);
        mName.setText(saved_values.getString("userName", ""));
        mBirthDate.setText(saved_values.getString("userBirth", ""));
        mGenre.setText(saved_values.getString("userGenre", ""));
        mEmail.setText(saved_values.getString("userEmail", ""));
        mPhone.setText(saved_values.getString("userPhone", ""));
    }

    public void setOnButtonNextClick(OnButtonNextClick onButtonNextClick) {
        this.onButtonNextClick = onButtonNextClick;
    }

    public Boolean checkDateFormat(String date) {
        if (date == null || !date.matches("^(1[0-9]|0[1-9]|3[0-1]|2[1-9])/(0[1-9]|1[0-2])/[0-9]{4}$"))
            return false;
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            format.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public interface OnButtonNextClick {
        void onButtonNextClick();
    }
}
