node("") {
    stage("build") {
        git("https://github.com/dhananjay12/ci-cd-spring-project.git")
        sh("mvn clean install")
    }
    stage("deploy") {
        echo("Deploying the artifact")
    }
    stage("results") {
        junit("**/target/surefire-reports/TEST-*.xml")
        archive("target/*.jar")
    }
}
