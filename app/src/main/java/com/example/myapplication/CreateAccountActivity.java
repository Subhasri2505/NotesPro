package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.intellij.lang.annotations.Pattern;

public class CreateAccountActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText,confirmEditText;
    Button createAccountbtn;
    ProgressBar progressBar;
    TextView loginbtnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        emailEditText=findViewById(R.id.email_edit_text);
        passwordEditText=findViewById(R.id.password_edit_text);
        confirmEditText=findViewById(R.id.confirm_password_edit_text);
        createAccountbtn=findViewById(R.id.create_account_btn);
        progressBar=findViewById(R.id.progress_bar);
        loginbtnTextView=findViewById(R.id.login_text_view_btn);
        createAccountbtn.setOnClickListener(v -> createAccount());
    }
    void createAccount() {
        String email=emailEditText.getText().toString();
        String password=passwordEditText.getText().toString();
        String confirmPassword=confirmEditText.getText().toString();
        boolean isValidated=validateData(email,password,confirmPassword);
        if(!isValidated){
            return;
        }
        createAccountInFirebase(email,password);
    }
    void createAccountInFirebase(String email,String password){
       // changeInProgress(true);

        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(CreateAccountActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //changeInProgress(false);
                       if(task.isSuccessful()){
                           Utility.showToast(CreateAccountActivity.this,"Create account is sucessfull ");;

                           firebaseAuth.getCurrentUser().sendEmailVerification();
                           //firebaseAuth.signOut();
                           //finish();
                       }
                       else{
                           Utility.showToast( CreateAccountActivity.this,task.getException().getLocalizedMessage());
                       }
                    }
                });
    }
//    void changeInProgress(boolean inProgress){
//        if(inProgress){
//            progressBar.setVisibility(View.VISIBLE);
//            createAccountbtn.setVisibility(View.GONE);
//        }
//        else{
//            progressBar.setVisibility(View.GONE);
//            createAccountbtn.setVisibility(View.VISIBLE);
//        }
//    }
    boolean validateData(String email, String password, String confirmPassword) {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Invalid email address");
            return false;
        }
        if (password.length() < 6) {
            passwordEditText.setError("Password must be at least 6 characters");
            return false;
        }
        if (!password.equals(confirmPassword)) {
            confirmEditText.setError("Passwords do not match");
            return false;
        }
        return true;
    }

}