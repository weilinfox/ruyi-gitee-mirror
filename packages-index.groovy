
pipeline {
    agent any

    stages {
        stage('Sync gitee repo') {
            environment {
                GITEE_API_TOKEN = credentials('GITEE_API_TOKEN_FOR_RUYISDK_GITEE_MIRROR')
                GITEE_REPO = 'ruyisdk/packages-index'
                GITHUB_REPO = "ruyisdk/packages-index"
            }

            steps {
                sh '[ -e orig ] && rm -rf orig'
                sh 'git clone https://${GITEE_API_TOKEN}@gitee.com/${GITEE_REPO}.git orig --depth=1'
                sh 'cd orig && git pull https://github.com/${GITHUB_REPO}.git'
                sh 'cd orig && git push'
                sh 'cd orig && git push --tags'
            }

            post {
                always {
                    cleanWs()
                }
            }
        }
    }
}

