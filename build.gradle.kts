
plugins {
    java
    scala
    application
    groovy
    kotlin("jvm") version "1.4.32"
    jacoco
}

repositories {
    mavenCentral()
}

dependencies{
//    implementation("commons-io:commons-io:+") //il + recupera l'ultima versione  della libreria è pericoloso usarlo
    implementation("org.scala-lang:scala-library:2.12.2")      //SCALA
    implementation("org.codehaus.groovy:groovy-all:2.4.15")    //GROOVY
    implementation(kotlin("stdlib"))                            //KOTLIN

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}


tasks.named<Test>("test") {
    useJUnitPlatform()
}

jacoco {
    applyTo(tasks.run.get())
}

tasks.register<JacocoReport>("applicationCodeCoverageReport") {
    executionData(tasks.run.get())
    sourceSets(sourceSets.main.get())
}

application {
    mainClass.set("CoucouKKt")
}
