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
                    // Construye la imagen Docker
                    sh 'docker build -t ms-dockerization-2 .'
                }
            }
        }
        stage('Build Docker Container') {
            steps {
                script {
                    // Define el nombre del contenedor
                    def containerName = 'ms-dockerization-2'
                    
                    // Obtén el ID del contenedor en ejecución, si existe
                    def containerId = sh(script: "docker ps -q -f name=${containerName}", returnStdout: true).trim()

                    if (containerId) {
                        echo "Contenedor en ejecución con ID: ${containerId}"
                        // Detén y elimina el contenedor viejo si existe
                        sh "docker stop ${containerId}"
                        sh "docker rm ${containerId}"
                    } 

                    // Ejecuta el nuevo contenedor
                    sh 'docker run -d -p 50523:50600 --name ms-dockerization-2 ms-dockerization-2 --network network-system'
                }
            }
        }
    }
}
