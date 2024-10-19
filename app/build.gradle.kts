plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.newme"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.newme"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
//    implementing the dependency of the picasso app for the news images
    implementation ("com.squareup.picasso:picasso:2.8")
//    implementing the retrofit library to manage the request
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
//    implementing the json convertor for the retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}