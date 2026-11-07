plugins {
    id("java-library")
    id("maven-publish")
}

tasks.jar {
    archiveBaseName.set(providers.gradleProperty("projectName"))
    archiveVersion.set(providers.gradleProperty("projectVersion"))
    archiveClassifier.set("")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}