plugins {
    `kotlin-dsl`
}

group = "com.atesz.buildlogic"

repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        register("androidCommon") {
            id = "com.atesz.android.common"
            implementationClass = "com.atesz.buildlogic.AndroidCommonConventionPlugin"
        }
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:8.12.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
}