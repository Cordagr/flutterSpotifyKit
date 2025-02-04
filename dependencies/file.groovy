plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android' // If you're using Kotlin, otherwise adjust accordingly
}

android {
    compileSdk 33

    defaultConfig {
        applicationId "com.example.flutterSpotifyKit"
        minSdk 21
        targetSdk 33
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.4.0'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'com.squareup.okhttp3:okhttp:4.9.3'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.2'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}
