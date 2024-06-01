plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.sahansenvar.core.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    kotlinOptions {
        jvmTarget = "1.8"
    }

    ksp {
        arg("KOIN_DEFAULT_MODULE","false")
    }
}

dependencies {
    // Modules
    implementation(project(":core:common"))

    //OkHttp
    implementation(platform(libs.okhttp3.bom))
    implementation(libs.okhttp3.core)
    implementation(libs.okhttp3.loggingInterceptor)

    // Retrofit
    api(libs.retrofit.core)
    implementation(libs.retrofit.coroutine)

    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.anotation)
    ksp(libs.koin.kspCompiler)

    // Coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // Kotlinx Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    api("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")

    implementation("com.facebook.flipper:flipper:0.176.1")
    implementation("com.facebook.flipper:flipper-network-plugin:0.176.1")
    implementation("com.facebook.soloader:soloader:0.10.4")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}