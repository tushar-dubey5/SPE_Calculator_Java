pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/tushar-dubey5/SPE_Calculator_Java.git'
        DOCKER_HUB_USERNAME= 'tushar542001'

    }

    stages {
        stage('Clone Git') {
             script {
                    git branch: 'master',
                        credentialsId: 'github_credentials', 
                        url: "${GITHUB_REPO_URL}"
                }
        }

        stage('Build the Maven Project') {
            steps {
                // Build the Maven project
                sh 'mvn clean package'
            }
        }
        
        stage('Test the Maven project') { 
            steps {
                sh 'mvn test' 
            }
        }
         stage('Verify JAR Existence') {
            steps {
                sh 'ls -lh target/'   // Check if the JAR file is actually created
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                        withDockerRegistry([credentialsId: 'docker-hub-credential', url: '']){
                        sh "docker tag ${DOCKER_IMAGE_NAME} ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest"
                        sh "docker push ${DOCKER_HUB_USERNAME}/${DOCKER_IMAGE_NAME}:latest"
                    }
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                    )
                }
            }
        }
    }
}
