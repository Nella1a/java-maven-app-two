def buildJar() {
    echo "building the application"
    sh 'mvn package'
}


def buildImage() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'PASS', usernameVariable: 'USER')])
            {
                sh 'docker build -t kanjamn/demo-app:jma-2.0.0 .'
                sh 'echo $PASS | docker login -u $USER --password-stdin'
                sh 'docker push kanjamn/demo-app:jma-2.0.0'
            }

}


def deployApp() {
    echo "Deploying the application ..."
}


return this