@file:Suppress("UnstableApiUsage")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "claiborne"

includeBuild("gradle-scripts")

include("internal:dining-api")
