package com.example.flutter_application_2







import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd


import androidx.core.view.WindowCompat
import io.flutter.embedding.android.FlutterActivity

class MainActivity : FlutterActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    // Aligns the Flutter view vertically with the window.
    WindowCompat.setDecorFitsSystemWindows(getWindow(), false)


     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
       // Disable the Android splash screen fade out animation to avoid
       // a flicker before the similar frame is drawn in Flutter.
       splashScreen.setOnExitAnimationListener {

        splashScreenView -> //splashScreenView.remove() //REMOVE FADE OUT ANIMATION

//Set animation
         val slideUp = ObjectAnimator.ofFloat(
           splashScreenView,
           View.TRANSLATION_Y,
           0f,
           -splashScreenView.height.toFloat()
         )
         slideUp.interpolator = AnticipateInterpolator()
         slideUp.duration = 200L

         // Call SplashScreenView.remove at the end of your custom animation.
         slideUp.doOnEnd { splashScreenView.remove() }

         // Run your animation.
         slideUp.start()


       }

     }


    super.onCreate(savedInstanceState)
  }
}