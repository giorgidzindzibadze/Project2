pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                deleteDir() // Clean workspace
                checkout scm
            }
        }

        stage('Run Maven Project and Get Version') {
            parallel {
                stage('Build and Test') {
                    steps {
                        script {
                            // Ensure Maven is in the system PATH
                            def mvnHome = tool 'Maven3'
                            bat "${mvnHome}/bin/mvn clean test"
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
        }
    }

    post {
        always {
            // Clean up workspace
            cleanWs()
        }
    }
}
