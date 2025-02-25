pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = 'scientific-calculator'
        GITHUB_REPO_URL = 'https://github.com/tushar-dubey5/Scientific_Calculator.git'
        DOCKER_HUB_CREDENTIALS = 'eefd2860-3c6b-425f-b351-76af9a1c93c6'
        DOCKER_HUB_USERNAME = 'tushar542001'
    }

    stages {
        stage('Clone Git') {
            steps {
                git branch: 'main', url: "${GITHUB_REPO_URL}"
            }
        }

        stage('Build and Test with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Run Tests in Docker') {
            steps {
                script {
                    sh "docker run --rm ${DOCKER_IMAGE_NAME} java -jar /app/scientific-calculator-1.0-SNAPSHOT.jar"
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
