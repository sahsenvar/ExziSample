plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinxSerialization)
}

android {
    namespace = "com.sahansenvar.exzicasestudy"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sahansenvar.exzicasestudy"
        minSdk = 26
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    
    buildFeatures { 
        compose = true
    }

    ksp {
        arg("KOIN_DEFAULT_MODULE","false")
    }

    sourceSets["main"].res.srcDirs("$projectDir/core/resource/src/main/res")
}

dependencies {
    // Modules
    implementation(project(":core:common"))
    implementation(project(":core:remote"))
    implementation(project(":core:resource"))

    implementation(project(":feature:orderbook:data"))
    implementation(project(":feature:orderbook:domain"))
    implementation(project(":feature:orderbook:presentation"))

    implementation(project(":feature:trading:data"))
    implementation(project(":feature:trading:domain"))
    implementation(project(":feature:trading:presentation"))

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)

    implementation(libs.kotlinx.serialization)

    //Flipper
    implementation("com.facebook.flipper:flipper:0.176.1")
    implementation("com.facebook.flipper:flipper-network-plugin:0.176.1")
    implementation("com.facebook.soloader:soloader:0.10.4")

    // Koin
    implementation(libs.koin.core)
    implementation(libs.koin.anotation)
    ksp(libs.koin.kspCompiler)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}