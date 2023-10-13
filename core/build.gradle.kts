import com.badlogic.gdx.tools.texturepacker.TexturePacker

plugins {
    `java-library`
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.spotless)
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(11)) }
}

val assetsDir = rootProject.files("assets")

sourceSets.main.configure {
    resources.srcDir(assetsDir)
}

spotless {
    isEnforceCheck = false
    kotlin {
        ktlint("1.0.0")
    }
}

val packTextures = tasks.register("packTextures") {
    val inputDir = "$rootDir/raw-assets/images"
    val outputDir = "$rootDir/assets/images"
    inputs.dir(inputDir)
    outputs.dir(outputDir)
    doLast {
        delete(outputDir)
        TexturePacker.process(TexturePacker.Settings().apply {
            combineSubdirectories = true
        }, inputDir, outputDir, "images.pack")
    }
}

tasks.processResources.configure {
    dependsOn(packTextures)
}

tasks.compileJava.configure {
    options.encoding = "UTF-8"
}

dependencies {
    implementation(libs.dagger.core)
    kapt(libs.dagger.compiler)
    api(libs.gdx.core)
    implementation(libs.gdx.ai)
    implementation(libs.ktx.actors)
    api(libs.ktx.app)
    implementation(libs.ktx.graphics)
    implementation(libs.ktx.math)
    implementation(libs.ktx.vis)
    implementation(libs.textratypist)
}
