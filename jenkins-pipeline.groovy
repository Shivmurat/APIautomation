pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    stages {
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
            echo 'Pipeline completed'
            
            junit 'target/surefire-reports/*.xml'
        }
        failure {
            echo 'Tests failed'
        }
    }
}
