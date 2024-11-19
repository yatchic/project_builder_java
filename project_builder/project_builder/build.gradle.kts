plugins {
    id("java")
    id("application") // Для запуска приложений
    id("checkstyle") // Проверка качества кода
    id("pmd") // Для статического анализа кода
    id("jacoco") // Для отчета покрытия тестов
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google() // Для библиотек от Google
    maven { url = uri("https://jitpack.io") } // Для библиотек с JitPack
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
tasks.withType<JavaExec> {
    systemProperty("file.encoding", "UTF-8")
}


dependencies {

    compileOnly ("org.projectlombok:lombok:1.18.28")
    annotationProcessor ("org.projectlombok:lombok:1.18.28")



    implementation ("org.apache.httpcomponents.client5:httpclient5:5.3")
        implementation ("org.slf4j:slf4j-api:2.0.0-alpha1")
        implementation ("ch.qos.logback:logback-classic:1.4.12")


    implementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.testng:testng:7.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.apache.commons:commons-lang3:3.12.0")  // Утилиты Apache Commons
    implementation("com.google.guava:guava:32.1.2-jre")  // Google Guava
    implementation("org.slf4j:slf4j-api:2.0.9")  // Логирование
    implementation("com.google.code.gson:gson:2.10.1")  // JSON библиотека
    implementation("org.jetbrains:annotations:24.0.1") // Аннотации JetBrains

    // Работа с HTTP
    implementation("org.apache.httpcomponents.client5:httpclient5:5.1")


    // Тестирование
    testImplementation("junit:junit:4.13.2") // JUnit 4 для совместимости
    testImplementation("org.mockito:mockito-core:5.5.0") // Мокирование
    testImplementation("org.assertj:assertj-core:3.24.2") // Ассерции

    // Локальный сервер для тестирования
    testImplementation("com.github.tomakehurst:wiremock:3.0.1")
}

tasks.test {
    useJUnitPlatform()
}