pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/tushar-dubey5/SPE_Calculator_Java.git'
        DOCKER_HUB_CREDENTIALS = 'eefd2860-3c6b-425f-b351-76af9a1c93c6'
        DOCKER_HUB_USERNAME = 'tushar542001'
    }

    stages {
        stage('Clone Git') {
            steps {
                git branch: 'master', url: "${GITHUB_REPO_URL}"
            }
        }

        stage('Build Java Code') {
            steps {
                sh 'javac Calculator.java'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore CalculatorTest'
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
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_HUB_CREDENTIALS) {
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
