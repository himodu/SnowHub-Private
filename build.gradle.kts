import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.8.22"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-test:3.1.5")

	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.junit.platform:junit-platform-commons:1.10.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	implementation("org.jsoup:jsoup:1.17.1")
	implementation("org.projectlombok:lombok")

	implementation("org.apache.httpcomponents:httpclient:4.5.13")
	implementation("com.google.code.gson:gson:2.8.9")

	implementation("com.mysql:mysql-connector-j")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.bootBuildImage {
	builder.set("paketobuildpacks/builder-jammy-base:latest")
}

tasks.test {
	useJUnitPlatform()
}

tasks {
	bootJar {
		archiveBaseName.set("SpringWithKotlin")
		archiveVersion.set("0.0.1")
	}
}

