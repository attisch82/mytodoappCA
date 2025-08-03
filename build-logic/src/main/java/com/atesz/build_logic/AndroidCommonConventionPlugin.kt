package com.atesz.build_logic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class AndroidCommonConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val androidPluginIds = listOf("com.android.application", "com.android.library")

        androidPluginIds.forEach { pluginId ->
            target.pluginManager.withPlugin(pluginId) {
                configureCommonExtension(target)
            }
        }
    }
    private fun configureCommonExtension(project: Project) {
        project.extensions.configure<CommonExtension<*, *, *, *, *, *>> {
            compileSdk = 34

            defaultConfig {
                minSdk = 31
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }

            packaging {
                resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
        project.extensions.configure<KotlinAndroidProjectExtension> {
            jvmToolchain(21)
        }
    }
}