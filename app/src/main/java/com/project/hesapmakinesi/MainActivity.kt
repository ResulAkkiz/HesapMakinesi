package com.project.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.project.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var textViewText: String
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        textViewText = "0"
        binding.resultTextView.text = textViewText

        binding.button1.setOnClickListener {
            binding.resultTextView.text = addCharacter("1");
        }
        binding.button2.setOnClickListener {
            binding.resultTextView.text = addCharacter("2");
        }
        binding.button3.setOnClickListener {
            binding.resultTextView.text = addCharacter("3");
        }
        binding.button4.setOnClickListener {
            binding.resultTextView.text = addCharacter("4");
        }
        binding.button5.setOnClickListener {
            binding.resultTextView.text = addCharacter("5");
        }
        binding.button6.setOnClickListener {
            binding.resultTextView.text = addCharacter("6");
        }
        binding.button7.setOnClickListener {
            binding.resultTextView.text = addCharacter("7");
        }
        binding.button8.setOnClickListener {
            binding.resultTextView.text = addCharacter("8");
        }
        binding.button9.setOnClickListener {
            binding.resultTextView.text = addCharacter("9");
        }
        binding.button0.setOnClickListener {
            if (textViewText.last() != '+') {
                binding.resultTextView.text = addCharacter("0");
            }
        }
        binding.buttonBack.setOnClickListener {
            if (textViewText.length>1){
                textViewText=textViewText.substring(0, textViewText.length - 1)
            }else{
                textViewText="0"
            }
            binding.resultTextView.text=textViewText;
        }

        binding.buttonAC.setOnClickListener {
            textViewText = "0"
            binding.resultTextView.text = "0"
        }
        binding.buttonPlus.setOnClickListener {
            if (textViewText == "0") {
                return@setOnClickListener
            } else {
                if (textViewText.last() != '+') {
                    textViewText += "+"
                    binding.resultTextView.text = textViewText
                }

            }
        }

        binding.buttonEqual.setOnClickListener {
            calculateResult()
        }

    }

    private fun addCharacter(addedChar: String): String {
        if (textViewText.length == 1 && textViewText == "0") {
            textViewText = addedChar
        } else {
            textViewText += addedChar
        }
        return textViewText
    }


    private fun calculateResult() {
        var sum = 0;
        if (textViewText.last() != '+') {
            val sayilar = textViewText.splitToSequence('+')
            for (sayi in sayilar) {
                var addedInt= sayi.toIntOrNull()
                if (addedInt !=null){
                    sum += sayi.toInt()

                }else{
                    Snackbar.make(binding.resultTextView,"Üst sınıra ulaşıldı, lütfen ifadenizi kontrol ediniz.",Snackbar.LENGTH_SHORT).show()
                    sum=0
                    break
                }
            }
            if (sum> 2147483646){
                Snackbar.make(binding.resultTextView,"Hesaplama sonrası üst sınıra ulaşıldı, lütfen ifadenizi kontrol ediniz.",Snackbar.LENGTH_SHORT).show()
                sum=0
            }
            textViewText = sum.toString()
            binding.resultTextView.text = textViewText


        } else {
            Snackbar.make(binding.resultTextView,"Hata meydana geldi, lütfen ifadenizi kontrol ediniz.",Snackbar.LENGTH_SHORT).show()
        }
    }
}


