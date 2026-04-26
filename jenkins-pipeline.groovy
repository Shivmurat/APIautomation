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
        
        // TestNG results
        junit 'target/surefire-reports/*.xml'

        // Extent HTML report (dynamic folder)
        publishHTML([
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'reports',
            reportFiles: '*/API_Execution_Automation.html',
            reportName: 'Extent Report'
        ])    
        }
        failure {
            echo 'Tests failed'
        }
    }
}
