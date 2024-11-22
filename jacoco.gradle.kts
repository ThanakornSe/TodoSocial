val exclusions =
    listOf(
        "**/R.class",
        "**/R\$*.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Test*.*",
        "**/NewRelicConfig.class",
        "**/*Binding.class",
        "**/*Module*.class",
        "**/*Application*.class",
        "**/*Screen*.class",
        "**/*Activity*.class",
        "**/*Fragment.class",
        "**/LiveLiterals*.class",
        "**/*Firebase*.class",
        "**/*ViewModel*.class",
        "**/*Service*.class",
        "**/*Navigate*.class",
    )

tasks.register<JacocoReport>("JacocoDevelopCodeCoverage") {
    dependsOn("testDevelopDebugUnitTest")
    group = "Reporting"
    description = "Execute ui and unit tests, generate and combine Jacoco coverage report"
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
    sourceDirectories.setFrom(layout.projectDirectory.dir("src/main"))
    classDirectories.setFrom(
        files(
            fileTree(layout.buildDirectory.dir("intermediates/javac/")) {
                exclude(exclusions)
            },
            fileTree(layout.buildDirectory.dir("tmp/kotlin-classes/")) {
                exclude(exclusions)
            },
        ),
    )
    executionData.setFrom(
        files(
            fileTree(layout.buildDirectory) { include(listOf("**/*.exec", "**/*.ec")) },
        ),
    )
}
