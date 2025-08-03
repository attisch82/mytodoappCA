package com.atesz.build_logic

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("com.atesz.android.common")
            }
            extensions.configure<ApplicationExtension> {
                buildFeatures {
                    compose = true
                }
                defaultConfig {
                    applicationId = "com.atesz.mytodoapp"
                }
            }
        }
    }
}