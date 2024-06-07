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
    }
}

rootProject.name = "ExziCaseStudy"
include(":app")
include(":core:remote")

include(
    ":feature:trading:data",
    ":feature:trading:domain",
    ":feature:trading:presentation"
)
include(
    ":feature:orderbook:data",
    ":feature:orderbook:domain",
    ":feature:orderbook:presentation"
)
include(":core:common")
include(":core:resource")
