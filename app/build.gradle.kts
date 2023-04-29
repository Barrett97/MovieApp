plugins {
    kotlin("kapt")
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.android)
//    id("com.google.devtools.ksp")
}

val api_key = project.property("API_KEY") as String

android {
    namespace = "com.tranbarret.movielist"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.tranbarret.movielist"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "API_KEY", api_key)

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // groovy
//        javaCompileOptions {
//            annotationProcessorOptions {
//                arguments += ["room.schemaLocation": "$projectDir/schemas".toString()]
//            }
//        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.rxjava)
    implementation(libs.glide)
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.converter.gson)
    implementation(libs.coroutines)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.1")
    implementation("io.reactivex.rxjava3:rxjava:3.1.6")
//    implementation("androidx.paging:paging-runtime:3.1.1")
    implementation("androidx.room:room-ktx:2.5.1")
    kapt("androidx.room:room-compiler:2.5.1")
//    implementation("androidx.room:room-paging:2.5.1")
//    implementation("androidx.paging:paging-compose:1.0.0-alpha18")

    val composeBom = platform("androidx.compose:compose-bom:2023.03.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.activity:activity-compose:1.7.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.compose.runtime:runtime-rxjava2")
    implementation("com.squareup.moshi:moshi:1.14.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("io.coil-kt:coil:2.3.0")
    implementation("io.coil-kt:coil-compose:2.3.0")
    implementation("io.coil-kt:coil-svg:2.3.0")
//    implementation("com.google.dagger:dagger:2.45")


//    implementation("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}