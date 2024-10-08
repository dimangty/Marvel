plugins {
    id("config.LibraryConfigPlugin")
}

libraryConfig {
    namespace = "feature_characters"
    moduleUsesCompose = true
    moduleUsesHilt = true
}

dependencies {
    implementation(projects.core)
    implementation(projects.uiKit)
    implementation(projects.repoCharacters)
    implementation(projects.localPreferences)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
}