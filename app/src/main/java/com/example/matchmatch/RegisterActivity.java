package com.example.matchmatch;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText EmailText, PasswordText, PasswordcheckText, mName;
    Button mregisterBtn;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        firebaseAuth =  FirebaseAuth.getInstance();
        EmailText = findViewById(R.id.remailEdt);
        PasswordText = findViewById(R.id.rpasswordEdt);
        PasswordcheckText = findViewById(R.id.rpasswordcheckEdt);
        mregisterBtn = findViewById(R.id.rregister2_btn);
        mName = findViewById(R.id.rnameEt);

        mregisterBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String email = EmailText.getText().toString().trim();
                String pwd = PasswordText.getText().toString().trim();
                String pwdcheck = PasswordcheckText.getText().toString().trim();


                if(pwd.equals(pwdcheck)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if (task.isSuccessful()) {

                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                String email = user.getEmail();
                                String uid = user.getUid();
                                String name = mName.getText().toString().trim();
                                String participate = "0";
                                String reliability = "100";

                                //파이어베이스에 데이터 저장
                                HashMap<Object,String> hashMap = new HashMap<>();
                                hashMap.put("uid",uid);
                                hashMap.put("email",email);
                                hashMap.put("name",name);
                                hashMap.put("participate",participate);
                                hashMap.put("reliability",reliability);

//                                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                                DatabaseReference reference = database.getReference("Users");
//                                reference.child(uid).setValue(hashMap);


                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(RegisterActivity.this.getApplicationContext(), "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(RegisterActivity.this.getApplicationContext(), "이미 존재하는 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                return;

                            }

                        }
                    });

                }else{
                    Toast mytoast = Toast.makeText(RegisterActivity.this.getApplicationContext(), "비밀번호가 틀렸습니다. 다시 입력해 주세요.", Toast.LENGTH_SHORT);
                    mytoast.show();
                }
            }
        });

    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}