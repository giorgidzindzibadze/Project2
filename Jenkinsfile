pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                deleteDir() 
                checkout scm
            }
        }
        stage('Run Maven Project') {
            parallel {
                stage('Maven Project') {
                    steps {
                        script {
                            sh 'mvn clean test'
                            sh 'mvn allure:report' 
                        }
                    }
                }
                stage('Get Maven Version') {
                    steps {
                        script {
                            sh 'mvn --version'
                        }
                    }
                }
            }
        }
    }
}
