package eniso.ia2.tp2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.roundToInt
import eniso.ia2.tp2.databinding.ActivityTemperatureBinding
class TemperatureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTemperatureBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var resultatFinal:String;
        var resultatConversion:Float= 0.0F;
        binding.radioButton2.setOnClickListener {
            val temperatureAConvertir = binding.edtxt.text.toString().toFloat()
            resultatConversion=convertirVersCelsius(temperatureAConvertir)
            val arrondiResultat = binding.checkBox.isChecked
            resultatFinal = if (arrondiResultat) {
                resultatConversion.roundToInt().toString()
            } else {
                resultatConversion.toString()
            }
            binding.textView6.text = "Resultat:\t"+resultatFinal
        }
        binding.radioButton1.setOnClickListener {
            val temperatureAConvertir = binding.edtxt.text.toString().toFloat()
            resultatConversion=convertirVersFahrenheit(temperatureAConvertir)
            val arrondiResultat = binding.checkBox.isChecked
            resultatFinal = if (arrondiResultat) {
                resultatConversion.roundToInt().toString()
            } else {
                resultatConversion.toString()
            }
            binding.textView6.text = "Resultat:\t"+resultatFinal
        }
        binding.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                binding.textView6.text = "Resultat:\t"+resultatConversion.roundToInt().toString()
            }
        }
    }
    fun convertirVersCelsius(fahrenheit: Float): Float {
        return (fahrenheit - 32) * 5 / 9
    }
    fun convertirVersFahrenheit(celsius: Float): Float {
        return celsius * 9 / 5 + 32
    }
}