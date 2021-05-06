plugins {
    java
    scala
    application
    groovy
    kotlin("jvm") version "1.4.32"
    jacoco
    pmd
//  checkstyle
}

repositories {
    mavenCentral()
}

dependencies{
    //implementation("commons-io:commons-io:+") //il + recupera l'ultima versione  della libreria è pericoloso usarlo
    implementation("org.scala-lang:scala-library:2.12.2")      //SCALA
    implementation("org.codehaus.groovy:groovy-all:2.4.15")    //GROOVY

    implementation(kotlin("stdlib"))                                    //KOTLIN-kt
    implementation(kotlin("script-runtime"))                            //KOTLIN-kts
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

//mainClass.set() requires the qualified name of class: pkg.class
application {
    //NB It usesless to add more then one class here because in output print show just the last result
    mainClass.set("Coucou")
    mainClass.set("CoucouKt")                       //If I am using a kt script there is no name crashing problem with class
                                                    // that have the same name but are located in different packages
                                                    // because it automatically adds KT after the class name
                                                    //Becarefull it is part of the qualified name

    mainClass.set("tmp.pippo.plutp.paperinp.Main")//if I do not create the directories hierarchy,
                                                    // but I just specify it within the class after "pkg"
                                                    //Intellij gets angry because I am not following the naming conventions etc.
                                                    //however gradlew compiles, as long as the qualified name is correct,
                                                    // it manages to execute the code
}
/*

 */
