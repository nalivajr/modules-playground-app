import java.io.FileInputStream
import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            val keyPropertiesFile = File("local.properties")
            val keyProperties = Properties()
            keyProperties.load(FileInputStream(keyPropertiesFile))

            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/nalivajr/modules-playground-logger")
            credentials {
                username = keyProperties.get("GIT_USER").toString()
                password = keyProperties.get("GIT_TOKEN").toString()
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "playground-app"
include(":app")
 