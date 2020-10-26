plugins {
    java
    kotlin("jvm") version "1.3.72"
}

group = "io.github.krs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("io.projectreactor:reactor-core:3.3.10.RELEASE")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions:1.1.0")
    testCompile("junit", "junit", "4.12")
}
