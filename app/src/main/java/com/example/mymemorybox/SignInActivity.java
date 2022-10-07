package com.example.mymemorybox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;

public class SignInActivity extends AppCompatActivity {

    Button logInB, signUpB;
    EditText userNameET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        logInB = findViewById(R.id.logInButton);
        signUpB = findViewById(R.id.signUpButton);
        userNameET = findViewById(R.id.userNameEditText);
        passwordET = findViewById(R.id.passwordEditText);
    }

    public void logInClicked(View view) {
        Log.i("Denna", "Log in clicked");
        if (getValues()) {        // get username and password
            // check if valid with Firebase auth
            // if valid, log in user and then switch to next activity

            Intent intent = new Intent(SignInActivity.this, SelectActionActivity.class);
            startActivity(intent);

            // if invalid - prompt message that says why signin won't go through
        }
    }

    public void signUpClicked(View view) {
        Log.i("Denna", "Sign up clicked");
        if (getValues()) {      // get username and password
            // Try to create an account using auth
            // if successful, switch to next activity

        }
        if (task.isSuccessful()){
…
        }

        else {
   /*
   This prevents the app from CRASHING when the user enters bad items
   (duplicate email or badly formatted email most likely)

   https://stackoverflow.com/questions/37859582/how-to-catch-a-firebase-auth-specific-exceptions

    */

            try {
                throw task.getException();
            } catch (FirebaseAuthInvalidCredentialsException e) {
                // poorly formatted email address
                Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Aidan", "Sign up failed for " + userName + " " + password + e.getMessage());
            } catch (FirebaseAuthEmailException e) {
                // duplicate email used
                Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Aidan", "Sign up failed for " + userName + " " + password + e.getMessage());
            } catch (Exception e) {
                Toast.makeText(SignInActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Aidan", "Sign up failed for " + userName + " " + password + e.getMessage());
            }


            // this log message will tell the name of the exception.  If you want to add this to the catch
            // statement above, then just add another catch above the generic one at the end

            Log.d(TAG, "Sign up failed for " + userName + " " + password +
                    " because of \n"+ task.getException());
        }


    }

    /**
     * Helper method to get userName and password whenever one of these buttons is clicked
     * The method makes sure both EditText boxes are filled in and also ensures the password
     * is at least 6 characters long.  If those tests pass, then it will send the values on
     * to be checked by Firebase auth
     *
     * @return true if values pass these tests, false otherwise
     */
    private boolean getValues() {
        String userName = userNameET.getText().toString();
        String password = passwordET.getText().toString();

        // verify all user data is entered
        if (userName.length() == 0 || password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        // verify password is at least 6 char long (otherwise firebase will deny)
        else if (password.length() < 6) {
            Toast.makeText(getApplicationContext(), "Password must be at least 6 char long", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Log.i("Aidan", userName + " " + password + " is set after getValues(), return true");
            return true;
        }
    }
    /**
     * This method accepts the email the user wants to submit for FirebaseAuth
     * and removes an extra spaces that may have accidentally been added at the end by
     * the auto-correct keyboard.  This typically happens when the email is used all
     * the time and shows up as a suggestion for the user.
     *
     * @param email
     * @return a String without trailing spaces
     */
    private String removeTrailingSpaces(String email) {
        String lastChar = email.substring(email.length() -1);
        if (lastChar.equals(" "))
            email = email.substring(0, email.length()-1);
        return email;
    }


}


