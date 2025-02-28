pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'vaibhav48/scientific-calculator'
    }

    stages {
        stage('Clone Repository') {
            steps {
//                 git 'https://github.com/VaibhavDewangan48/Scientific-Calculator.git'
                   git branch: 'main', credentialsId: 'github-credentials', url: 'https://github.com/VaibhavDewangan48/Scientific-Calculator.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
//                 sh 'docker build -t $DOCKER_IMAGE .'
                    sh 'ls -l target/'  // Debugging step
                    sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
               withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                           sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                           sh 'docker push $DOCKER_IMAGE'
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory deploy.yml'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
