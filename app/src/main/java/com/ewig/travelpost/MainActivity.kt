package com.ewig.travelpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ewig.travelpost.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}





       /* fun fragment1(view: View){
            val fragmentManager=supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            val firstFragment = Fragment1()
            fragmentTransaction.replace(R.id.frameLayout,firstFragment).commit()
        }
        fun fragment2(view:View){
            val fragmentManager=supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            val secondFragment = Fragment2()
            fragmentTransaction.replace(R.id.frameLayout,secondFragment).commit()
    }*/

