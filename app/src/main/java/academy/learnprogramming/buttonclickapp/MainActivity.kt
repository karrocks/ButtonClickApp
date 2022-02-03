package academy.learnprogramming.buttonclickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TEXT_CONTENTS = "textContents"
class MainActivity : AppCompatActivity() {

    private var textview: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        textview = findViewById<TextView>(R.id.textView)

        textview?.text = ""
        textview?.movementMethod = ScrollingMovementMethod()
        userInput.setText("")

        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                textview?.append(userInput.text)
                textview?.append("\n")
                userInput.setText ("")
            }

        })


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textview?.text = savedInstanceState.getString(TEXT_CONTENTS, "")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_CONTENTS,textview?.text.toString())
    }
}