
pipeline {
    agent any

    stages {
        stage('Sync gitee repo') {
            environment {
                GITEE_API_TOKEN = credentials('GITEE_API_TOKEN_FOR_RUYISDK_GITEE_MIRROR')
                GITEE_REPO = 'ruyisdk/ruyi-gitee-mirror'
                GITHUB_REPO = "https://github.com/weilinfox/ruyi-gitee-mirror.git"
            }

            steps {
                sh 'git clone https://${GITEE_APT_TOKEN_USR}:${GITEE_API_TOKEN_PSW}@gitee.com/${GITEE_REPO}.git orig --depth=1'
                sh 'cd orig && git pull https://github.com/weilinfox/ruyi-gitee-mirror.git'
                sh 'cd orig && git push'
                sh 'cd orig && git push --tags'
            }
        }
    }
}

