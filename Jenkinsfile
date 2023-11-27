pipeline {
  agent any
  stages {
    stage('') {
      steps {
        sh '''stage(\'Checkout\') {
            steps {
                checkout scm
            }
        }
        stage(\'Run Maven Project\') {
            parallel {
                stage(\'Maven Project\') {
                    steps {
                        script {
                            sh \'mvn clean test\'
                        }
                    }
                }
                stage(\'Get Maven Version\') {
                    steps {
                        script {
                            sh \'mvn --version\'
                        }
                    }
                }
            }
        }'''
        }
      }

    }
  }