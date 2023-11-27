pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                deleteDir() // Clean workspace
                checkout scm
            }
        }

        stage('Run Maven Project') {
            parallel {
                stage('Build and Test') {
                    steps {
                        script {
                            def mvnHome = tool 'Maven3'
                            bat "${mvnHome}/bin/mvn clean test"
                        }
                    }
                }

                stage('Allure Report') {
                    steps {
                        script {
                            def mvnHome = tool 'Maven3'
                            bat "${mvnHome}/bin/mvn allure:report"
                        }
                        post {
                            always {
                                allure([
                                    includeProperties: false,
                                    jdk: '',
                                    results: [[path: 'target/allure-results']]
                                ])
                            }
                        }
                    }
                }
            }
        }

        stage('Get Maven Version') {
            steps {
                script {
                    def mvnHome = tool 'Maven3'
                    bat "${mvnHome}/bin/mvn --version"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
