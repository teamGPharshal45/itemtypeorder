plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.itemtype"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.itemtype"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    debugImplementation("androidx.test.ext:junit:1.3.0")
    implementation("com.google.code.gson:gson:2.13.1")



    var androidx_test_espresso = "3.7.0"
    debugImplementation("androidx.test.espresso:espresso-core:$androidx_test_espresso")
    debugImplementation("androidx.test.espresso:espresso-contrib:$androidx_test_espresso")
    debugImplementation("androidx.test.espresso:espresso-intents:$androidx_test_espresso")


    // androidx.test
    var androidx_test = "1.5.0"
    debugImplementation("androidx.test:runner:1.5.0")
    debugImplementation("androidx.test:core:$androidx_test")



    var fragment_version = "1.6.2" // must use for new factory stuff
    debugImplementation("androidx.fragment:fragment-testing:$fragment_version")
    debugImplementation ("androidx.fragment:fragment:$fragment_version")



    debugImplementation("org.mockito:mockito-core:5.19.0")
    debugImplementation("org.mockito:mockito-android:5.19.0")
}