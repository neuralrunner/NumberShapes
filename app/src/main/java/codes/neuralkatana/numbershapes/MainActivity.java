package codes.neuralkatana.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.prathameshmore.toastylibrary.Toasty;

import codes.neuralkatana.numbershapes.logic.NumberShapes;

public class MainActivity extends AppCompatActivity {
    private EditText edtNumber;
    private NumberShapes numberShapes;

    public void numberResults(View view) {
        edtNumber = findViewById(R.id.editText);
        int number = (int) Integer.valueOf(edtNumber.getText().toString());
        numberShapes = new NumberShapes(number);

        //Custom Android Library
        //Check build.gradle(Project) and (Module)
        Toasty toasty = new Toasty(MainActivity.this);
        if (numberShapes.isSquare()) {
            toasty.successToasty(MainActivity.this, "Square Number!",
                    Toast.LENGTH_SHORT, Toasty.BOTTOM | Toasty.CENTER);
        } else {
            toasty.dangerToasty(MainActivity.this, "Not Square Number!",
                    Toasty.LENGTH_SHORT, Toasty.BOTTOM | Toasty.CENTER);
        }

        if (numberShapes.isTriangular()) {
            toasty.successToasty(MainActivity.this, "Triangular Number!",
                    Toasty.LENGTH_SHORT, Toasty.TOP | Toasty.CENTER);
        } else {
            toasty.dangerToasty(MainActivity.this, "Not Triangular Number!",
                    Toasty.LENGTH_SHORT, Toasty.TOP | Toasty.CENTER);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}
