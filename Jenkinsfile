pipeline {
  agent any
  stages {
    stage('get version') {
      parallel {
        stage('run maven proj') {
          steps {
            sh ''' stage(\'Run Maven Project\') {
                    steps {
                        script {
                            sh \'mvn clean install\'
                        }
                    }
                }'''
            }
          }

          stage('get version') {
            steps {
              sh ''' stage(\'Get Maven Version\') {
                    steps {
                        script {
                            sh \'mvn --version\'
                        }
                    }
                }'''
              }
            }

          }
        }

      }
    }