pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Run Maven Project') {
            parallel {
                stage('Maven Project') {
                    steps {
                        script {
                            bat 'mvn clean test'
                            bat 'mvn allure:report' 
                        }
                    }
                }
                stage('Get Maven Version') {
                    steps {
                        script {
                            bat 'mvn --version'
                        }
                    }
                }
            }
        }
    }
}
