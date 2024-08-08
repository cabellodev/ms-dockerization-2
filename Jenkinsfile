pipeline {
    agent any
      environment {
        PATH = "/usr/local/bin:${env.PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
       
        stage('Build JAR') {
            steps {
                script {
                    // Ejecuta Maven para construir el archivo JAR
                    sh 'mvn clean package'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t ms-dockerization-2 .'
                }
            }
        }
        stage('Build Docker Container') {
            steps {
                script {
                    // Detener y eliminar el contenedor viejo si existe
                    def containerName = 'ms-dockerization-2'
                    def containerId = sh(script: "docker ps -q -f name=${containerName}", returnStdout: true).trim()

                    if (containerId) {
                        sh "docker stop ${containerId}"
                        sh "docker rm ${containerId}"
                    }

                    sh 'docker run -d -p 50523:50600 --name ms-dockerization-2 ms-dockerization-2'
                }
            }
        }
    }
}
