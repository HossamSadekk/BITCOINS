object Config {
    const val minSdk = 23
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "1.0"
    const val compileSdk = 33
    const val applicationId = "com.example.cleanarchitecture"
}

object Versions {
    const val androidx_core = "1.7.0"
    const val compose_version = "1.2.0-beta01"
    const val lifecycle_runtime_ktx = "2.3.1"
    const val activity_compose = "1.3.1"
    const val junit = "4.13.2"
    const val androidx_test_ext = "1.1.3"
    const val test_espresso = "3.4.0"
    const val appcompat = "1.5.0"
    const val lifecycle_viewmodel_compose = "1.0.0-alpha07"
    // navigation
    const val navigation_compose = "2.4.0-alpha08"
    const val accompanist_flowlayout = "0.17.0"
    // coroutine
    const val kotlinx_coroutines_core = "1.5.1"
    const val kotlinx_coroutines_android = "1.5.1"
    const val lifecycle_viewmodel_ktx = "2.5.1"
    const val coroutine_lifecycle_runtime_ktx = "2.5.1"
    //hilt
    const val hilt_android = "2.38.1"
    const val hilt_compiler = "1.0.0"
    const val hilt_android_compiler = "2.38.1"
    const val hilt_lifecycle_viewmodel = "1.0.0-alpha03"
    const val hilt_navigation_compose = "1.0.0"
    // retrofit
    const val retrofit = "2.9.0"
    const val converter_gson = "2.9.0"
    const val okhttp3 = "5.0.0-alpha.2"
    const val logging_interceptor = "5.0.0-alpha.2"
    const val material = "1.6.1"
}

object Dependencies {
    val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    val compose_ui = "androidx.compose.ui:ui:${Versions.compose_version}"
    val compose_material = "androidx.compose.material:material:${Versions.compose_version}"
    val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}"
    val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime_ktx}"
    val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose}"
    val junit = "junit:junit:${Versions.junit}"
    val androidx_test_ext = "androidx.test.ext:junit:${Versions.androidx_test_ext}"
    val test_espresso = "androidx.test.espresso:espresso-core:${Versions.test_espresso}"
    val ui_test_junit4 = "androidx.test.espresso:espresso-core:${Versions.compose_version}"
    val ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose_version}"
    val lifecycle_viewmodel_compose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle_viewmodel_compose}"
    val navigation_compose = "androidx.navigation:navigation-compose:${Versions.navigation_compose}"
    val accompanist_flowlayout = "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist_flowlayout}"
    val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines_core}"
    val kotlinx_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines_android}"
    val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_viewmodel_ktx}"
    val coroutine_lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.coroutine_lifecycle_runtime_ktx}"

    val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    val hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler}"
    val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android_compiler}"
    val hilt_lifecycle_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_lifecycle_viewmodel}"
    val hilt_navigation_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_navigation_compose}"


    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.converter_gson}"
    val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    val logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_interceptor}"
    val material = "om.google.android.material:material:${Versions.material}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
}
object Modules {
    const val CORE = ":core"
}