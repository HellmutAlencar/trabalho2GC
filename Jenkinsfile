pipeline {
    agent any
    stages {
        stage('Checkout Codebase') {
            steps {
                cleanWs()
                checkout scm: [
                    $class: 'GitSCM', 
                    branches: [
                        [name: '*/main']
                    ],
                    userRemoteConfigs: [
                        [credentialsId: 'trabalho-GC', url: 'git@github.com:HellmutAlencar/trabalho2GC.git']
                    ]
                ]
            }
        }
        stage('Source Code Lint') {
            steps {
                sh 'java -jar stuff/checkstyle-10.12.4-all.jar -c stuff/checkstyle-config.xml .'
            }
        }
        stage('Build') {
            steps {
                sh 'mkdir lib'
                sh 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                sh 'cd src ; javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" TemperatureConverterTest.java TemperatureConverter.java App.java'
            }
        }
        stage('Test') {
            steps {
                sh 'cd src/ ; java -jar ../lib/junit-platform-console-standalone-1.7.0-all.jar -cp "." --select-class TemperatureConverterTest --reports-dir="reports"'
                junit 'src/reports/*-jupiter.xml'
            }
        }
        stage('Code Coverage') {
            steps {
                sh 'cd src ; java -javaagent:stuff/jacocoagent.jar -cp .:lib/junit-platform-console-standalone-1.7.0-all.jar org.junit.platform.console.ConsoleLauncher --select-class TemperatureConverterTest --reports-dir="reports/jacoco"'
            }
            post {
                always {
                    archiveArtifacts 'src/reports/jacoco/*'
                    cobertura(coberturaReportFile: 'src/reports/jacoco/jacoco.xml')
                }
            }
        }
    }
}