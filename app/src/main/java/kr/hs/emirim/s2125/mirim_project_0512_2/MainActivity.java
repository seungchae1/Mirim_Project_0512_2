package kr.hs.emirim.s2125.mirim_project_0512_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    int[] btnNumId = {R.id.btn0, R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button[] btnNum = new Button[btnNumId.length];
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.text_result);
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMulti = findViewById(R.id.btn_multi);
        Button btnDivide = findViewById(R.id.btn_divide);

        for(int i=0; i<btnNum.length; i++){
            final int index = i;
            btnNum[i]=findViewById(btnNumId[i]);
            btnNum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s= "";
                    if(edit1.isFocused()){
                        s=edit1.getText().toString() + btnNum[index].getText();
                        edit1.setText(s);
                    }
                    else if(edit2.isFocused()){
                        s=edit2.getText().toString() + btnNum[index].getText();
                        edit2.setText(s);
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "EditText에 포커스가 없습니다.",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        btnPlus.setOnClickListener(btnlistener);
        btnMinus.setOnClickListener(btnlistener);
        btnMulti.setOnClickListener(btnlistener);
        btnDivide.setOnClickListener(btnlistener);

    }
    View.OnClickListener btnlistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int result = 0;
            int num1=Integer.parseInt(edit1.getText().toString());
            int num2=Integer.parseInt(edit2.getText().toString());

            switch(view.getId()){
                case R.id.btn_plus:
                    result=num1+num2;
                    break;
                case R.id.btn_minus:
                    result=num1-num2;
                    break;
                case R.id.btn_multi:
                    result=num1*num2;
                    break;
                case R.id.btn_divide:
                    result=num1/num2;
                    break;
            }
            textResult.setText("계산결과 : "+result);
        }
    };
}