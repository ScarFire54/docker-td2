pipeline {
    agent any

    stages {

        stage('Downloading git'){
            steps {
                script {
                    echo 'Getting data from github...'
                    sh 'git clone https://github.com/ScarFire54/docker-td2.git'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo 'Building project...'
                    sh 'docker-compose build'
                }
            }
        }

        stage('Run Docker Container') {
            steps {
                script {
                    echo 'Running project...'
                    sh 'docker-compose up -d'
                }
            }
        }

        stage('Run Test') {
            steps {
                script {
                    echo 'Testing Curl...'
                    sh 'curl -s -o /dev/null -w "%200" http://localhost:8081/center/'
                }
            }
        }
    }
}