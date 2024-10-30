pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Use SSH URL and provide credentialsId for SSH authentication
                git url: 'git@github.com:Fahad7532/TaskManager.git', credentialsId: 'github-private-key'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        success {
            echo 'Build and tests ran successfully.'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
