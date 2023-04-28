import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script
import kotlinx.html.title

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {

    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    kotlin("plugin.serialization") version "1.8.20"
}

group = "com.praveensmedia.pk"
version = "1.0-Beta_260523"


kobweb {
    app {
        index {

            description.set(
                "This is my personal portfolio website. " +
                        "This is an open source site. " +
                        "Designed and developed by Praveensmedia Labs. " +
                        "Thanks to Kotlin JS, Compose Web and Kobweb library"
            )
            head.add {
                script {
                    src ="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
                }
                link {
                    rel = "stylesheet"
                    href = "https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900"
                }
                //For SEO
                title("Open Source Portfolio website - Praveen Kumar Boddupalli")

                meta("keywords",
                    "#praveensmedia, praveen kumar portfolio, android developer portfolio, portfolio website, kotlin fullstack developer, opensource website, kobweb",
                    "utf-8"
                )
            }
        }
    }
}



kotlin {

    configAsKobwebApplication("pk")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk.core)
                implementation(libs.kobweb.silk.icons.fa)
             }
        }
    }
}