package com.example.ricardodelgado.bifrost;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private static final String TAG = "Tag";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Add Instance of Firebase
        mAuth = FirebaseAuth.getInstance();

        //Add Video Background
        mVideoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sun);
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        //Signing In
        final EditText emailET = findViewById(R.id.emailET);
        final EditText passwordET = findViewById(R.id.passwordET);

        Button loginButton = findViewById(R.id.button2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailET.getText().toString().trim();
                String password = passwordET.getText().toString().trim();
                signIn(email,password);

                Log.v("","");
            }
        });

        //Changing View from login and Register
        final ViewFlipper mViewFlipper = findViewById(R.id.viewFlipper);
        TextView registerLink = findViewById(R.id.textView);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideOut = AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_out_to_left);
                ConstraintLayout loginPanel = findViewById(R.id.group_login);
                loginPanel.startAnimation(slideOut);

                Animation slideIn = AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_in_from_right);
                ConstraintLayout registerPanel = findViewById(R.id.group_register);
                registerPanel.startAnimation(slideIn);

                mViewFlipper.setDisplayedChild(1);

            }
        });
        TextView loginLink = findViewById(R.id.link_iniciar_sesion);
        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation slideIn = AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_out_to_right);
                ConstraintLayout registerPanel = findViewById(R.id.group_register);
                registerPanel.startAnimation(slideIn);

                Animation slideOut = AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_in_from_left);
                ConstraintLayout loginPanel = findViewById(R.id.group_login);
                loginPanel.startAnimation(slideOut);

                mViewFlipper.setDisplayedChild(0);

            }
        });

        //Register
        //Signing In
        final EditText registerEmail = findViewById(R.id.register_email);
        final EditText registerPassword = findViewById(R.id.passwordET2);
        final EditText confirmPassword = findViewById(R.id.passwordET3);

        Button registerButton = findViewById(R.id.button_register);
        registerButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = registerEmail.getText().toString().trim();
                String password = registerPassword.getText().toString().trim();
                String confirm_password = confirmPassword.getText().toString().trim();

                if(password.equals(confirm_password)){
                    createUser(email,password);
                }

            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    
    public void createUser(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void signIn(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
    
    public void updateUI(FirebaseUser currentuser){

        if(currentuser!=null){
            Toast.makeText(LoginActivity.this, "Usuario Loggeado",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, enterprises.class);
            startActivity(intent);
        }

    }
    
}
