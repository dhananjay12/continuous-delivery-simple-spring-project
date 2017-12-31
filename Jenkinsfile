node("") {
    stage("build") {
        git("https://github.com/dhananjay12/continuous-delivery-simple-spring-project.git")
        sh("./mvnw clean install")
    }
    stage("deploy") {
        echo("Deploying the artifact")
    }
    stage("results") {
        junit("**/target/surefire-reports/TEST-*.xml")
        archive("target/*.jar")
    }
}