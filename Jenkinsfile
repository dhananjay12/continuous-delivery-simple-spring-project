node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
        git 'https://github.com/dhananjay12/ci-cd-spring-project.git'
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'maven_3.6.1'
    }
    stage('Build') {
        sh "'${mvnHome}/bin/mvn' clean install"

    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
    }
}