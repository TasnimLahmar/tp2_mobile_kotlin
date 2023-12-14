package eniso.ia2.tp2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eniso.ia2.tp2.databinding.ActivityConversionBinding

class ConversionActivity : AppCompatActivity() {
    private lateinit var bind: ActivityConversionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_conversion)
        bind = ActivityConversionBinding.inflate(layoutInflater)
        setContentView(bind.root)
        var x="";
        val extra=intent.getStringExtra("number")
        val c1=extra.toString().toDouble()*3.3
        val c2=extra.toString().toDouble()/3.3
        val sens =intent.getStringExtra("sens")
        val c0=sens.toString().toInt()
        if(c0.toString()=="1"){
            bind.t.text = "L'equivalent de $extra dt en euro est: $c2"
            x=c2.toString()

        }
        if(c0.toString()=="2"){
            bind.t.text = "L'equivalent de $extra euro en dinar est: $c1"
            x=c1.toString()
        }
        bind.returnResultButton.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("convertedResult", x)
            setResult(RESULT_OK, resultIntent)
            finish()
        }

        bind.button2.setOnClickListener(){
            val resultIntent = Intent()
            resultIntent.putExtra("type_resultat", "toast")
            setResult(RESULT_OK, resultIntent)
            finish()
        }







    }
}