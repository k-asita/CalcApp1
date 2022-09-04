package jp.techacademy.asuki.kamada.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import android.view.View

import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }


    override fun onClick(v: View) {

        if(num1.text.isNullOrBlank() || num2.text.isNullOrBlank()) {

            Log.d("UI_PARTS", "未入力です")

            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("閉じる"){
                    Log.d("UI_PARTS", "何か数値を入力してください")
                }.show()
        } else {

            var num1 = num1.text.toString().toDouble()
            var num2 = num2.text.toString().toDouble()

            var result: Double = 0.0

            when(v.id){
                R.id.button    -> result = calcAdd(num1, num2)
                R.id.button2    -> result = calcSub(num1, num2)
                R.id.button3  -> result = calcMulti(num1, num2)
                R.id.button4   -> result = calcDivide(num1, num2)
            }

            Log.d("UI_PARTS", result.toString())

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)

        }
    }

    private fun calcAdd(num1: Double, num2: Double): Double {
        return num1 + num2
    }

    private fun calcSub(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    private fun calcMulti(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    private fun calcDivide(num1: Double, num2: Double): Double {
        return num1 / num2
    }






}