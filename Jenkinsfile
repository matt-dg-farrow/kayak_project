pipeline {
    agent any
    environment {
    	DOCKER_USER = credentials('docker-login')
    	}
    stages {
        stage('--Mvn clean package--') {
                steps {
                    sh "mvn clean package deploy"
                    }
            }
            stage('--Build back-end--') {
                steps {
                    sh "docker build -t 9953136/app-matt ."
                    }
            }
        stage('--Dockerise--') {
              steps {
                    withDockerRegistry([ credentialsId: "docker-login", url: "" ]) {
                    sh "docker push 9953136/app-matt"
                    }
              }
         }
    }
}