
pipeline {
    agent none

    stages {
        stage('Hello') {
            environment {
                GITEE_API_TOKEN = credentials('GITEE_API_TOKEN_FOR_RUYISDK_GITEE_MIRROR')
            }

            steps {
                sh 'env'
            }
        }
    }
}

