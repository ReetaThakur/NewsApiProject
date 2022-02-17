
# News App Readme file

This is documentation for news  app. what I used for building this app those all things are in this file.


## Screenshots
![App Screenshot](https://raw.githubusercontent.com/ReetaThakur/NewsApiProject/6abe96aade59a29c56b33ba5fdd86aee2ec00e91/Screenshot_20220217_210618.png)

![App Screenshot](https://raw.githubusercontent.com/ReetaThakur/NewsApiProject/6abe96aade59a29c56b33ba5fdd86aee2ec00e91/Screenshot_20220217_210629.png)




## Dependencies

   implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    //Retrofit
    def retrofit2_version = "2.9.0"
    def okhttp3_version = "4.9.0"
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.5.0'
    implementation "com.squareup.retrofit2:retrofit:$retrofit2_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    implementation "com.squareup.okhttp3:okhttp:$okhttp3_version"
    //hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
    implementation 'androidx.activity:activity-ktx:1.4.0'

    implementation 'org.ocpsoft.prettytime:prettytime:4.0.4.Final'

    //glide
    implementation 'com.github.bumptech.glide:glide:4.13.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.13.0'

    // ViewModel and LiveData
    def arch_version = '2.2.0-alpha01'
    implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.4.1"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'

## Description
This is the a news app where you can see the news with there image. News are
with there time, source , title, Description and image. If you want to search
news according your choice you can do this also.

Video Link ---  https://drive.google.com/file/d/1yRb1cGz_FWIfz4nZDOt2jZMjZZ99-Toh/view
