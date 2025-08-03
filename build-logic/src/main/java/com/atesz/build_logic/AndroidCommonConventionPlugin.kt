package com.atesz.build_logic

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidCommonConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.pluginManager.withPlugin("com.android.application") {
            project.extensions.configure<BaseAppModuleExtension> {
                configureAndroidCommon(this)
            }
        }

        project.pluginManager.withPlugin("com.android.library") {
            project.extensions.configure<LibraryExtension> {
                configureAndroidCommon(this)
            }
        }

        project.extensions.configure<KotlinAndroidProjectExtension> {
            jvmToolchain(21)
        }
    }

    private fun configureAndroidCommon(extension: com.android.build.api.dsl.CommonExtension<*, *, *, *, *, *>) {
        extension.compileSdk = 34

        extension.defaultConfig {
            minSdk = 31
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        extension.compileOptions {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }

        extension.packaging {
            resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
