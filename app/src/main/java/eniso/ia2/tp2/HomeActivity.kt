package eniso.ia2.tp2
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eniso.ia2.tp2.databinding.ActivityHomeBinding
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button5.setOnClickListener(){
            val intent1= Intent(this,CurrencyActivity::class.java)
            startActivity(intent1)
        }

        binding.button6.setOnClickListener(){
            val intent2= Intent(this,TemperatureActivity::class.java)
            startActivity(intent2)
        }
    }
}