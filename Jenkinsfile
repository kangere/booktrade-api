pipeline {
  agent {
    docker {
      image 'maven:3.3.3'
    }

  }
  stages {
    stage('Build') {
      steps {
        echo 'This is  a minimal pipeline'
        sh '''mvn clean package
'''
      }
    }
  }
}