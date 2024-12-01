plugins {
    id("java")
}

group = "jaeger.de.miel"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

abstract class CopyHooks : DefaultTask() {
    @TaskAction
    fun action() {
        File("hooks").listFiles()?.forEach { f ->
            val filename = f.name
            val destination = ".git/hooks/$filename"
            println("Copying $filename")
            f.copyTo(File(destination), true)
        }

        println()
        File(".git/hooks").listFiles()?.forEach { f ->
            val filename = f.name
            if (!filename.endsWith(".sample")) {
                println(f)
            }
        }
    }
}

abstract class ResetHooks : DefaultTask() {
    @TaskAction
    fun action() {
        File(".git/hooks").listFiles()?.forEach { f ->
            val filename = f.name
            if (!filename.endsWith(".sample")) {
                println("Deleting: $filename")
                f.delete()
            }
        }
    }
}


tasks.register<CopyHooks>("copyHooks")
tasks.register<ResetHooks>("resetHooks")
