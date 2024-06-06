
pipeline {
    agent none

    stages {
        stage('Hello') {
            environment {
                GITEE_API_TOKEN = credentials('d7f8773e-2dd1-4d11-b723-11365c61e0a4')
            }

            steps {
                sh 'env'
            }
        }
    }
}

