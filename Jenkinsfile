pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    // Checkout your branch
                    checkout([$class: 'GitSCM', branches: [[name: 'project_dev']], userRemoteConfigs: [[url: 'https://github.com/giorgidzindzibadze/Project2.git']]])
                }
            }
        }

        stage('Build and Get Version') {
            parallel {
                stage('Run Maven Project') {
                    steps {
                        script {
                            // Run Maven build using bat
                            bat 'mvn clean test'
                        }
                    }
                }

                stage('Get Maven Version') {
                    steps {
                        script {
                            // Get Maven version using bat
                            bat 'mvn --version'
                        }
                    }
                }
            }
        }
    }
}
