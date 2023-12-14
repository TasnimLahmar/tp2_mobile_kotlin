package eniso.ia2.tp2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import eniso.ia2.tp2.ConversionActivity
import eniso.ia2.tp2.R
import eniso.ia2.tp2.databinding.ActivityCurrencyBinding

class CurrencyActivity : AppCompatActivity() {
    val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data
            val typeResultat = data?.getStringExtra("type_resultat")

            if(data !=null){
                if (typeResultat == "toast") {
                    Toast.makeText(this, "Abscence de resultat", Toast.LENGTH_SHORT).show()
                } else {
                    val convertedResult = data?.getStringExtra("convertedResult")
                    binding.resultat.setText(convertedResult)
                }
            }

        }
    }
    private lateinit var binding: ActivityCurrencyBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        binding = ActivityCurrencyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.DTtoE.setOnClickListener {
            val i= Intent(this, ConversionActivity::class.java);
            binding.DTtoE.setBackgroundColor(Color.DKGRAY)
            binding.EtoDT.setBackgroundColor(Color.GRAY)
            if(binding.montant.text.toString()==""){
                val toast = Toast.makeText(applicationContext, "Please enter a value !", Toast.LENGTH_LONG)
                toast.show()
            }else{
                //val x=binding.montant.text.toString().toDouble() / 3.3;
                //  binding.resultat.setText(x.toString())
                i.putExtra("number",binding.montant.text.toString())
                i.putExtra("sens","1")
                getContent.launch(i)
                //  startActivity(i)

            }

        }
        binding.EtoDT.setOnClickListener {
            val i= Intent(this,ConversionActivity::class.java);
            binding.EtoDT.setBackgroundColor(Color.DKGRAY)
            binding.DTtoE.setBackgroundColor(Color.GRAY)
            if(binding.montant.text.toString()==""){
                val toast = Toast.makeText(applicationContext, "Please enter a value !", Toast.LENGTH_LONG)
                toast.show()
            }else{
                // val x=binding.montant.text.toString().toDouble() *3.3;
                i.putExtra("number",binding.montant.text.toString())
                i.putExtra("sens","2")
                getContent.launch(i)
                // startActivity(i)
                //  binding.resultat.setText(x.toString())
            }

        }



    }





}