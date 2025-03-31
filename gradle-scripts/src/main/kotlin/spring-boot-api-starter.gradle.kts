plugins {
    java
    jacoco
    id("org.springframework.boot")
    id("io.spring.dependency-management")

    id("org.springdoc.openapi-gradle-plugin")
}

dependencies {
    implementation(libs.bundles.spring.boot.starter.api)
    implementation(libs.bundles.spring.boot.starter.mybatis)

    developmentOnly(libs.spring.boot.devtools)
    annotationProcessor(libs.spring.boot.configuration.processor)

    testImplementation(libs.bundles.spring.boot.starter.test)
}

sourceSets {
    main {
        resources {
            srcDirs("src/main/java", "src/main/resources")
        }
    }
    test {
        resources {
            srcDirs("src/main/java", "src/main/resources")
            exclude("**/*.java")
        }
    }
}

tasks {
    compileJava {
        sourceCompatibility = "21"
    }

    processResources {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    test {
        useJUnitPlatform()
    }

    jacocoTestReport {
        reports {
            xml.required = true
        }
    }
}
