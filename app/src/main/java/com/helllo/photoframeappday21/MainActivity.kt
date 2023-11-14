package com.helllo.photoframeappday21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //Yha maine ek "var" type ka variable bnaya h, jaisa ki hum jante h ki "var" type ka variable hum tabhi
    //bnate h jab hame pta h ki iss variable ki value change hogi, agar change nahi hoti to hum "val" use karte
    //Kotlin me "variable" ko initialize karne ke baad hame, other Programming lang. ki tarah next line me jane
    //keliye koi semi colon lagane ki jarurat nahi h

    //Yaha per maine "pic" ki Count ko "0" se initialize kiya h
    var currentImage = 0

    lateinit var image : ImageView

    //Yha per maine ek Array bnaya h, names naam ka, jisme koun se index pr koun se celebs h unka name diya huaa h
    var names = arrayOf("Virat Kohli", "Saumya Singh", "Malala", "Priyanka Chopra")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prev = findViewById<ImageButton>(R.id.imgPrev)

        val next = findViewById<ImageButton>(R.id.imgNext)

        val text = findViewById<TextView>(R.id.textView) //Yeh "textView" sabhi sabhi celebs ke Name dikhane ke liye use hua h





        //Yha maine Yeh btaya ki agar koi User Previos Button per click karta h to hame kya karna h
        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"  //yha maine current Position per jo pic h uska id/Address leliya as a String
                                                           //but hame aab "int" ke form me chaiye isiliye hum niche yeh code likhe h jo
                                                           //int ke form me data le rha h,by logic

            // convert string id into integer address associated with it
            //yha hum ek variable bnaye joki hame "Image ka current Position" bta rha h as aInteger form
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)

            image = findViewById(idCurrentImageInt)  //yha maine image joki "ImageView" h usko hamne initialize kiya joki, image ka integer
                                                     //value le rha h

            image.alpha= 0f   //Yha maine image ko "0f"(f = Float) kar diya jisse ki wo image na dikhe, alpha agar 0 h to hame wo image
                               //nahi dikhega

            //This the main Logic of the code, Yeh code me yeh ki, Hum kis image per h wo btao
            //Example :- agar hum "pic2" h to, humara "currentImage Position" ho gya "pic2", Aab mai niche iss code ke  logic ko
            //explain karne wala hu:-
            //hum pic2 per h to, according to formula, (4 + 2 - 1) % 4 equal to 2 aayega yani ki hum pic2 per hi h
            currentImage = (4+ currentImage-1)%4


            //Yha mai yeh bta rha hu ki koun sa "pic" dikh rha h uska String yani uss "pic" wale Person ka name dikha do
            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f   //Yha maine image ko "1f"(f = Float) kar diya jisse ki wo image dikhe, alpha agar 1 h to hame wo image
                              //dikhega

            text.text = names[currentImage]  //yha maine bola ki jo text h usko "names" array se uska Index lekar uss Index wale "pic" ke
                                             //saath mila do
        }



        //Yha bhi sab Uper wale code ki tarah same h bas Yaha yeh ki, Jab user Next per click karega to kya karna uska code likha hua h
        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (4+ currentImage+1)%4

            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImage]
        }
    }
}
