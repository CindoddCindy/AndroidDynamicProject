package sirihpinang.employee.pickmeup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sirihpinang.employee.pickmeup.pojo.EmployeeRegisterRespon;
import sirihpinang.employee.pickmeup.retrofit.EmployeeInterface;
import sirihpinang.employee.pickmeup.retrofit.EmployeeUrl;

public class RegisterEmployee extends AppCompatActivity {

    private EditText et_name, et_email, et_pass, et_emp_id, et_emp_comname;

    private Button btn_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_employee);

        et_name=findViewById(R.id.emp_nama);
        et_email=findViewById(R.id.emp_email);
        et_pass=findViewById(R.id.emp_password);
        et_emp_id=findViewById(R.id.emp_id);
        et_emp_comname=findViewById(R.id.emp_comname);

        btn_reg=findViewById(R.id.emp_regis);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // validate();
                RegisterEmployee();


            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String password = et_pass.getText().toString();
        String employeeid = et_emp_id.getText().toString();
        String employeecompname = et_emp_comname.getText().toString();


        if (name.isEmpty() || name.length() < 3) {
            et_name.setError("at least 3 characters");
            valid = false;
        } else {
            et_name.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("enter a valid email address");
            valid = false;
        } else {
            et_email.setError(null);
        }


        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            et_pass.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            et_pass.setError(null);
        }

        if (employeeid.isEmpty() || name.length() < 3) {
            et_emp_id.setError("at least 3 characters");
            valid = false;
        } else {
            et_emp_id.setError(null);
        }

        if (employeecompname.isEmpty() || name.length() < 3) {
            et_emp_comname.setError("at least 3 characters");
            valid = false;
        } else {
            et_emp_comname.setError(null);
        }



        return valid;
    }


    public void RegisterEmployee(){

        String name = et_name.getText().toString();
        String email = et_email.getText().toString();
        String password = et_pass.getText().toString();
        String employeeid = et_emp_id.getText().toString();
        String employeecomname = et_emp_comname.getText().toString();



        EmployeeInterface employeeInterface  = EmployeeUrl.getClient().create(EmployeeInterface.class);
        //User user = new User(name, email, password);


        Call<EmployeeRegisterRespon> userCall = employeeInterface.EmployeeRegister(name,email,password, employeeid,employeecomname);//.userSignUp(name, email, password);

        userCall.enqueue(new Callback<EmployeeRegisterRespon>() {
            @Override
            public void onResponse(Call<EmployeeRegisterRespon> call, Response<EmployeeRegisterRespon> response) {
                //hidepDialog();
                //onSignupSuccess();
                Log.d("onResponse", "" + response.body().getStatus());//.getMessage());


                if(response.body().getStatus()=="ok") {
                    Intent intent = new Intent(RegisterEmployee.this,UserProfile.class);
                    startActivity(intent);

                    finish();
                }else {
                    //Toast.makeText(SignupActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<EmployeeRegisterRespon> call, Throwable t) {
                //hidepDialog();
                Log.d("onFailure", t.toString());
            }
        });

    }
}
