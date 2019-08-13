pipeline {
  agent {
    docker {
      image 'maven:3.6.1-jdk-11-slim'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        echo 'This is  a minimal pipeline'
        sh 'mvn -B -DskipTests clean package'
      }
    }
  }
}