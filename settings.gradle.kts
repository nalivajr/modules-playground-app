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
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            val keyPropertiesFile = File("local.properties")
            val keyProperties = java.util.Properties()
            keyProperties.load(java.io.FileInputStream(keyPropertiesFile))

            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/nalivajr/modules-playground-logger")
            credentials {
                username = keyProperties["GIT_USER"].toString()
                password = keyProperties["GIT_TOKEN"].toString()
            }
        }
    }
}

rootProject.name = "playground-app"
include(":app")
