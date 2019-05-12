node("") {

    stage("build") {
        git("https://github.com/dhananjay12/ci-cd-spring-project.git")
        steps {
            withMaven(maven: 'maven_3.6.1') {
                sh """
                   mvn verify
                   """
            }
        }

    }
    stage("deploy") {
        echo("Deploying the artifact")
    }
    stage("results") {
        junit("**/target/surefire-reports/TEST-*.xml")
        archive("target/*.jar")
    }
}
